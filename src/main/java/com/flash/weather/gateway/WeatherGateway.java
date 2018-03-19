package com.flash.weather.gateway;

import com.flash.weather.model.WeatherGatewayRequest;
import com.flash.weather.model.WeatherGatewayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;

@Service
public class WeatherGateway {

    private final RestTemplate restTemplate;
    private final String url;
    private static final Logger logger = LoggerFactory.getLogger(WeatherGateway.class);

    WeatherGateway(@Qualifier("weatherClient") RestTemplate restTemplate,
                   @Value("${gateway.endpoint.weather}") String endpoint) {
        this.restTemplate = restTemplate;
        this.url = endpoint;
    }

    @Cacheable
    public WeatherGatewayResponse getWeather(WeatherGatewayRequest weatherGatewayRequest) {
        logger.info("Requesting current weather for {}/{}",
                weatherGatewayRequest.getCountry(),
                weatherGatewayRequest.getCity());
        URI uri = new UriTemplate(url).expand(
                weatherGatewayRequest.getCity(),
                weatherGatewayRequest.getCountry());
        return restTemplate.getForObject( uri, WeatherGatewayResponse.class );
    }
}
