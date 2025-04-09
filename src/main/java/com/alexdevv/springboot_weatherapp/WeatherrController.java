 
  
  package com.alexdevv.springboot_weatherapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
public class WeatherrController {

    @Value("${weatherapp.api.key}")  
    private String apiKey;
    
    @GetMapping("/weatherapp")
    public String getWeather(@RequestParam String city, Model model) {
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", city, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        
        try {
            WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

            
            if (response == null || response.getMain() == null || response.getWeather() == null || response.getWeather().length == 0) {
                model.addAttribute("error", "City not found or invalid data.");
                return "weatherapp";  
            }
        
        
        double temperature = response.getMain().getTemp();
        int humidity = response.getMain().getHumidity();
        String cityName = response.getName();
        double speed=response.getWind().getSpeed();
        int pressure=response.getMain().getPressure();
        int deg=response.getWind().getDeg();
        List<WeatherResponse.Weather> weatherList = List.of(response.getWeather());                                  
        String weatherMain = response.getWeather()[0].getMain(); 
        String weatherDescription = response.getWeather()[0].getDescription();  
        String iconCode = weatherList.get(0).getIcon();  
        
                                            

        long dt = response.getDt(); 


            Instant instant = Instant.ofEpochSecond(dt);
            ZonedDateTime dateTime = instant.atZone(ZoneId.systemDefault());
            String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
         

        model.addAttribute("temperature", temperature);
        model.addAttribute("humidity", humidity);
        model.addAttribute("city", cityName);
        model.addAttribute("speed", speed);
        model.addAttribute("pressure", pressure);
        model.addAttribute("deg", deg);
        model.addAttribute("dateTime", formattedDate);

        model.addAttribute("weatherMain", weatherMain); 
        model.addAttribute("weatherDescription", weatherDescription);  
       model.addAttribute("iconCode", iconCode);  
        

        return "weatherapp"; 
    } catch (Exception e) {
        
        model.addAttribute("error", "Error fetching weather data. Please try again later.");
        return "weatherapp";  
    }
    }

    
}

 
