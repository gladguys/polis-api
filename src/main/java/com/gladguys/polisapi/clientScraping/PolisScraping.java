package com.gladguys.polisapi.clientScraping;

import com.gladguys.polisapi.models.CotaEstado;
import com.gladguys.polisapi.models.dto.CotasEstadosList;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Component
public class PolisScraping {

    public List<CotaEstado> getCotasPorEstado() {
        WebClient client = WebClient.create("http://localhost:8081");
        CotasEstadosList cotasEstadosList = client.method(HttpMethod.GET)
                .uri("/cotas/cota-estados")
                .retrieve()
                .bodyToMono(CotasEstadosList.class)
                .block();
        return cotasEstadosList.getCotasEstados();
    }
}
