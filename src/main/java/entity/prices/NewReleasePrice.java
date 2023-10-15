package entity.prices;

public class NewReleasePrice implements Price {
    private static NewReleasePrice instance;

    private NewReleasePrice() {
    }

    public static NewReleasePrice getInstance() {
        if (instance == null) {
            instance = new NewReleasePrice();
        }

        return instance;
    }

    @Override
    public String getPriceName() {
        return "newRelease";
    }

    public double getCharge(int daysRented) {
        return (daysRented * 3);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
