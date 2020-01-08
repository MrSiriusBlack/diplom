package su.itline.diploma.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Голосование")
@RestController
public class VoteController {

    @ApiOperation(value = "Голосование за ресторан")
    @PostMapping(name = "/vote/{restaurantId}")
    public void RestaurantVoting(@PathVariable Integer restaurantId){

    }
}
