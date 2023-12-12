package com.example.aftas.VMs.response;

import com.example.aftas.entities.Hunt;
import com.example.aftas.entities.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    private String name;
    private String familyName;
    private Integer membershipNumber;
    private Date accessDate;
    private String nationality;
    private List<Rank> ranks;
    private List<Hunt> hunts;
}
