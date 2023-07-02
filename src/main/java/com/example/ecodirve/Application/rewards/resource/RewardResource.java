package com.example.ecodirve.Application.rewards.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RewardResource {
    private Long id;
    private Long fleetId;
    private String name;
    private String description;
    private Double score;
}
