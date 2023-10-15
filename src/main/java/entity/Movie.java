package entity;

import entity.prices.Price;
import services.Warehouse;
import utils.ConfigReader;

import java.util.Optional;

public class Movie implements Entity {

    private static ConfigReader configReader = ConfigReader.getInstance();
    private static Integer nextId = configReader.getInt("movie");
    private Integer id;
    private String title;
    private String price;
    private Warehouse warehouse = Warehouse.getInstance();

    public Movie(String title, String price) {
        this.id = nextId++;
        configReader.set("movie", String.valueOf(nextId));
        this.title = title;
        this.price = price;
    }

    public Movie() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public double getCharge(int daysRented) {
        Optional<Integer> frequentRenterPoints = warehouse.getPrices().stream()
                .filter(p -> p.getPriceName().equals(price))
                .findFirst()
                .map(price -> price.getFrequentRenterPoints(daysRented));

        if (frequentRenterPoints.isPresent()) {
            return frequentRenterPoints.get();
        }
        return 0;
    }

    public int getFrequentRenterPoints(int daysRented) {
        Price matchedPrice = warehouse.getPrices().stream()
                .filter(p -> p.getPriceName().equals(price))
                .findFirst()
                .orElse(null);

        if (matchedPrice != null) {
            return matchedPrice.getFrequentRenterPoints(daysRented);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title=" + title +
                ", price=" + price +
                '}';
    }
}
