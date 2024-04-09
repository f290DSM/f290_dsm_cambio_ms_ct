package com.example.f290_dsm_cambio_ms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class Cambio {
    private String from = "BRL";
    private String to = "USD";
    private Double factor;
    private Double value;
}
