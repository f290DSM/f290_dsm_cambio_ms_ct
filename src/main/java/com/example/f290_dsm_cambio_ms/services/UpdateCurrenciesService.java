package com.example.f290_dsm_cambio_ms.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UpdateCurrenciesService {

    //TODO: Incluir dependencias

    //TODO: Inicializar dependencias via default constructor

    @Scheduled(fixedDelay = 60000)
    public void update() {
        //TODO: Realizar requisição ao HGBrasil para obter cotações

        //TODO: Persistir cotações de Dollar, Euro e BtCoin
    }
}
