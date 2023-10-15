package commands.rentalCommand;

import commands.AbstractCommand;
import entity.Movie;
import entity.Rental;
import services.MovieService;
import services.RentalService;

import java.util.Scanner;

public class UpdateRentalCommand extends AbstractCommand {

    private static RentalService rentalService = RentalService.getInstance();
    private static MovieService movieService = MovieService.getInstance();
    private static UpdateRentalCommand updateRentalCommand = new UpdateRentalCommand();

    private UpdateRentalCommand() {
    }

    public static UpdateRentalCommand getInstance() {
        return updateRentalCommand;
    }

    @Override
    public String getCommandName() {
        return "updateRental";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter rental id\n");
        rentalService.getAllRentals().forEach(System.out::println);
        String rentalId = scanner.nextLine();

        System.out.println("Enter Movie title to update");
        movieService.getAllMovies().forEach(System.out::println);
        String movieTitle = scanner.nextLine();
        Movie movie = ((Movie) movieService.get(movieTitle));

        System.out.println("Enter days rent");
        Integer daysRented = Integer.parseInt(scanner.nextLine());

        Rental rental = new Rental(movie, daysRented);

        rental.setMovie(movie);
        rental.setDaysRented(daysRented);

        rentalService.update(rentalId, rental);
    }
}
