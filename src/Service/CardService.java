package Service;

import Domain.Card;
import Repository.IRepository;
import Domain.Entity;

import java.util.List;

public class CardService {
    private IRepository<Card> repository;
    public CardService(IRepository<Card> repository){ this.repository = repository;};

    public void addOrUpdate(String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration, int totalPoints) {
        //CNP unique validation
        for (Card c : repository.getAll())
            if (c.getCNP().equals(CNP))
                throw new RuntimeException("A client with the same CNP already exists!");

        Card existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (lastName.isEmpty()) { lastName = existing.getLastName(); }
            if (firstName.isEmpty()) { firstName = existing.getFirstName(); }
            if (CNP.isEmpty()) { CNP = existing.getCNP(); }
            if (dateOfBirth.isEmpty()) { dateOfBirth = existing.getDateOfBirth(); }
            if (dateOfRegistration.isEmpty()) { dateOfRegistration = existing.getDateOfRegistration(); }
            if (totalPoints == 0) { totalPoints = existing.getTotalPoints(); }
        }

        Card card = new Card(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration, totalPoints);
        repository.upsert(card);
    }

    public void remove(String id) {
        repository.remove(id);
    }
    public List<Card> getAll() {
        return repository.getAll();
    }

}

