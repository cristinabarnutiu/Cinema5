package Domain;

/**
 * CRUD reservation: id, id_film, id_card_client (poate fi nul), data și ora.
 */

public class ReservationValidator implements IValidator<Reservation> {
    public void validate(Reservation reservation) {
        if (reservation.getIdMovie() == null) {
            throw new RuntimeException("Movie id must be provided!");
        }
    }
}