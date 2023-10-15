package commands.rentalCommand;

import commands.AbstractCommand;
import services.RentalService;

import java.util.Scanner;

public class GetRentalCommand extends AbstractCommand {

    private static RentalService rentalService = RentalService.getInstance();
    private static final GetRentalCommand getRentalCommand = new GetRentalCommand();

    private GetRentalCommand() {
    }

    public static GetRentalCommand getInstance() {
        return getRentalCommand;
    }

    @Override
    public String getCommandName() {
        return "getRental";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Rental id to find");
        System.out.println(rentalService.get(scanner.nextLine()));
    }
}
