package services;

import entity.Customer;
import entity.Movie;
import entity.Rental;
import entity.prices.NewReleasePrice;
import entity.prices.Price;
import entity.prices.RegularPrice;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private static final Warehouse warehouse = new Warehouse();

    private List<Customer> customers = new ArrayList<>();
    private List<Rental> rentals = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();
    private List<Price> prices = new ArrayList<>() {{
        prices.add(NewReleasePrice.getInstance());
        prices.add(RegularPrice.getInstance());
        prices.add(NewReleasePrice.getInstance());
    }};

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return warehouse;
    }

    public void saveToCustomers(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerByName(String name) {
        return customers.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(new Customer());
    }

    public void deleteCustomer(String name) {
        Customer customer = customers.stream().filter(c -> c.getName().equals(name)).findFirst().get();
        customers.remove(customer);

    }

    public void saveToRentals(Rental rental) {
        rentals.add(rental);
    }

    public Rental getRentalByName(String name) {
        return rentals.stream().filter(c -> c.getId() == (Integer.parseInt(name))).findFirst().get();
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }

    public void saveToMovies(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public List<Price> getPrices() {
        return prices;
    }


}
