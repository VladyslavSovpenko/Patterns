package commands.movieCommand;

import commands.AbstractCommand;
import services.MovieService;

import java.util.Scanner;

public class GetMovieCommand extends AbstractCommand {

    private static MovieService movieService = MovieService.getInstance();
    private static final GetMovieCommand getMovieCommand = new GetMovieCommand();

    private GetMovieCommand() {
    }

    public static GetMovieCommand getInstance() {
        return getMovieCommand;
    }

    @Override
    public String getCommandName() {
        return "getMovie";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Movie name to find");
        System.out.println(movieService.get(scanner.nextLine()));
    }
}
