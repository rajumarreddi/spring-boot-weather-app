package com.flash.weather.gateway.adapter;

import com.flash.weather.model.WeatherGatewayRequest;
import org.springframework.stereotype.Component;

@Component
public class WeatherRequestConverter {

    public WeatherGatewayRequest convertToWeatherGatewayRequest(String country, String city) {
        return new WeatherGatewayRequest(country, city);
    }
}
