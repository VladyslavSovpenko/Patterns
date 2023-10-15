package services;

import entity.Entity;
import entity.prices.Price;

import java.util.List;

public class PriceService implements EntityService {

    private static Warehouse warehouse = Warehouse.getInstance();
    private static PriceService priceService = new PriceService();

    private PriceService() {
    }

    public static PriceService getInstance() {
        return priceService;
    }

    @Override
    public Entity get(String name) {
        return null;
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

    public List<Price> getAllPrices() {
        return warehouse.getPrices();
    }
}
