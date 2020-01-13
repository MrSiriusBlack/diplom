package su.itline.diploma.model;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "Sequence")
    public int id;
}
