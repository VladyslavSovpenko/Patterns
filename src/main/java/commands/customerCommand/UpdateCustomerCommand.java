package commands.customerCommand;

import commands.AbstractCommand;
import entity.Customer;
import services.CustomerService;

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
    public void execute(String text) {
        String[] strings = text.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < strings.length; i++) {
            builder.append(i);
        }
        Customer customer = new Customer(builder.toString());
        customerService.update(strings[0], customer);
    }
}
