package entity.prices;

public interface Price {
    String getPriceName();

    double getCharge(int daysRented);

    default int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
