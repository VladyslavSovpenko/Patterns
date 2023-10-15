package commands.movieCommand;

import commands.AbstractCommand;
import entity.Movie;
import entity.prices.Price;
import services.MovieService;
import services.PriceService;

import java.util.List;
import java.util.Scanner;

public class CreateMovieCommand extends AbstractCommand {

    private static MovieService movieService = MovieService.getInstance();
    private static PriceService priceService = PriceService.getInstance();
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
    public void execute(Scanner scanner) {
        System.out.println("Enter Movie name");
        String title = scanner.nextLine();

        System.out.println("Enter one of Movie price");
        List<Price> allPrices = priceService.getAllPrices();
        allPrices.forEach(p -> System.out.println(p.getPriceName()));

        String priceStr = scanner.nextLine();

        movieService.post(new Movie(title, priceStr));
    }
}
