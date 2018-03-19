package com.flash.weather.services;

import com.flash.weather.gateway.WeatherGateway;
import com.flash.weather.gateway.adapter.WeatherRequestConverter;
import com.flash.weather.gateway.adapter.WeatherResponseConverter;
import com.flash.weather.model.Weather;
import com.flash.weather.model.WeatherGatewayRequest;
import com.flash.weather.model.WeatherGatewayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherGateway weatherGateway;
    private final WeatherRequestConverter weatherRequestConverter;
    private final WeatherResponseConverter weatherResponseConverter;

    public Weather getWeather(String country, String city) {
        WeatherGatewayRequest request = weatherRequestConverter
                .convertToWeatherGatewayRequest(country, city);

        WeatherGatewayResponse response = weatherGateway.getWeather(request);

        return weatherResponseConverter.convertToWeather(
                response,
                country,
                city);
    }
}
