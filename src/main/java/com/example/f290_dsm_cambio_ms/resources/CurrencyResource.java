package com.example.f290_dsm_cambio_ms.resources;

import com.example.f290_dsm_cambio_ms.data.dto.CurrenciesDTO;
import com.example.f290_dsm_cambio_ms.data.dto.CurrencyDTO;
import com.example.f290_dsm_cambio_ms.domain.entities.Dollar;
import com.example.f290_dsm_cambio_ms.domain.repositories.DollarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;


@RestController
@RequestMapping("/currencies")
public class CurrencyResource {

    private final RestClient restClient;
    private final DollarRepository dollarRepository;
    private final ModelMapper mapper;

    public CurrencyResource(
            RestClient restClient,
            DollarRepository dollarRepository,
            ModelMapper mapper) {
        this.restClient = restClient;
        this.dollarRepository = dollarRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public CurrenciesDTO getCurrencies() {
        return restClient.get()
                .uri("https://api.hgbrasil.com/finance?key=90230925")
                .retrieve()
                .body(CurrenciesDTO.class);
    }

    @GetMapping("/dollar")
    public CurrencyDTO getDollarCurrency() {
        Dollar dollar = dollarRepository.getLast();
        return mapper.map(dollar, CurrencyDTO.class);
    }
}
