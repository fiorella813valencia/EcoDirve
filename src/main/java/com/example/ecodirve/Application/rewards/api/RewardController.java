package com.example.ecodirve.Application.rewards.api;


import com.example.ecodirve.Application.rewards.domain.service.RewardService;
import com.example.ecodirve.Application.rewards.mapping.RewardMapper;
import com.example.ecodirve.Application.rewards.resource.CreateRewardResource;
import com.example.ecodirve.Application.rewards.resource.RewardResource;
import com.example.ecodirve.Application.rewards.resource.UpdateRewardResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@Validated
@RestController
@RequestMapping("/api/v1/fleets")
public class RewardController  {

    private final RewardService rewardService;
    private final RewardMapper mapper;

    public RewardController(RewardService rewardService, RewardMapper mapper){
        this.rewardService=rewardService;
        this.mapper=mapper;
    }
    //GET ALL
    @GetMapping
    public List<RewardResource> getAllRewards(){
        return mapper.modelList(rewardService.getAll());
        //return mapper.modelList_(rewardService.getAll());
    }
    //GET BY ID
    @GetMapping("{rewardId}")
    public RewardResource getRewardById(@PathVariable Long rewardId){
        return mapper.toResource(rewardService.getById(rewardId));
    }
    //GET REWARD By FLEET ID
    @GetMapping("/{fleetId}/rewards")
    public List<RewardResource> getRewardByFleetId(@PathVariable Long fleetId){
        return mapper.modelList(rewardService.getRewardsByFleetId(fleetId));
    }
    //POST
    @PostMapping
    public RewardResource createReward(@RequestBody CreateRewardResource resource){
        return mapper.toResource(rewardService.create(mapper.toModel(resource)));
    }
    //UPDATE
    @PutMapping("/{rewardId}")
    public  RewardResource updateReward(@PathVariable Long rewardId,@RequestBody UpdateRewardResource request){
        return mapper.toResource(rewardService.update(rewardId,mapper.toModel(request)));
    }
    //DELETE
    @DeleteMapping("/{rewardId}")
    public ResponseEntity<?> deleteReward(@PathVariable Long rewardId){
        return rewardService.delete(rewardId);
    }


}
