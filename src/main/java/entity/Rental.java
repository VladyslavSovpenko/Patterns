package entity;

public class Rental implements Entity {
    private int id = 0;
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.id = id++;
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    public int getId() {
        return id;
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
