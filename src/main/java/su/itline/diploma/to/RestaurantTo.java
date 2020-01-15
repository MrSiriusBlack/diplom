package su.itline.diploma.to;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTo {

    @ApiModelProperty(value = "Название ресторана", required = true, example = "Три поросенка")
    @NotNull
    private String name;
}
