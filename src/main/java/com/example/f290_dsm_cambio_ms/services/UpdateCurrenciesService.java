package com.example.f290_dsm_cambio_ms.services;

import com.example.f290_dsm_cambio_ms.data.dto.CurrenciesDTO;
import com.example.f290_dsm_cambio_ms.data.dto.CurrencyDTO;
import com.example.f290_dsm_cambio_ms.domain.entities.BitCoin;
import com.example.f290_dsm_cambio_ms.domain.entities.Dollar;
import com.example.f290_dsm_cambio_ms.domain.entities.Euro;
import com.example.f290_dsm_cambio_ms.domain.repositories.BitCoinRepository;
import com.example.f290_dsm_cambio_ms.domain.repositories.DollarRepository;
import com.example.f290_dsm_cambio_ms.domain.repositories.EuroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class UpdateCurrenciesService {
    private final DollarRepository dollarRepository;
    private final EuroRepository euroRepository;
    private final BitCoinRepository bitCoinRepository;
    private final ModelMapper mapper;

    private final RestClient restClient;

    public UpdateCurrenciesService(
            DollarRepository dollarRepository,
            EuroRepository euroRepository,
            BitCoinRepository bitCoinRepository,
            ModelMapper mapper,
            RestClient restClient) {
        this.dollarRepository = dollarRepository;
        this.euroRepository = euroRepository;
        this.bitCoinRepository = bitCoinRepository;
        this.mapper = mapper;
        this.restClient = restClient;
    }

    @Scheduled(fixedDelay = 600000)
    public void update() {
        CurrenciesDTO dto = restClient.get()
                .uri("https://api.hgbrasil.com/finance?key=90230925")
                .retrieve()
                .body(CurrenciesDTO.class);

        assert dto != null;
        CurrencyDTO dollarDTO = dto.getResults().getCurrencies().getDollar();
        Dollar dollar = mapper.map(dollarDTO, Dollar.class);

        CurrencyDTO euroDTO = dto.getResults().getCurrencies().getEuro();
        Euro euro = mapper.map(euroDTO, Euro.class);

        CurrencyDTO bitCoinDTO = dto.getResults().getCurrencies().getBitCoin();
        BitCoin bitCoin = mapper.map(bitCoinDTO, BitCoin.class);

        dollarRepository.save(dollar);
        euroRepository.save(euro);
        bitCoinRepository.save(bitCoin);
    }
}
