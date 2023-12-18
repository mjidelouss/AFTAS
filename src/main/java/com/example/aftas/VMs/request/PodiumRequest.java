package com.example.aftas.VMs.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PodiumRequest {
    @NotNull(message = "Code Cannot Be Null")
    public String code;
}
