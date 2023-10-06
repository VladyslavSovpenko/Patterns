package services;

import entity.Customer;
import entity.Entity;
import entity.Rental;
import utils.Utils;

import java.util.List;

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
    public Entity get(String name) {
        return warehouse.getCustomerByName(name);
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

    public void addRentalToCustomer(String name, String rentalId) {
        Customer customer = warehouse.getCustomerByName(name);
        Rental entity = ((Rental) rentalService.get(rentalId));
        customer.addRental(entity);
    }
}
