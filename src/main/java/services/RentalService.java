package services;

import entity.Entity;
import entity.Rental;
import utils.Utils;

import java.util.List;

public class RentalService implements EntityService {

    private static Warehouse warehouse = Warehouse.getInstance();
    private static RentalService rentalService = new RentalService();

    private RentalService() {
    }

    public static RentalService getInstance() {
        return rentalService;
    }

    @Override
    public Entity get(String name) {
        return warehouse.getRentalById(name);
    }

    @Override
    public void post(Entity entity) {
        warehouse.saveToRentals(((Rental) entity));
        System.out.println(Utils.RENTAL_ADDED);
    }

    @Override
    public void update(String name, Entity entity) {
        Rental rental = warehouse.getRentalById(name);
        rental.setMovie(((Rental) entity).getMovie());
        rental.setDaysRented(((Rental) entity).getDaysRented());
        warehouse.saveToRentals(rental);
        System.out.println(Utils.RENTAL_UPDATED);
    }

    @Override
    public void delete(String name) {
        warehouse.deleteMovieByID(name);
        System.out.println(Utils.RENTAL_REMOVED);
    }

    public List<Rental> getAllRentals() {
        return warehouse.getAllRentals();
    }
}
