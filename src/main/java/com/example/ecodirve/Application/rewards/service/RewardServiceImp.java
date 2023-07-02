package com.example.ecodirve.Application.rewards.service;

import com.example.ecodirve.Application.rewards.domain.model.Reward;
import com.example.ecodirve.Application.rewards.domain.persistence.RewardRepository;
import com.example.ecodirve.Application.rewards.domain.service.RewardService;
import com.example.ecodirve.Shared.exception.ResourceNotFoundException;
import com.example.ecodirve.Shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RewardServiceImp implements RewardService {

    private static final String ENTITY="Reward";
    private final RewardRepository rewardRepository;
    private final Validator validator;

    public RewardServiceImp(RewardRepository rewardRepository, Validator validator){
        this.rewardRepository=rewardRepository;
        this.validator =validator;
    }
    @Override
    public List<Reward> getAll() {
        return rewardRepository.findAll();
    }

    @Override
    public List<Reward> getRewardByScore(Double score) {
        return rewardRepository.findByScore(score);
    }

    @Override
    public List<Reward> getRewardsByFleetId(Long fleetId) {
        return rewardRepository.findByFleetId(fleetId);
    }

    @Override
    public Reward getNameAndFleetId(String name, Long fleetId) {
        return rewardRepository.findByNameAndFleetId(name,fleetId);
    }

    @Override
    public Reward getByName(String name) {
        return rewardRepository.findByName(name);
    }

    @Override
    public Page<Reward> getAll(Pageable pageable) {
        return rewardRepository.findAll(pageable);
    }

    @Override
    public Reward getById(Long rewardId) {
        return rewardRepository.findById(rewardId).orElseThrow(()->new ResourceNotFoundException(ENTITY,rewardId));
    }

    @Override
    public Reward create(Reward reward) {
        Set<ConstraintViolation<Reward>> violations=validator.validate(reward);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);

        //validator for name
        Reward rewardWithSameNameAndFleetId=rewardRepository.findByNameAndFleetId(reward.getName(), reward.getFleetId());
        if(rewardWithSameNameAndFleetId!=null)
            throw new ResourceValidationException(ENTITY,"Reward with the same name already exists");

        //validator for score
        if(reward.getScore()<=0)
            throw new ResourceValidationException(ENTITY,"You must register a score with more than 0");
        return rewardRepository.save(reward);
    }

    @Override
    public Reward update(Long rewardId, Reward request) {
        return rewardRepository.save(request);
    }

    @Override
    public ResponseEntity<?> delete(Long rewardId) {
        return rewardRepository.findById(rewardId).map(reward -> {
            rewardRepository.delete(reward);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,rewardId));
    }
}
