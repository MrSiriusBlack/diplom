package su.itline.diploma.service;

import org.springframework.stereotype.Service;
import su.itline.diploma.model.Restaurant;
import su.itline.diploma.repository.RestaurantRepository;
import su.itline.diploma.to.RestaurantTo;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public void setRestaurant(RestaurantTo restaurantTo) {

    }
}
