package commands.movieCommand;

import commands.AbstractCommand;
import entity.Movie;
import services.MovieService;

import java.util.List;
import java.util.Scanner;

public class RemoveMovieCommand extends AbstractCommand {

    private static MovieService movieService = MovieService.getInstance();
    private static final RemoveMovieCommand removeMovieCommand = new RemoveMovieCommand();

    private RemoveMovieCommand() {
    }

    public static RemoveMovieCommand getInstance() {
        return removeMovieCommand;
    }

    @Override
    public String getCommandName() {
        return "removeMovie";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Movie> allCustomers = movieService.getAllMovies();
        if (!allCustomers.isEmpty()) {
            allCustomers.forEach(System.out::println);
            System.out.println("Enter customer to remove");
            String customerName = scanner.nextLine();
            movieService.delete(customerName);
        } else {
            System.out.println("Customers list is empty");
        }
    }
}
