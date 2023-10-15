package commands.rentalCommand;

import commands.AbstractCommand;
import entity.Movie;
import entity.Rental;
import services.MovieService;
import services.RentalService;

import java.util.Scanner;

public class CreateRentalCommand extends AbstractCommand {

    private static MovieService movieService = MovieService.getInstance();
    private static RentalService rentalService = RentalService.getInstance();
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
    public void execute(Scanner scanner) {
        System.out.println("Enter Movie name\n");
        movieService.getAllMovies().forEach(m -> System.out.println(m.getTitle()));
        String movieTitle = scanner.nextLine();

        Movie movie = movieService.getAllMovies().stream()
                .filter(m -> m.getTitle().equals(movieTitle))
                .findFirst()
                .orElse(null);

        System.out.println("Enter days rented");
        String daysRented = scanner.nextLine();
        Rental rental = new Rental(movie, Integer.valueOf(daysRented));
        rentalService.post(rental);
    }
}
