package services;

import entity.Customer;
import entity.Movie;
import entity.Rental;
import entity.prices.ChildrenPrice;
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
    private List<Price> prices = new ArrayList<>();

    private Warehouse() {
        prices.add(NewReleasePrice.getInstance());
        prices.add(RegularPrice.getInstance());
        prices.add(ChildrenPrice.getInstance());
    }

    public static Warehouse getInstance() {
        return warehouse;
    }

    // Customers method
    public void saveToCustomers(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerByName(String name) {
        return customers.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(new Customer());
    }

    public Customer getCustomerById(String name) {
        return customers.stream().filter(c -> c.getId() == (Integer.parseInt(name))).findFirst().orElse(new Customer());
    }

    public void deleteCustomer(String name) {
        Customer customer = customers.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
        customers.remove(customer);
    }

    // Rentals method
    public void saveToRentals(Rental rental) {
        rentals.add(rental);
    }

    public Rental getRentalById(String name) {
        return rentals.stream()
                .filter(c -> c.getId() == Integer.parseInt(name))
                .findFirst()
                .orElse(null);
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }

    // Movies method
    public Movie getMovieById(String name) {
        return movies.stream()
                .filter(c -> c.getId() == Integer.parseInt(name))
                .findFirst()
                .orElse(null);
    }

    public Movie getMovieByName(String name) {
        return movies.stream()
                .filter(c -> c.getTitle().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void saveToMovies(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public void deleteMovieByID(String name) {
        Movie movie = movies.stream()
                .filter(c -> c.getTitle().equals(name))
                .findFirst()
                .orElse(null);
        movies.remove(movie);
    }

    // Prices method
    public List<Price> getPrices() {
        return prices;
    }
}
