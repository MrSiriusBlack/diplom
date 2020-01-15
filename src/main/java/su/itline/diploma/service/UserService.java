package su.itline.diploma.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import su.itline.diploma.AuthorizedUser;
import su.itline.diploma.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        var optionalUser = repository.findByEmail(email.toLowerCase()).orElseThrow(
                () -> new UsernameNotFoundException("User " + email + " not found"));
        return new AuthorizedUser(optionalUser);
    }
}
