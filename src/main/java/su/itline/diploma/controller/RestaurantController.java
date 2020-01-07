package su.itline.diploma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import su.itline.diploma.model.Restaurant;
import su.itline.diploma.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping(name = "/restaurants")
    public List<Restaurant> getRestaurant() {
        List<Restaurant> list = service.getAll();
        return list;
    }

    @PostMapping(name = "/menu/{restaurantId}")
    public void setMenu() {

    }
}
