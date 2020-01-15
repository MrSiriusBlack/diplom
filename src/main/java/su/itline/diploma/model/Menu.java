package su.itline.diploma.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@ApiModel(description = "Меню ресторана")
@Entity
@Table(name = "menus")
@Getter
@Setter
@SequenceGenerator(name = "Sequence", sequenceName = "menu_id_seq", allocationSize = 1)
public class Menu extends BaseEntity {

    @ApiModelProperty(value = "Дата действия меню")
    @Column(name = "menu_date")
    private LocalDate date;

    @ApiModelProperty(value = "Ресторан")
    @ManyToOne(optional = false)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ApiModelProperty(value = "Список блюд с ценой")
    @CollectionTable(name = "dishes", joinColumns = @JoinColumn(name = "menu_id"))
    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "name")
    @Fetch(FetchMode.SUBSELECT)
    @Column(name = "price")
    private Map<String, BigDecimal> dishes;
}
