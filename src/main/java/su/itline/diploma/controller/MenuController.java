package su.itline.diploma.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import su.itline.diploma.repository.MenuRepository;
import su.itline.diploma.service.MenuService;

@Api(tags = "Управление меню ресторанов")
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService service;
    private final MenuRepository repository;

    public MenuController(MenuService service, MenuRepository repository) {
        this.service = service;
        this.repository = repository;
    }



    @ApiOperation(value = "Добавление меню")
    @PutMapping(name = "/{restaurantId}")
    public void setMenu(@PathVariable Integer restaurantId) {

    }
}
