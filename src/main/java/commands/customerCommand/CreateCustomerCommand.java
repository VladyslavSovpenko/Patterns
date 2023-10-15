package commands.customerCommand;

import commands.AbstractCommand;
import entity.Customer;
import services.CustomerService;

import java.util.Scanner;

public class CreateCustomerCommand extends AbstractCommand {

    private static CustomerService customerService = CustomerService.getInstance();
    private static final CreateCustomerCommand createCustomerCommandCommand = new CreateCustomerCommand();

    private CreateCustomerCommand() {
    }

    public static CreateCustomerCommand getInstance() {
        return createCustomerCommandCommand;
    }

    @Override
    public String getCommandName() {
        return "createCustomer";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Customer name");
        String line = scanner.nextLine();
        customerService.post(new Customer(line));
    }
}
