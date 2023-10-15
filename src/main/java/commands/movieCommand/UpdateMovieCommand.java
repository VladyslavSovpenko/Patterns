package commands.movieCommand;

import commands.AbstractCommand;
import entity.Movie;
import entity.prices.Price;
import services.MovieService;
import services.PriceService;

import java.util.List;
import java.util.Scanner;

public class UpdateMovieCommand extends AbstractCommand {

    private static MovieService movieService = MovieService.getInstance();
    private static PriceService priceService = PriceService.getInstance();
    private static UpdateMovieCommand updateMovieCommand = new UpdateMovieCommand();

    private UpdateMovieCommand() {
    }

    public static UpdateMovieCommand getInstance() {
        return updateMovieCommand;
    }

    @Override
    public String getCommandName() {
        return "updateMovie";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter movie title to find");
        String customerName = scanner.nextLine();

        System.out.println("Enter movie title to update");
        String updatedTitle = scanner.nextLine();

        System.out.println("Enter one of Movie price");
        List<Price> allPrices = priceService.getAllPrices();
        allPrices.forEach(p -> System.out.println(p));

        String priceStr = scanner.nextLine();

        Movie movie = new Movie(updatedTitle, priceStr);
        movieService.update(customerName, movie);
    }
}
