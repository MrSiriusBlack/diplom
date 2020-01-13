package su.itline.diploma.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import su.itline.diploma.AuthorizedUser;
import su.itline.diploma.errors.TimeExpiredError;
import su.itline.diploma.model.Restaurant;
import su.itline.diploma.model.User;
import su.itline.diploma.model.Vote;
import su.itline.diploma.repository.VoteRepository;
import su.itline.diploma.to.VoteTo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class VoteService {

    private final VoteRepository repository;

    @PersistenceContext
    private EntityManager em;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }

    public void addVote(VoteTo voteTo) {
        if (LocalDate.now().isAfter(voteTo.getDate()) ||
                (LocalDate.now().equals(voteTo.getDate()) && LocalTime.now().isAfter(LocalTime.of(11, 00))))
            throw new TimeExpiredError();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        var user = (AuthorizedUser) auth.getPrincipal();
        var vote = repository.findByDateAndUserId(voteTo.getDate(), user.getId());
        if (vote.isEmpty()) {
            repository.save(toVote(voteTo, user.getId()));
        } else {
            var newVote = toVote(voteTo, user.getId());
            newVote.setId(vote.get().getId());
            repository.save(newVote);
        }

    }

    private Vote toVote(VoteTo voteTo, int userId) {
        Vote vote = new Vote();
        vote.setDate(voteTo.getDate());
        vote.setUser(em.getReference(User.class, userId));
        vote.setRestaurant(em.getReference(Restaurant.class, voteTo.getRestaurantId()));
        return vote;
    }
}
