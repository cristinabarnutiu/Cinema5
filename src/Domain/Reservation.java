package Domain;
import java.util.Objects;

/**
 * CRUD reservation: id, movie id, card id (can be null), date and time
 * 10% od movie price is accumulated on the card
 * Show total number of points
 * Reservation is possible only if movie is in program
 */

public class Reservation extends Entity{
    private String id, idMovie, idCard;
    private String date, time; //idCard can be null
    private double moviePrice;
    private int moviePoints;


    public Reservation(String id, String idMovie, String idCard, double moviePrice, int moviePoints, String date, String time) {
        super(id);
        this.idMovie = idMovie;
        this.idCard = idCard;
        this.moviePrice = moviePrice;
        this.moviePoints = ((int) moviePrice*10)/100;
        this.date = date;
        this.time = time;

    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", idMovie='" + idMovie + '\'' +
                ", idCard='" + idCard + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", moviePrice=" + moviePrice +
                ", moviePoints=" + moviePoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getIdMovie() { return idMovie; }
    public void setIdMovie(String idMovie) { this.idMovie = idMovie; }
    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public double getMoviePrice() { return moviePrice; }
    public void setMoviePrice(double moviePrice) { this.moviePrice = moviePrice; }
    public void setMoviePoints(double moviePrice) { this.moviePoints = (int) ((moviePrice*10)/100); }
    public int getMoviePoints() { return (int)(this.moviePrice*10)/100;}


}

