package com.weather.Weather2.trash;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class WeatherApiResponse {
    @JsonProperty("weather")
    List<Weather> weathers = new ArrayList<>();
    Coord coord;
    String base;
    Main main;
    Integer visibility;
    Wind wind;
    Sys sys;
    String name;


}
