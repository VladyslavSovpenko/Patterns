package commands.customerCommand;

import commands.AbstractCommand;
import entity.Customer;
import services.CustomerService;

import java.util.List;
import java.util.Scanner;

public class RemoveCustomerCommand extends AbstractCommand {

    private static CustomerService customerService = CustomerService.getInstance();
    private static RemoveCustomerCommand removeCustomerCommand = new RemoveCustomerCommand();

    private RemoveCustomerCommand() {
    }

    public static RemoveCustomerCommand getInstance() {
        return removeCustomerCommand;
    }

    @Override
    public String getCommandName() {
        return "removeCustomer";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Customer> allCustomers = customerService.getAllCustomers();
        if (!allCustomers.isEmpty()) {
            allCustomers.forEach(w -> System.out.println(w));
            System.out.println("Enter customer to remove");
            String customerName = scanner.nextLine();
            customerService.delete(customerName);
        } else {
            System.out.println("Customers list is empty");
        }
    }
}
