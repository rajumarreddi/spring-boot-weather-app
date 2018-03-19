package com.flash.weather.gateway.adapter;

import com.flash.weather.model.Weather;
import com.flash.weather.model.WeatherGatewayRequest;
import com.flash.weather.model.WeatherGatewayResponse;
import org.springframework.stereotype.Component;

@Component
public class WeatherResponseConverter {

    public Weather convertToWeather(
            WeatherGatewayResponse weatherGatewayResponse,
            String country,
            String city) {

        Weather weather = new Weather();
        weather.setCountry(country);
        weather.setCity(city);
        weather.setTemperature(weatherGatewayResponse.getTemperature());
        weather.setTimestamp(weatherGatewayResponse.getTimestamp());
        weather.setWeatherDescription(weatherGatewayResponse.getWeatherDescription());
        weather.setWeatherIcon(weatherGatewayResponse.getWeatherIcon());
        weather.setWeatherId(weatherGatewayResponse.getWeatherId());
        weather.setWeatherMain(weatherGatewayResponse.getWeatherMain());
        return weather;
    }
}
