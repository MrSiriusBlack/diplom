package su.itline.diploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "menus")
@Getter
@Setter
public class Menu extends BaseEntity {

    @Column
    private String dish;

    @Column
    private int price;

    @Column
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
