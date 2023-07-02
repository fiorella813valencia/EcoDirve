package com.example.ecodirve.Application.rewards.domain.persistence;

import com.example.ecodirve.Application.rewards.domain.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RewardRepository extends JpaRepository<Reward,Long> {

}
