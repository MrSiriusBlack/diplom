package su.itline.diploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "menus")
@Getter
@Setter
@SequenceGenerator(name = "Sequence", sequenceName = "menu_id_seq", allocationSize = 1)
public class Menu extends BaseEntity {

    @Column(name = "dish")
    private String dish;

    @Column(name = "price")
    private long price;

    @Column(name = "menu_date")
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
