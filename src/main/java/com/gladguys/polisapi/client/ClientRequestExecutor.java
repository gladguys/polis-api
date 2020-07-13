package com.gladguys.polisapi.client;

import com.gladguys.polisapi.models.dto.CotasEstadosList;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ClientRequestExecutor {

    public CotasEstadosList execute(WebClient webClient,
                                           HttpMethod httpMethod,
                                           String endpoint,
                                           Class<?> classReturned) {
        return webClient.method(HttpMethod.GET)
                .uri("/cotas/cota-estados")
                .retrieve()
                .bodyToMono(CotasEstadosList.class)
                .block();
    }
}
