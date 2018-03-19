package com.flash.weather.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WeatherGatewayRequest {

    @Getter
    private final String country;

    @Getter
    private final String city;
}
