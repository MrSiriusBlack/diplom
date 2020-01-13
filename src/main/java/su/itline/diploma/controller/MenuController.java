package su.itline.diploma.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import su.itline.diploma.model.Menu;
import su.itline.diploma.repository.MenuRepository;
import su.itline.diploma.service.MenuService;
import su.itline.diploma.to.MenuRequest;

import java.time.LocalDate;
import java.util.List;

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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping()
    public void setMenu(@RequestBody MenuRequest menuRequest) {
        service.addMenu(menuRequest);
    }

    @ApiOperation(value = "Просмотр меню ресторанов на дату")
    @GetMapping("/{date}")
    public List<Menu> getMenu(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return repository.findAllByDate(date);
    }
}
