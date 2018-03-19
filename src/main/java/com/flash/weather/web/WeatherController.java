package com.flash.weather.web;

import com.flash.weather.model.Weather;
import com.flash.weather.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @RequestMapping("/{country}/{city}")
    public Weather getWeather (@PathVariable String country,
                             @PathVariable String city) {
        return weatherService.getWeather(country, city);
    }
}
