package com.gladguys.polisapi.clientScraping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PolisScrapingClientCreator {

    @Value("${polis.scraping}")
    private String polisScrapingURI;

    public WebClient create() {
        return WebClient.create(polisScrapingURI);
    }
}
