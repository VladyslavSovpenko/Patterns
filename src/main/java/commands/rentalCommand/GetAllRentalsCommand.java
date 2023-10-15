package commands.rentalCommand;

import commands.AbstractCommand;
import entity.Rental;
import services.RentalService;

import java.util.List;
import java.util.Scanner;

public class GetAllRentalsCommand extends AbstractCommand {

    private static RentalService rentalService = RentalService.getInstance();
    private static GetAllRentalsCommand getAllRentalsCommand = new GetAllRentalsCommand();

    private GetAllRentalsCommand() {
    }

    public static GetAllRentalsCommand getInstance() {
        return getAllRentalsCommand;
    }

    @Override
    public String getCommandName() {
        return "getAllRental";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Rental> allRentals = rentalService.getAllRentals();
        if (!allRentals.isEmpty()) {
            allRentals.forEach(System.out::println);
        } else {
            System.out.println("Rental list is empty");
        }
    }
}
