package commands.customerCommand;

import commands.AbstractCommand;
import services.CustomerService;

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
    public void execute(String text) {
        System.out.println(customerService.get(text));
    }
}
