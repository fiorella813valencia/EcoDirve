package com.example.ecodirve.Application.rewards.api;

import com.example.ecodirve.Application.rewards.domain.service.RewardService;
import com.example.ecodirve.Application.rewards.mapping.RewardMapper;
import com.example.ecodirve.Application.rewards.resource.RewardResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@Validated
@RestController
@RequestMapping("/api/v1/scores")
public class ScoreRewardController {
    private final RewardService rewardService;
    private final RewardMapper mapper;

    public ScoreRewardController(RewardService rewardService, RewardMapper mapper) {
        this.rewardService = rewardService;
        this.mapper=mapper;
    }
    @GetMapping("/{score}/rewards")
    public List<RewardResource> getAllRewardByScore(@PathVariable Double score){
        return mapper.modelList(rewardService.getRewardByScore(score));
    }
}
