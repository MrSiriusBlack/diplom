package su.itline.diploma.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import su.itline.diploma.model.User;
import su.itline.diploma.repository.UserRepository;

import java.util.List;

@Api(tags = "Управление пользователями")
@RequestMapping("/admin")
@RestController
public class AdminController {

    private final UserRepository repository;

    public AdminController(UserRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "Получение всех пользователей")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @ApiOperation(value = "Удаление пользователя по id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
