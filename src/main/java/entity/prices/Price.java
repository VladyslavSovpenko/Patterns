package entity.prices;

public abstract class Price {
    public String getPriceName() {
        return "default";
    }
    public abstract double getCharge(int daysRented);
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
