package services;

import entity.Entity;

public interface EntityService {
    Entity get(String name);

    void post(Entity entity);

    void update(String name, Entity entity);

    void delete(String name);
}
