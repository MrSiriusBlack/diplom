package su.itline.diploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "votes")
@Getter
@Setter
public class Vote extends BaseEntity {

    @Column(name = "vote_date")
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
