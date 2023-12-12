package com.example.aftas.VMs.response;

import com.example.aftas.entities.Fish;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelResponse {
    private Integer level;
    private String description;
    private Integer points;
    private List<Fish> fishList;
}
