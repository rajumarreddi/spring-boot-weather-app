package com.flash.weather.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

public class Weather {

    @Getter
    @Setter
    public String country;

    @Getter
    @Setter
    public String city;

    @Getter
    @Setter
    private Instant timestamp;

    @Getter
    @Setter
    private double temperature;

    @Getter
    @Setter
    private Integer weatherId;

    @Getter
    @Setter
    private String weatherIcon;

    @Getter
    @Setter
    private String weatherMain;

    @Getter
    @Setter
    private String weatherDescription;
}