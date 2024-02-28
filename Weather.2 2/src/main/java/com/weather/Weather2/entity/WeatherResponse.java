package com.weather.Weather2.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherResponse {
List<Weather2> weather = new ArrayList<>();
private Main2 main;
private String name;
}
