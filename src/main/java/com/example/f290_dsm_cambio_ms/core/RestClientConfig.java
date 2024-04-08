package com.example.f290_dsm_cambio_ms.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RestClientConfig {
    @Bean
    public RestClient getRestClient() {
        return RestClient.create();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
