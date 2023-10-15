package commands.customerCommand;

import commands.AbstractCommand;
import entity.Customer;
import services.CustomerService;

import java.util.Scanner;

public class UpdateCustomerCommand extends AbstractCommand {

    private static CustomerService customerService = CustomerService.getInstance();
    private static UpdateCustomerCommand updateCustomerCommand = new UpdateCustomerCommand();

    private UpdateCustomerCommand() {
    }

    public static UpdateCustomerCommand getInstance() {
        return updateCustomerCommand;
    }

    @Override
    public String getCommandName() {
        return "updateCustomer";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter customer name to find");
        String customerName = scanner.nextLine();

        System.out.println("Enter customer info to update");
        String updatedName = scanner.nextLine();

        Customer customer = new Customer(updatedName);
        customerService.update(customerName, customer);
    }
}
