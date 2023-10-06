package commands;

import entity.Movie;
import entity.Rental;
import services.Warehouse;
import utils.Utils;

public class CreateRentalCommand extends AbstractCommand {

    private static Warehouse warehouse = Warehouse.getInstance();
    private static CreateRentalCommand createRentalCommand = new CreateRentalCommand();

    private CreateRentalCommand() {
    }

    public static CreateRentalCommand getInstance() {
        return createRentalCommand;
    }

    @Override
    public String getCommandName() {
        return "createRental";
    }

    @Override
    public void execute(String text) {
        String[] strings = text.split(" ");
        Movie movie = warehouse.getAllMovies().stream().filter(m -> m.getTitle().equals(strings[0])).findFirst().get();
        Rental rental = new Rental(movie, Integer.valueOf(strings[1]));
        warehouse.saveToRentals(rental);
        System.out.println(Utils.RENTAL_ADDED);
    }
}
