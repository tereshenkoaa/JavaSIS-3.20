package com.github.tereshenkoaa.homework7.shell;

import com.github.tereshenkoaa.homework7.WeatherService;
import com.github.tereshenkoaa.homework7.data.WeatherDataService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.stream.Collectors;

@ShellComponent
public class ShellCommands {

    private final WeatherService weatherService;
    private final WeatherDataService weatherDataService;

    public ShellCommands(WeatherService weatherService, WeatherDataService weatherDataService) {
        this.weatherService = weatherService;
        this.weatherDataService = weatherDataService;
    }

    @ShellMethod("Узнать погоду по умолчанию - Красноярск, желаемый город через пробел")
    public String w(
            @ShellOption(defaultValue = "Красноярск")
        String city) {
        String res = weatherService.getWeather(city);
        weatherDataService.save(city,res);
        return res;

    }

    @ShellMethod("Показать все")
    public String show() {
       return weatherDataService.findAll().stream().collect(Collectors.joining(System.lineSeparator()));
    }

}
