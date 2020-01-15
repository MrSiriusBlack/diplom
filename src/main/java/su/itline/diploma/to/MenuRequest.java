package su.itline.diploma.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@ApiModel(description = "Меню ресторана")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequest {

    @ApiModelProperty(value = "Дата действия меню", required = true, example = "2020-01-20")
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @ApiModelProperty(value = "Идентификатор ресторана", required = true, example = "1")
    @NotNull
    private int restaurantId;

    @ApiModelProperty(value = "Блюда в меню с ценой", required = true)
    @NotNull
    private Map<String, BigDecimal> dishes;
}
