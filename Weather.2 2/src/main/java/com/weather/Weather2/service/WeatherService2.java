package com.weather.Weather2.service;

import com.weather.Weather2.trash.City;
import com.weather.Weather2.entity.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService2 {

    public WeatherResponse getDataLatLon(String lat, String lon){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<WeatherResponse> response = rt.getForEntity("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=463d5ac617c3747461485d42e01a221e&units=metric", WeatherResponse.class);
//        System.out.println(response.getBody().getClass());
        return response.getBody();
    }


    public List<Double> getCityResponse(String city) {
        List<Double> coord = new ArrayList<>();
        RestTemplate template = new RestTemplate();
        ResponseEntity<City[]> entity = template.getForEntity("https://api.openweathermap.org/geo/1.0/direct?q="+city+"&limit=1&appid=d148e0117c66d69d944d5b06b5e14ce1",City[].class);
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

}
