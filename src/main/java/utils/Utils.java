package utils;

import commands.*;
import commands.customerCommand.*;

public interface Utils {
    String WELCOME_MESSAGE = "Welcome to MovieRentalApp.\n\n" +
            "Enter `/createCustomer` and write name to create new Customers\n" +
//            "Example, `/simpleExpression 2*x+5=7 key=1`\n" +
//            "Enter `/readFromFile` and write file name and put file in root, example `/readFromFile expressions.txt` \n" +
//            "Enter `/getFromDBByKey` and write key, example `/getFromDBByKey 1`\n" +
//            "If you want get by 2 or more key - write with space, example `/getFromDBByKey 1 2 3`\n\n" +
            "To leave - enter `exit`";

    AbstractCommand[] ABSTRACT_COMMANDS = {
            CreateCustomerCommand.getInstance(),
            GetAllCustomersCommand.getInstance(),
            GetCustomerCommand.getInstance(),
            UpdateCustomerCommand.getInstance(),
            RemoveCustomerCommand.getInstance(),
            AddRentalToCustomerCommand.getInstance(),


            CreateRentalCommand.getInstance(),
            CreateMovieCommand.getInstance()

    };

    String WAITING_ANSWER_FROM_BD = "Searching in the database by key. Wait...";
    String EMPTY_LIST = "List is Empty";
    String CUSTOMER_ADDED = "Customer added";
    String CUSTOMER_UPDATED = "Customer updated";
    String CUSTOMER_REMOVED = "Customer removed";
    String RENTAL_ADDED = "Rental added";
}
