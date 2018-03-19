package com.flash.weather.gateway.adapter;

import com.flash.weather.model.WeatherGatewayRequest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherRequestConverterTest {

    WeatherGatewayRequest weatherGatewayRequest;
    @Mock
    WeatherRequestConverter weatherRequestConverter;


    @Before
    public void setUp() throws Exception {
        weatherGatewayRequest = new WeatherGatewayRequest("India","Hyderabad");
    }

    @Test
    public void convertToWeatherGatewayRequest() {
        when(weatherRequestConverter.convertToWeatherGatewayRequest("India", "Hyderabad")).thenReturn(weatherGatewayRequest);
        WeatherGatewayRequest weatherGatewayRequest = weatherRequestConverter.convertToWeatherGatewayRequest("India","Hyderabad");
        Assert.assertEquals("India",weatherGatewayRequest.getCountry());
    }
}