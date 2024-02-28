package com.weather.Weather2.controller;

import com.weather.Weather2.entity.WeatherResponse;
import com.weather.Weather2.service.WeatherService2;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/weather2")
public class WeatherController {

    private WeatherService2 weatherService2;

    public WeatherController(WeatherService2 weatherService2) {
        this.weatherService2 = weatherService2;
    }


    @RequestMapping("/weather")
    public String showWeather2(){
        return "homePageindex";
    }

    @RequestMapping("/coordinates")
    public String coordinates(){
        return "indexLocation";
    }



    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, ModelMap model){
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        System.out.println(latitude+" "+longitude);
        WeatherResponse dataLatLon = weatherService2.getDataLatLon(latitude, longitude);
        model.put("weather",dataLatLon);
        return "coordTemp";
    }

    @RequestMapping("/city")
    public String processFormcity(){
        return "indexCity";
    }

    @RequestMapping("/finalCity")
    public String getCityTemp(HttpServletRequest request, ModelMap model){
        String city = request.getParameter("city");
        List<Double> cityResponse = weatherService2.getCityResponse(city);
        WeatherResponse dataLatLon = weatherService2.getDataLatLon(String.valueOf(cityResponse.get(0)), String.valueOf(cityResponse.get(1)));
        model.put("weather",dataLatLon);
        return "cityTemp";
    }


}
