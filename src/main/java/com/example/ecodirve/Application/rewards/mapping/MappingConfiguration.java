package com.example.ecodirve.Application.rewards.mapping;

import org.springframework.context.annotation.Bean;

public class MappingConfiguration {
    @Bean
    public RewardMapper productMapper(){
        return new RewardMapper();
    }
}
