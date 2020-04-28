package com.github.tereshenkoaa.homework7.data;

import org.springframework.stereotype.Service;

import java.util.List;

public interface WeatherDataService {

    void save(String city, String temp);
    List<String> findAll();

}
