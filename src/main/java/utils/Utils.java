package utils;

import commands.AbstractCommand;
import commands.ReadFromFileCommand;
import commands.SaveToFileCommand;
import commands.rentalCommand.*;
import commands.customerCommand.*;
import commands.movieCommand.*;

public interface Utils {

    String WELCOME_MESSAGE =
            "Welcome to MovieRentalApp.\n\n" +

            "Enter `/saveToFile` to save to the File\n" +
            "Enter `/readFromFile` to save to the File\n\n" +

            "Enter `/createCustomer` and write name to create new Customer\n" +
            "Enter `/getStatement` and write name to get a Statement\n" +
            "Enter `/getCustomerRentals` and write name to get a Rentals for current Customer\n" +
            "Enter `/addRentalToCustomer` and write name to create find Customer and choose Rental to add\n" +
            "Enter `/getAllCustomer` to get all Customers\n" +
            "Enter `/getCustomer` to get Customer\n" +
            "Enter `/removeCustomer` to remove Customer from warehouse\n" +
            "Enter `/updateCustomer` to update Customer\n" +
            "----------------------------------------------\n" +
            "Enter `/createMovie` to create Movie\n" +
            "Enter `/getMovie` to get Movie by title\n" +
            "Enter `/getAllMovie` to get all Movie\n" +
            "Enter `/removeMovie` to remove Movie\n" +
            "Enter `/updateMovie` to update Movie\n" +
            "----------------------------------------------\n" +
            "Enter `/createRental` to update Rental\n" +
            "Enter `/getRental` to get Rental by id\n" +
            "Enter `/getAllRental` to get all Rental\n" +
            "Enter `/removeRental` to remove Rental\n" +
            "Enter `/updateRental` to update Rental\n" +

            "To leave - enter `exit`";

    AbstractCommand[] ABSTRACT_COMMANDS = {
            CreateCustomerCommand.getInstance(),
            GetAllCustomersCommand.getInstance(),
            GetCustomerCommand.getInstance(),
            UpdateCustomerCommand.getInstance(),
            RemoveCustomerCommand.getInstance(),
            AddRentalToCustomerCommand.getInstance(),
            GetStatementCommand.getInstance(),
            GetRentalsCommand.getInstance(),

            CreateMovieCommand.getInstance(),
            GetAllMovieCommand.getInstance(),
            GetMovieCommand.getInstance(),
            UpdateMovieCommand.getInstance(),
            RemoveMovieCommand.getInstance(),

            CreateRentalCommand.getInstance(),
            UpdateRentalCommand.getInstance(),
            GetAllRentalsCommand.getInstance(),
            RemoveRentalCommand.getInstance(),
            GetRentalCommand.getInstance(),

            SaveToFileCommand.getInstance(),
            ReadFromFileCommand.getInstance()

    };

    String CUSTOMER_ADDED = "Customer added";
    String CUSTOMER_UPDATED = "Customer updated";
    String CUSTOMER_REMOVED = "Customer removed";

    String RENTAL_ADDED = "Rental added";
    String RENTAL_UPDATED = "Rental updated";
    String RENTAL_REMOVED = "Rental removed";

    String MOVIE_ADDED = "Movie added";
    String MOVIE_UPDATED = "Movie updated";
    String MOVIE_REMOVED = "Movie removed";

    String INFO_SAVED = "Info has been saved";
    String INFO_READ = "Info has been read";
}
