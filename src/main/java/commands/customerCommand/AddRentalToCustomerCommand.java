package commands.customerCommand;

import commands.AbstractCommand;
import services.CustomerService;

public class AddRentalToCustomerCommand extends AbstractCommand {
    private static CustomerService customerService = CustomerService.getInstance();
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
    public void execute(String text) {
        String[] strings = text.split(" ");
        customerService.addRentalToCustomer(strings[0], strings[1]);
    }
}
