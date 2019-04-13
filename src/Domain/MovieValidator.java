package Domain;
import Domain.MovieValidator;

/**
 * MovieValidator class implements IValidator
 * Validates that movie price is positive
 */
public class MovieValidator implements IValidator<Movie> {

    public void validate (Movie movie) {

        if (movie.getPrice() < 0 ) {
            throw new RuntimeException("Price must be > 0!");
        }

    }
}