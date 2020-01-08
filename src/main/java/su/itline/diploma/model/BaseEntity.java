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
    @SequenceGenerator(name = "int_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "int_seq")
    public int id;
}
