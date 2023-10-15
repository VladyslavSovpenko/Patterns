package commands.customerCommand;

import commands.AbstractCommand;
import services.CustomerService;

import java.util.Scanner;

public class GetCustomerCommand extends AbstractCommand {

    private static CustomerService customerService = CustomerService.getInstance();
    private static GetCustomerCommand getCustomerCommand = new GetCustomerCommand();

    private GetCustomerCommand() {
    }

    public static GetCustomerCommand getInstance() {
        return getCustomerCommand;
    }

    @Override
    public String getCommandName() {
        return "getCustomer";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Customer id to find");
        System.out.println(customerService.get(scanner.nextLine()));
    }
}
