package commands.customerCommand;

import commands.AbstractCommand;
import entity.Rental;
import services.CustomerService;
import services.RentalService;

import java.util.List;
import java.util.Scanner;

public class AddRentalToCustomerCommand extends AbstractCommand {
    private static CustomerService customerService = CustomerService.getInstance();
    private static RentalService rentalService = RentalService.getInstance();
    private static AddRentalToCustomerCommand addRentalToCustomerCommand = new AddRentalToCustomerCommand();

    private AddRentalToCustomerCommand() {
    }

    public static AddRentalToCustomerCommand getInstance() {
        return addRentalToCustomerCommand;
    }

    @Override
    public String getCommandName() {
        return "addRentalToCustomer";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Rental> allRentals = rentalService.getAllRentals();
        if (!allRentals.isEmpty()) {
            System.out.println("Choose rental id to add to Customer");
            allRentals.forEach(System.out::println);
            String rentalId = scanner.nextLine();

            System.out.println("Enter Customer id to find");
            customerService.getAllCustomers().forEach(System.out::println);
            String customerId = scanner.nextLine();

            customerService.addRentalToCustomer(customerId, rentalId);
        } else {
            System.out.println("Rental list is empty");
        }
    }
}
