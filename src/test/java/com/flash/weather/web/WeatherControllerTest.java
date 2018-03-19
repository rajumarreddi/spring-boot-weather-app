package com.flash.weather.web;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void getWeather_whenCountryIsIndiaAndCityIsHyderabad_shouldReturnAllFieldsOfWeatherObject() throws Exception  {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/weather/India/Hyderabad").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.country").exists())
                .andExpect(jsonPath("$.city").exists())
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.temperature").exists())
                .andExpect(jsonPath("$.weatherId").exists())
                .andExpect(jsonPath("$.weatherIcon").exists())
                .andExpect(jsonPath("$.weatherMain").exists())
                .andExpect(jsonPath("$.weatherDescription").exists())
                .andDo(print());
    }

    @Test
    public void getWeather_whenCountryIsIndiaAndCityIsHyderabad_cityAndCountryShouldBeSameAsInRequest() throws Exception  {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/weather/India/Hyderabad").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.country").value("India"))
                .andExpect(jsonPath("$.city").value("Hyderabad"))
                .andDo(print());
    }

    @Test
    public void getWeather_whenCountryAndCityAreInvalid_shouldReturnError() throws Exception  {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/weather/{country}/{city}", "null","null"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
}