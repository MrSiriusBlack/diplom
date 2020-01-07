package su.itline.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.itline.diploma.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
