package services;

import entity.Entity;
import entity.Movie;
import utils.Utils;

import java.util.List;

public class MovieService implements EntityService {

    private static Warehouse warehouse = Warehouse.getInstance();
    private static MovieService movieService = new MovieService();

    private MovieService() {
    }

    public static MovieService getInstance() {
        return movieService;
    }

    @Override
    public Entity get(String name) {
        return warehouse.getMovieByName(name);
    }

    @Override
    public void post(Entity entity) {
        warehouse.saveToMovies(((Movie) entity));
        System.out.println(Utils.MOVIE_ADDED);
    }

    @Override
    public void update(String name, Entity entity) {
        Movie movie = warehouse.getMovieById(name);
        movie.setTitle(((Movie) entity).getTitle());
        movie.setPrice(((Movie) entity).getPrice());
        warehouse.saveToMovies(movie);
        System.out.println(Utils.MOVIE_UPDATED);
    }

    @Override
    public void delete(String name) {
        warehouse.deleteMovieByID(name);
        System.out.println(Utils.MOVIE_REMOVED);
    }

    public List<Movie> getAllMovies() {
        return warehouse.getAllMovies();
    }
}
