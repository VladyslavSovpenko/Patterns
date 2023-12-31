package commands.customerCommand;

import commands.AbstractCommand;
import entity.Customer;
import services.CustomerService;

import java.util.List;
import java.util.Scanner;

public class GetAllCustomersCommand extends AbstractCommand {

    private static CustomerService customerService = CustomerService.getInstance();
    private static final GetAllCustomersCommand getAllCustomersCommand = new GetAllCustomersCommand();

    private GetAllCustomersCommand() {
    }

    public static GetAllCustomersCommand getInstance() {
        return getAllCustomersCommand;
    }

    @Override
    public String getCommandName() {
        return "getAllCustomer";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Customer> allCustomers = customerService.getAllCustomers();
        if (!allCustomers.isEmpty()) {
            allCustomers.forEach(System.out::println);
        } else {
            System.out.println("Customer list is empty");
        }
    }
}
