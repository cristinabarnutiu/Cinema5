package Service;

import Domain.Movie;
import Domain.Reservation;
import Repository.IRepository;

import java.util.List;

public class ReservationService {
    private IRepository<Reservation> reservationRepository;
    private IRepository<Movie> movieRepository;

    public ReservationService(IRepository<Reservation> reservationRepository, IRepository<Movie> movieRepository) {
        this.reservationRepository = reservationRepository;
        this.movieRepository = movieRepository;
    }

    public Reservation addOrUpdate(String id, String idMovie, String idCard, String date, String time) {
        Reservation existing = reservationRepository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (idMovie == null) { idMovie = existing.getIdMovie(); }
            if (idCard == null) { idCard = existing.getIdCard(); }
            if (date.isEmpty()) { date = existing.getDate(); }
            if (time.isEmpty()) { time = existing.getTime(); }
        }

        Movie movieReservation = movieRepository.findById(idMovie);
        if (movieReservation == null) {
            throw new RuntimeException("There is no movie with the given id!");
        }
        if (!movieReservation.isInProgram() ) // validation if movie is not in program
            throw new RuntimeException("Movie is not in program!");

        double moviePrice = movieReservation.getPrice();
        int moviePoints = (int) ((movieReservation.getPrice()*10)/100);

        Reservation reservation = new Reservation(id, idMovie, idCard, moviePrice, moviePoints, date, time);
        reservationRepository.upsert(reservation);
        return reservation;
    }

    public void remove(String id) {
        reservationRepository.remove(id);
    }

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }
}
