package com.weather.Weather2;

import com.weather.Weather2.entity.WeatherResponse;
import com.weather.Weather2.trash.City;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class WeatherResponseTest {

    @Test
    public void getResponse(){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<WeatherResponse> response = rt.getForEntity("https://api.openweathermap.org/data/2.5/weather?lat=50.6659&lon=15.0899&appid=463d5ac617c3747461485d42e01a221e&units=metric", WeatherResponse.class);
        System.out.println(response.getBody());
        WeatherResponse body = response.getBody();

    }



    @Test
    public void getRedsponse(){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.getForEntity("https://api.openweathermap.org/data/2.5/weather?lat=50.6659&lon=15.0899&appid=463d5ac617c3747461485d42e01a221e&units=metric", String.class);
        System.out.println(response.getBody());
    }

    @Test
    public List<Double> getCityResponse() {
        List<Double> coord = new ArrayList<>();
        RestTemplate template = new RestTemplate();
        ResponseEntity<City[]> entity = template.getForEntity("https://api.openweathermap.org/geo/1.0/direct?q=lhota&limit=1&appid=d148e0117c66d69d944d5b06b5e14ce1",City[].class);
        City[] cityArray = entity.getBody();
        List<Double> latCollect = Arrays.stream(cityArray)
                .map(City::getLat)
                .collect(Collectors.toList());
        latCollect.forEach(System.out::println);

        List<Double> lonCollect = Arrays.stream(cityArray)
                .map(City::getLon)
                .collect(Collectors.toList());
        coord.add(latCollect.get(0));
        coord.add(lonCollect.get(0));

        return coord;
    }

    @Test
    public void getCityRespovnse() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> entity = template.getForEntity("https://api.openweathermap.org/geo/1.0/direct?q=lhota&limit=1&appid=d148e0117c66d69d944d5b06b5e14ce1",String.class);
        System.out.println(entity.getBody());
    }
}





