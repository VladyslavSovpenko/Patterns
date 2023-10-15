package commands.customerCommand;

import commands.AbstractCommand;
import entity.Customer;
import services.CustomerService;

import java.util.List;
import java.util.Scanner;

public class GetRentalsCommand extends AbstractCommand {

    private static CustomerService customerService = CustomerService.getInstance();
    private static GetRentalsCommand getRentalsCommand = new GetRentalsCommand();

    private GetRentalsCommand() {
    }

    public static GetRentalsCommand getInstance() {
        return getRentalsCommand;
    }

    @Override
    public String getCommandName() {
        return "getCustomerRentals";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Customer id to find and get Statement\n");
        List<Customer> allCustomers = customerService.getAllCustomers();
        if (!allCustomers.isEmpty()) {
            allCustomers.forEach(w -> System.out.println("id: " + w.getId() + " name: " + w.getName()));
            Customer entity = ((Customer) customerService.get(scanner.nextLine()));
            System.out.println(entity.getRentals());
        } else {
            System.out.println("Customer list is empty");
        }


    }
}
