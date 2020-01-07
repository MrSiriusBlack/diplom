package su.itline.diploma.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class BaseEntity {

    @Id
    @SequenceGenerator(name = "int_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "int_seq")
    public int id;

    protected BaseEntity() {
    }

    protected BaseEntity(int id) {
        this.id = id;
    }
}
