package entity;

import utils.ConfigReader;

public class Rental implements Entity {

    private static ConfigReader configReader = ConfigReader.getInstance();
    private static Integer nextId = configReader.getInt("rental");
    private Integer id;
    private Movie movie;
    private Integer daysRented;

    public Rental(Movie movie, Integer daysRented) {
        this.id = nextId++;
        configReader.set("rental", String.valueOf(nextId));
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Rental() {
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Integer getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(Integer daysRented) {
        this.daysRented = daysRented;
    }

    public double _charge() { return movie.getCharge(daysRented); }

    public int _frequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", movie=" + movie +
                ", daysRented=" + daysRented +
                '}';
    }
}
