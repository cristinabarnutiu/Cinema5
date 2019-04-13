package Domain;

import java.util.Objects;

/**
 * Class for object 'Movie'
 * CRUD movie: id, title, year, price, in program (boolean).
 * Price must be > 0
 */

public class Movie extends Entity{

    private String title;
    private String year;
    private double price;
    private boolean inProgram;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.price, price) == 0 &&
                inProgram == movie.inProgram &&
                Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, year, price, inProgram);
    }

    public Movie(String id, String title, String year, double price, boolean inProgram) {
        super(id);
        this.title = title;
        this.year = year;
        this.price = price;
        this.inProgram = inProgram;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", inProgram=" + inProgram +
                '}';
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isInProgram() { return inProgram; }
    public void setInProgram(boolean inProgram) { this.inProgram = inProgram; }

}
