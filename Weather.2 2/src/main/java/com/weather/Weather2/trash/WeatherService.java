package com.weather.Weather2.trash;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    public WeatherApiResponse getData(){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<WeatherApiResponse> response = rt.getForEntity("https://api.openweathermap.org/data/2.5/weather?lat=50.6659&lon=15.0899&appid=463d5ac617c3747461485d42e01a221e&units=metric", WeatherApiResponse.class);
        System.out.println(response.getBody().getClass());
        return response.getBody();
    }
}
