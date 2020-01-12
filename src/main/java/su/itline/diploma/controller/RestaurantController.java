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
import su.itline.diploma.service.RestaurantService;
import su.itline.diploma.to.RestaurantTo;

import java.util.List;
import java.util.Optional;

@Api(tags = "Управление ресторанами")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService service;
    private final RestaurantRepository repository;

    public RestaurantController(RestaurantService service, RestaurantRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @ApiOperation(value = "Получение всех ресторанов")
    @GetMapping()
    public List<Restaurant> getRestaurant() {
        List<Restaurant> list = repository.findAll();
        return list;
    }

    @ApiOperation(value = "Добавление или редактирование ресторана")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping()
    public void setRestaurant(@RequestBody RestaurantTo request) {
        Restaurant restaurant = new Restaurant(request.getId(), request.getName());
        repository.save(restaurant);
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
        Optional<Restaurant> restaurantOptional = repository.findById(id);
        restaurantOptional.orElseThrow(() -> new NotFoundError(Restaurant.class, id));
    }
}
