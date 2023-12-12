package com.example.aftas.VMs.response;

import com.example.aftas.entities.Hunt;
import com.example.aftas.entities.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FishResponse {
    private String name;
    private Double averageWeight;
    private List<Hunt> hunts;
    private Level level;
}
