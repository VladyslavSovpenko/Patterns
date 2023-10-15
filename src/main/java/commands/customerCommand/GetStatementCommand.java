package commands.customerCommand;

import commands.AbstractCommand;
import entity.Customer;
import services.CustomerService;

import java.util.List;
import java.util.Scanner;

public class GetStatementCommand extends AbstractCommand {

    private static CustomerService customerService = CustomerService.getInstance();
    private static final GetStatementCommand getStatementCommand = new GetStatementCommand();

    private GetStatementCommand() {
    }

    public static GetStatementCommand getInstance() {
        return getStatementCommand;
    }

    @Override
    public String getCommandName() {
        return "getStatement";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Customer id to find and get Statement\n");
        List<Customer> allCustomers = customerService.getAllCustomers();
        if (!allCustomers.isEmpty()) {
            allCustomers.forEach(System.out::println);

            Customer entity = ((Customer) customerService.get(scanner.nextLine()));
            System.out.println(entity._getStatement());
        } else {
            System.out.println("Customer list is empty");
        }
    }
}
