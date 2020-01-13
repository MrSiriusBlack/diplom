package su.itline.diploma.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import su.itline.diploma.model.Menu;
import su.itline.diploma.repository.MenuRepository;
import su.itline.diploma.to.MenuRequest;

@Service
public class MenuService {

    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public void addMenu(MenuRequest menuRequest) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuRequest, menu);
        repository.save(menu);
    }
}
