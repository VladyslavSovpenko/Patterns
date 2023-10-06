package commands.customerCommand;

import commands.AbstractCommand;
import entity.Customer;
import services.CustomerService;

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
    public void execute(String text) {
        customerService.post(new Customer(text));
    }
}
