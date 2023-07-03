package com.example.ecodirve.Application.rewards.mapping;

import com.example.ecodirve.Application.rewards.domain.model.Reward;
import com.example.ecodirve.Application.rewards.resource.CreateRewardResource;
import com.example.ecodirve.Application.rewards.resource.RewardResource;
import com.example.ecodirve.Application.rewards.resource.UpdateRewardResource;
import com.example.ecodirve.Shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Component
@EnableAutoConfiguration
public class RewardMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public RewardResource toResource(Reward model){
        return mapper.map(model, RewardResource.class);
    }

    //this throws the object fleetId null, but it will continue showing
    public RewardResource toResource_(Reward model){
        RewardResource resource = new RewardResource();
        resource.setId(model.getId());
        resource.setName(model.getName());
        resource.setDescription(model.getDescription());
        resource.setScore(model.getScore());
        return resource;
    }
    //this throws the object fleetId null, but it will continue showing (list)
    public List<RewardResource> modelList_(List<Reward> modelList) {
        List<RewardResource> resourceList = new ArrayList<>();
        for (Reward model : modelList) {
            RewardResource resource = new RewardResource();
            resource.setId(model.getId());
            resource.setName(model.getName());
            resource.setDescription(model.getDescription());
            resource.setScore(model.getScore());
            resourceList.add(resource);
        }
        return resourceList;
    }

    public Page<RewardResource> modelListPage(List<Reward> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,RewardResource.class),pageable,modelList.size());
    }

    public List<RewardResource> modelList(List<Reward> modelList){
        return mapper.mapList(modelList,RewardResource.class);
    }


    public Reward toModel(CreateRewardResource resource){
        return mapper.map(resource,Reward.class);

    }

    public Reward toModel(UpdateRewardResource resource){
        return mapper.map(resource,Reward.class);
    }

}
