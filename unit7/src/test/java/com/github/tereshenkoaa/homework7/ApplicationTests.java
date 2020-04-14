package com.github.tereshenkoaa.homework7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(InteractiveShellApplicationRunner
        .SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner
        .SPRING_SHELL_SCRIPT_ENABLED + "=false")
class ApplicationTests {

    @Autowired
    private WeatherService weatherService;
    @Test
    public void getWeather() {
        String weather = weatherService.getWeather();
        assertNotNull(weather);

        System.out.println(weather);
    }

}