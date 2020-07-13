package com.gladguys.polisapi.clientScraping;

import com.gladguys.polisapi.models.CotaEstado;
import com.gladguys.polisapi.models.dto.CotasEstadosList;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;

@Component
public class PolisScraping {

    private PolisScrapingClientCreator polisScrapingClientCreator;
    private ClientRequestExecutor clientRequestExecutor;

    public PolisScraping(PolisScrapingClientCreator polisScrapingClientCreator, ClientRequestExecutor clientRequestExecutor) {
        this.polisScrapingClientCreator = polisScrapingClientCreator;
        this.clientRequestExecutor = clientRequestExecutor;
    }

    public List<CotaEstado> getCotasPorEstado() {
        WebClient client = polisScrapingClientCreator.create();
        CotasEstadosList cotasEstadosList =
                clientRequestExecutor.execute(client, HttpMethod.GET, "/cotas/cota-estados", CotasEstadosList.class);
        return cotasEstadosList.getCotasEstados();
    }
}
