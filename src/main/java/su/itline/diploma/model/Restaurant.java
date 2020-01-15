package su.itline.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "restaurants")
@SequenceGenerator(name = "Sequence", sequenceName = "restaurant_id_seq", allocationSize = 1)
public class Restaurant extends BaseEntity {

    @Column(name = "name")
    @NotBlank
    public String name;
}
