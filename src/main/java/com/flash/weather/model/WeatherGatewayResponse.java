package com.flash.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherGatewayResponse implements Serializable {

    @JsonProperty("timestamp")
    @JsonSetter("dt")
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

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        setTemperature(Double.parseDouble(main.get("temp").toString()));
    }

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        setWeatherId((Integer) weather.get("id"));
        setWeatherIcon((String) weather.get("icon"));
        setWeatherMain((String) weather.get("main"));
        setWeatherDescription((String) weather.get("description"));
    }

}