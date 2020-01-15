package su.itline.diploma.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import su.itline.diploma.errors.NotFoundError;
import su.itline.diploma.model.Restaurant;
import su.itline.diploma.repository.RestaurantRepository;
import su.itline.diploma.to.RestaurantTo;

import java.util.List;

@Api(tags = "Управление ресторанами")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantRepository repository;

    public RestaurantController(RestaurantRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "Получение всех ресторанов")
    @GetMapping()
    public List<Restaurant> getRestaurant() {
        return repository.findAll();
    }

    @ApiOperation(value = "Добавление ресторана")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping()
    public void setRestaurant(@RequestBody RestaurantTo request) {
        repository.save(new Restaurant(request.getName()));
    }

    @ApiOperation(value = "Удление ресторана")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRestaurant(@ApiParam(value = "ID ресторана", required = true, example = "1")
                                 @PathVariable Integer id) {
        checkRestaurant(id);
        repository.deleteById(id);
    }

    private void checkRestaurant(int id) {
        var restaurantOptional = repository.findById(id);
        restaurantOptional.orElseThrow(() -> new NotFoundError(Restaurant.class, id));
    }
}
