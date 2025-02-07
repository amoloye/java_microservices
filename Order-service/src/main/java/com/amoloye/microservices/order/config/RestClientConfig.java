package com.amoloye.microservices.order.config;

import com.amoloye.microservices.order.client.InventoryClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Configuration
public class RestClientConfig {
    @Value("${inventory.url}")
    private String inventoryServiceUrl;

    @Bean
    public InventoryClient inventoryClient(){
        RestClient restClient = RestClient.builder()
                .baseUrl(inventoryServiceUrl)
                .build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }
}

//@Configuration
//public class RestClientConfig {
//    @Value("${inventory.url}")
//    private String inventoryServiceUrl;
//
//    private static final int TIMEOUT_MILLIS = 3000; // 3 seconds timeout
//
//    @Bean
//    public CloseableHttpClient httpClient() {
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setConnectionRequestTimeout(Timeout.ofMilliseconds(TIMEOUT_MILLIS)) // New way to set connection timeout
//                .setResponseTimeout(Timeout.ofMilliseconds(TIMEOUT_MILLIS)) // Response timeout
//                .build();
//
//        return HttpClients.custom()
//                .setDefaultRequestConfig(requestConfig)
//                .build();
//    }
//
//    @Bean
//    public RestClient restClient(CloseableHttpClient httpClient) {
//        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//        requestFactory.setConnectTimeout(TIMEOUT_MILLIS); // 3 seconds connection timeout
//        requestFactory.setReadTimeout(TIMEOUT_MILLIS); // 3 seconds read timeout
//
//        return RestClient.builder()
//                .baseUrl(inventoryServiceUrl)
//                .requestFactory(requestFactory)
//                .build();
//    }
//
//    @Bean
//    public InventoryClient inventoryClient(RestClient restClient) {
//        var restClientAdapter = RestClientAdapter.create(restClient);
//        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
//        return httpServiceProxyFactory.createClient(InventoryClient.class);
//    }
//}
