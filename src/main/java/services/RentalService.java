package services;

import entity.Entity;

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
       return warehouse.getRentalByName(name);
    }

    @Override
    public void post(Entity entity) {

    }

    @Override
    public void update(String name, Entity entity) {

    }

    @Override
    public void delete(String name) {

    }
}
