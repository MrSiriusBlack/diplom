package su.itline.diploma.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import su.itline.diploma.HasId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseTo implements HasId {
    protected Integer id;
}
