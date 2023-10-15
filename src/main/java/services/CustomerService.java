package services;

import entity.Customer;
import entity.Entity;
import entity.Rental;
import utils.Utils;

import java.util.List;
import java.util.Optional;

public class CustomerService implements EntityService {

    private static Warehouse warehouse = Warehouse.getInstance();
    private static CustomerService customerService = new CustomerService();
    private static RentalService rentalService = RentalService.getInstance();

    private CustomerService() {
    }

    public static CustomerService getInstance() {
        return customerService;
    }

    @Override
    public Entity get(String id) {
        return warehouse.getCustomerById(id);
    }

    @Override
    public void post(Entity entity) {
        warehouse.saveToCustomers((Customer) entity);
        System.out.println(Utils.CUSTOMER_ADDED);
    }

    @Override
    public void update(String name, Entity entity) {
        Customer customerByName = warehouse.getCustomerByName(name);
        customerByName.setName(((Customer) entity).getName());
        warehouse.saveToCustomers(customerByName);
        System.out.println(Utils.CUSTOMER_UPDATED);
    }

    @Override
    public void delete(String name) {
        warehouse.deleteCustomer(name);
        System.out.println(Utils.CUSTOMER_REMOVED);
    }

    public List<Customer> getAllCustomers() {
        return warehouse.getAllCustomers();
    }

    public void addRentalToCustomer(String custId, String rentalId) {
        Customer entity = warehouse.getCustomerById(custId);

        Optional<Rental> rental = rentalService.getAllRentals().stream()
                .filter(r -> r.getId() == Integer.parseInt(rentalId))
                .findFirst();

        rental.ifPresent(entity::addRental);

        System.out.println(Utils.RENTAL_ADDED);

    }
}
