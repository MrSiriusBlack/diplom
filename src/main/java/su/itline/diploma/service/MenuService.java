package su.itline.diploma.service;

import org.springframework.stereotype.Service;
import su.itline.diploma.repository.MenuRepository;

@Service
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }


}
