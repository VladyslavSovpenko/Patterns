package commands.rentalCommand;

import commands.AbstractCommand;
import entity.Rental;
import services.RentalService;

import java.util.List;
import java.util.Scanner;

public class RemoveRentalCommand extends AbstractCommand {

    private static RentalService rentalService = RentalService.getInstance();
    private static final RemoveRentalCommand removeMovieCommand = new RemoveRentalCommand();

    private RemoveRentalCommand() {
    }

    public static RemoveRentalCommand getInstance() {
        return removeMovieCommand;
    }

    @Override
    public String getCommandName() {
        return "removeRental";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Rental> allRentals = rentalService.getAllRentals();
        if (!allRentals.isEmpty()) {
            allRentals.forEach(System.out::println);
            System.out.println("Enter Rental to remove");
            String rentalName = scanner.nextLine();
            rentalService.delete(rentalName);
        } else {
            System.out.println("Rental list is empty");
        }
    }
}
