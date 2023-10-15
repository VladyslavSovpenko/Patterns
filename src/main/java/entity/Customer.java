package entity;

import utils.ConfigReader;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Entity {

    private static ConfigReader configReader = ConfigReader.getInstance();
    private static Integer nextId = configReader.getInt("customer");
    private Integer id;
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.id = nextId++;
        configReader.set("customer", String.valueOf(nextId));
        this.name = name;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String _getStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("Rental Record for ")
                .append(name)
                .append("\n\t")
                .append("Title")
                .append("\t\t")
                .append("Days")
                .append('\t')
                .append("Amount")
                .append('\n');
        for (Rental rental : rentals) {
            statement.append('\t')
                    .append(rental.getMovie()
                            .getTitle())
                    .append('\t')
                    .append('\t')
                    .append(rental.getDaysRented())
                    .append('\t')
                    .append('\t')
                    .append(rental._charge())
                    .append('\n');
        }
        statement.append("Amount owed is ")
                .append(getTotalCharge())
                .append('\n')
                .append("You earned ")
                .append(getTotalFrequentRenterPoints())
                .append(" frequent renter points");
        return statement.toString();
    }

    private double getTotalCharge() {
        double total = 0.0;
        for (Rental rental : rentals) {
            total += rental._charge();
        }
        return total;
    }

    private int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental rental : rentals) {
            total += rental._frequentRenterPoints();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", rentals=" + rentals +
                '}';
    }
}

