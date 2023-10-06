package commands.customerCommand;

import commands.AbstractCommand;
import services.CustomerService;

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
    public void execute(String text) {
        customerService.getAllCustomers().forEach(w -> System.out.println(w));
    }
}
