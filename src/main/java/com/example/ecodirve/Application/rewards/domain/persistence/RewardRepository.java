package com.example.ecodirve.Application.rewards.domain.persistence;

import com.example.ecodirve.Application.rewards.domain.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward,Long> {

    List<Reward> findAll();

    Reward findByName(String name);
    Reward findByScore(Double score);
    Reward findByFleetId(Long fleetId);

}
