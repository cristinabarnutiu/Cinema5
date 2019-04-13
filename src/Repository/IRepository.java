package Repository;

import Domain.Movie;
import Domain.MovieValidator;
import Domain.Entity;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<T extends Entity> {

    T findById(String id);
    void upsert(T movie);

    void remove(String id);
    List<T> getAll();
}