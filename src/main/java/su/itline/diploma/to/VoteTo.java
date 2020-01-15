package su.itline.diploma.to;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ApiModel(description = "Голосование за ресторан")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoteTo {

    @ApiModelProperty(value = "Дата голосования", required = true, example = "2020-01-20")
    @NotNull
    private LocalDate date;

    @ApiModelProperty(value = "Идентификатор ресторана", required = true, example = "1")
    @NotNull
    private int restaurantId;
}
