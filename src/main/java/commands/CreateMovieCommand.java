package commands;

import entity.Rental;
import entity.prices.Price;
import services.Warehouse;
import utils.Utils;

public class CreateMovieCommand extends AbstractCommand {

    private static Warehouse warehouse = Warehouse.getInstance();
    private static CreateMovieCommand createMovieCommand = new CreateMovieCommand();

    private CreateMovieCommand() {
    }

    public static CreateMovieCommand getInstance() {
        return createMovieCommand;
    }

    @Override
    public String getCommandName() {
        return "createMovie";
    }

    @Override
    public void execute(String text) {
//        String[] strings = text.split(" ");
//        Price price = warehouse.getPrices().get(strings[0]));
//        Rental rental = new Rental(movie, Integer.valueOf(strings[1]));
//        warehouse.saveToMovies()
//        System.out.println(Utils.RENTAL_ADDED);
    }
}
