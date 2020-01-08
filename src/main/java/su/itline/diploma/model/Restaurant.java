package su.itline.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "restaurants")
public class Restaurant {//extends BaseEntity {

    @Id
    public Integer id;

    @Column(name = "name")
    @NotBlank
    public String name;
}
