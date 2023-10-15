package entity.prices;

import commands.customerCommand.AddRentalToCustomerCommand;

public class ChildrenPrice implements Price{

    private static ChildrenPrice childrenPrice = new ChildrenPrice();

    private ChildrenPrice() {}

    public static ChildrenPrice getInstance() {
        return childrenPrice;
    }

    public String getPriceName() {
        return "children";
    }

    public double getCharge(int daysRented) {
        double total = 1.5;

        if (daysRented > 3) {
            total += (daysRented - 3) * 1.5;
        }

        return total;
    }
}
