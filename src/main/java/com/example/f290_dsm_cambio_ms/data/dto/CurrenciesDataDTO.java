package com.example.f290_dsm_cambio_ms.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrenciesDataDTO {
    @JsonProperty("USD")
    private CurrencyDTO dollar;
    @JsonProperty("EUR")
    private CurrencyDTO euro;
    @JsonProperty("BTC")
    private CurrencyDTO bitCoin;
}
