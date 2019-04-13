package Domain;
import java.util.Objects;
/**
 * Class for object 'Card'
 * CRUD 'Card': id, first name, last name, CNP, date of birth (dd.mm.yyyy), date of registration (dd.mm.yyyy), total points
 * CNP must be unique
 */

public class Card extends Entity{
    private String id;
    private String lastName;
    private String firstName;
    private String CNP;
    private int totalPoints;

    private String dateOfBirth, dateOfRegistration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Card card = (Card) o;
        return totalPoints == card.totalPoints &&
                Objects.equals(id, card.id) &&
                Objects.equals(lastName, card.lastName) &&
                Objects.equals(firstName, card.firstName) &&
                Objects.equals(CNP, card.CNP) &&
                Objects.equals(dateOfBirth, card.dateOfBirth) &&
                Objects.equals(dateOfRegistration, card.dateOfRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, lastName, firstName, CNP, totalPoints, dateOfBirth, dateOfRegistration);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                ", totalPoints=" + totalPoints +
                '}';
    }

    public Card(String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration, int totalPoints) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
        this.CNP = CNP;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
        this.totalPoints = totalPoints;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getCNP() { return CNP; }
    public void setCNP(String CNP) { this.CNP = CNP; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getDateOfRegistration() { return dateOfRegistration; }
    public void setDateOfRegistration(String dateOfRegistration) { this.dateOfRegistration = dateOfRegistration; }
    public int getTotalPoints() { return totalPoints; }
    public void setTotalPoints(int totalPoints) { this.totalPoints = totalPoints; }
}
