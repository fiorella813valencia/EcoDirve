package com.example.ecodirve.Application.rewards.domain.persistence;

import com.example.ecodirve.Application.rewards.domain.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardRepository extends JpaRepository<Reward,Long> {

    List<Reward> findAll();
    List<Reward> findByScore(Double score);
    Reward findByNameAndFleetId(String name, Long fleetId);
    Reward findByName(String name);

    List<Reward> findByFleetId(Long fleetId);


}
