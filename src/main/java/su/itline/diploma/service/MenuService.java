package su.itline.diploma.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import su.itline.diploma.model.Menu;
import su.itline.diploma.model.Restaurant;
import su.itline.diploma.repository.MenuRepository;
import su.itline.diploma.to.MenuRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class MenuService {

    private final MenuRepository repository;

    @PersistenceContext
    private EntityManager em;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public void addMenu(MenuRequest menuRequest) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuRequest, menu);
        menu.setRestaurant(em.getReference(Restaurant.class, menuRequest.getRestaurantId()));
        repository.save(menu);
    }
}
