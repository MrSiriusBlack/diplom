package su.itline.diploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "menus")
@Getter
@Setter
@SequenceGenerator(name = "Sequence", sequenceName = "menu_id_seq", allocationSize = 1)
public class Menu extends BaseEntity {

    @Column(name = "menu_date")
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @CollectionTable(name = "dishes", joinColumns = @JoinColumn(name = "menu_id"))
    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "name")
    @Fetch(FetchMode.SUBSELECT)
    @Column(name = "price")
    private Map<String, BigDecimal> dishes;
}
