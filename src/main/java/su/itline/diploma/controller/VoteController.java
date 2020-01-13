package su.itline.diploma.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import su.itline.diploma.service.VoteService;
import su.itline.diploma.to.VoteTo;

@Api(tags = "Голосование")
@RestController
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @ApiOperation(value = "Голосование за ресторан")
    @PostMapping("/vote")
    public void RestaurantVoting(@RequestBody VoteTo voteTo) {
        voteService.addVote(voteTo);
    }
}
