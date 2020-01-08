package su.itline.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//import su.itline.diploma.AuthorizedUser;
import su.itline.diploma.model.User;
import su.itline.diploma.repository.MenuRepository;
import su.itline.diploma.repository.RestaurantRepository;
import su.itline.diploma.repository.UserRepository;

@Service
public class UserService { //implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository, MenuRepository mRepo, RestaurantRepository rRepo) {
        this.repository = repository;
    }

    public User getByEmail(String email) {
        var userOptional = repository.findByEmail(email);
        return null;
    }

//    @Override
//    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
//        var optionalUser = repository.findByEmail(email.toLowerCase());
//        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found"));
//        return new AuthorizedUser(optionalUser.get());
//    }
}
