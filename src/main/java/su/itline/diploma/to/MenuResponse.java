package su.itline.diploma.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import su.itline.diploma.model.Restaurant;

import java.util.Map;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {

    private Map<String, Long> dishes;
    private Restaurant restaurant;
}
