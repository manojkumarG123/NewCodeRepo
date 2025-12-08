package com.login.login.clientHandler;

import com.login.login.LogInDto.CustomerRequest;
import com.login.login.LogInDto.CustomerResponse;
import com.login.login.configuration.CustomerWebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class CustomerClientHandler {
    private String baseUrl ;
    private WebClient webClient ;
    public CustomerClientHandler(@Value("${api.customer.base.url}") String baseUrl, WebClient webClient) {
        this.baseUrl = baseUrl;
        this.webClient = webClient;
    }
    public List<CustomerResponse> getAllDetails() {
        return webClient.get()
                .uri(baseUrl+"/customer")
                .retrieve()
                .bodyToFlux(CustomerResponse.class)
                .collectList()
                .block();
    }
    public CustomerResponse getCustomerById(Long id) {
        return webClient.get()
                .uri(baseUrl+"/customer"+id)
                .retrieve()
                .bodyToMono(CustomerResponse.class)
                .block();
    }

}
