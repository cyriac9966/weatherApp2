package com.weather.Weather2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main2 {
    private Integer temp;
    @JsonProperty("feels_like")
    private Integer feelsLike;
    @JsonProperty("temp_min")
    private Integer tempMin;
    @JsonProperty("temp_max")
    private Integer tempMax;
    private Integer pressure;
    private Integer humidity;
    @JsonProperty("sea_level")
    private Integer seaLevel;
    @JsonProperty("grnd_level")
    private Integer grndLevel;
}
