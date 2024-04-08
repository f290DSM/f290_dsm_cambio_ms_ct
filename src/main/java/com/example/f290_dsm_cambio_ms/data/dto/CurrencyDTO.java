package com.example.f290_dsm_cambio_ms.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CurrencyDTO {
    private String name;
    private Double buy;
    private Double sell;
    private Double variation;
    private LocalDateTime date = LocalDateTime.now();
}
