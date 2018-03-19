package com.flash.weather.services;

import com.flash.weather.gateway.WeatherGateway;
import com.flash.weather.gateway.adapter.WeatherRequestConverter;
import com.flash.weather.gateway.adapter.WeatherResponseConverter;
import com.flash.weather.model.Weather;
import com.flash.weather.model.WeatherGatewayRequest;
import com.flash.weather.model.WeatherGatewayResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

    @Mock
    WeatherGateway weatherGateway;

    @Mock
    WeatherGatewayResponse weatherGatewayResponse;

    @Mock
    WeatherRequestConverter weatherRequestConverter;

    @Mock
    WeatherResponseConverter weatherResponseConverter;

    Weather weather;

    @InjectMocks
    WeatherService weatherService;

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
        System.out.println(weather.getCity());
        assertEquals("Hyderabad", weather.getCity());
    }
}