package com.github.tereshenkoaa.homework7;

import com.github.tereshenkoaa.homework7.dto.MainDTO;
import com.github.tereshenkoaa.homework7.dto.WeatherDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;

    public WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getWeather(String city) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-host","community-open-weather-map.p.rapidapi.com");
        headers.set("x-rapidapi-key","cdd96ad95amsheebcca53e65aac1p136010jsn18e30e4e6350");

        HttpEntity entity = new HttpEntity(headers);

        String url = "https://community-open-weather-map.p.rapidapi.com/weather?units=metric&mode=json&q="+city;

        ResponseEntity<WeatherDTO> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, WeatherDTO.class);

        return responseEntity.getBody().getMain().getTemp();
    }
}
