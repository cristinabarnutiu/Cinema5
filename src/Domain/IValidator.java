package Domain;

/**
 * Interface class for Entity
 */
public interface IValidator<T extends Entity> {
    void validate (T entity);
}
