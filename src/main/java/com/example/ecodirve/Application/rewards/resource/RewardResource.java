package com.example.ecodirve.Application.rewards.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class RewardResource {
    private Long id;
    @JsonIgnore
    private Long fleetId;
    private String name;
    private String description;
    private Double score;
}
