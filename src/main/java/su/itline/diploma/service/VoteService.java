package su.itline.diploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.itline.diploma.repository.VoteRepository;

@Service
public class VoteService {

    private VoteRepository repository;

    public VoteService(VoteRepository repository) {
        this.repository = repository;
    }
}
