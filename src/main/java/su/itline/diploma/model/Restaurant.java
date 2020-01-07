package su.itline.diploma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "restaurants")
public class Restaurant extends BaseEntity {

    @Column
    @NotBlank
    public String name;
}
