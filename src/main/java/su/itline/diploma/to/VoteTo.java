package su.itline.diploma.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import su.itline.diploma.model.Restaurant;
import su.itline.diploma.model.User;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteTo extends BaseTo {
    private LocalDate date;
    private User user;
    private Restaurant restaurant;
}
