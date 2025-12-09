package com.login.login.clientHandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProductClientHandler {
    private String baseUrl = "http://localhost:8080/login";
    private WebClient webClient ;
    public ProductClientHandler(@Value("${api.customer.base.url}") String baseUrl, WebClient webClient) {
        this.baseUrl = baseUrl;
        this.webClient = webClient;
    }

}
