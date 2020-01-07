package su.itline.diploma.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    @PostMapping(name = "/vote/{restaurantId}")
    public void RestaurantVoting(@PathVariable Integer restaurantId){

    }
}
