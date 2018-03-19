package com.flash.weather.services;

import com.flash.weather.gateway.WeatherGateway;
import com.flash.weather.gateway.adapter.WeatherRequestConverter;
import com.flash.weather.gateway.adapter.WeatherResponseConverter;
import com.flash.weather.model.Weather;
import com.flash.weather.model.WeatherGatewayRequest;
import com.flash.weather.model.WeatherGatewayResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceMockSpringContextTest {

    @MockBean
    WeatherGateway weatherGateway;

    @Autowired
    WeatherService weatherService;

    @MockBean
    WeatherRequestConverter weatherRequestConverter;

    @MockBean
    WeatherResponseConverter weatherResponseConverter;

    @Mock
    WeatherGatewayResponse weatherGatewayResponse;

    Weather weather;
    WeatherGatewayRequest request;

    @Before
    public void setUp(){
        request = new WeatherGatewayRequest("India","Hyderabad");
        weatherGatewayResponse.setTemperature(36.0);
        weatherGatewayResponse.setWeatherId(101);
        weather = new Weather();
        weather.setCity("Hyderabad");
        weather.setCountry("India");
    }

    @Test
    public void getWeather() {
        when(weatherRequestConverter.convertToWeatherGatewayRequest("India","Hyderabad")).thenReturn(request);
        when(weatherGateway.getWeather(request)).thenReturn(weatherGatewayResponse);
        when(weatherResponseConverter.convertToWeather(weatherGatewayResponse,"India","Hyderabad")).thenReturn(weather);
        Weather weather = weatherService.getWeather("India","Hyderabad");
        System.out.println("City ==========>"+weather.getCity());
    }
}