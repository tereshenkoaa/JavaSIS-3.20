package com.github.tereshenkoaa.homework7.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final JdbcTemplate jdbcTemplate;

    public WeatherDataServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String city, String temp) {
        Date date = new Date();
        String str = "";
        str = str.concat(date.toString()).concat(" ").concat(city).concat(" ").concat(temp);
        jdbcTemplate.update("INSERT INTO temps_log (log) VALUES (?)",str);
    }

    @Override
    public List<String> findAll() {
        return jdbcTemplate.query("select * from temps_log",((rs, rowNum) ->
                rs.getString("log")));
    }
}
