package commands.movieCommand;

import commands.AbstractCommand;
import entity.Movie;
import services.MovieService;

import java.util.List;
import java.util.Scanner;

public class GetAllMovieCommand extends AbstractCommand {

    private static MovieService movieService = MovieService.getInstance();
    private static GetAllMovieCommand getAllMovieCommand = new GetAllMovieCommand();

    private GetAllMovieCommand() {
    }

    public static GetAllMovieCommand getInstance() {
        return getAllMovieCommand;
    }

    @Override
    public String getCommandName() {
        return "getAllMovie";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Movie> allMovies = movieService.getAllMovies();
        if (!allMovies.isEmpty()) {
            allMovies.forEach(System.out::println);
        } else {
            System.out.println("Movie list is empty");
        }
    }
}
