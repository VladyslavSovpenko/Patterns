package entity.prices;

public class RegularPrice implements Price {
    private static RegularPrice instance;

    private RegularPrice() {}

    public static RegularPrice getInstance() {
        if (instance == null) {
            instance = new RegularPrice();
        }

        return instance;
    }

    @Override
    public String getPriceName() {
        return "regular";
    }

    @Override
    public double getCharge(int daysRented) {
        double total = 2.0;

        if (daysRented > 2) {
            total += (daysRented - 2) * 1.5;
        }

        return total;
    }
}
