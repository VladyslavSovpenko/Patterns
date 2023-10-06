package commands.customerCommand;

import commands.AbstractCommand;
import services.CustomerService;

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
    public void execute(String text) {
        customerService.delete(text);
    }
}
