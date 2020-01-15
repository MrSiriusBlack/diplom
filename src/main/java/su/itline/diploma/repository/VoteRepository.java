package su.itline.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import su.itline.diploma.model.Vote;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("from Vote where date = :date and user.id = :userId")
    Optional<Vote> findByDateAndUserId(@Param("date") LocalDate date, @Param("userId") Integer userId);
}
