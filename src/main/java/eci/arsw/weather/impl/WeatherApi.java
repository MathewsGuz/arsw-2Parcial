/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.weather.impl;

import eci.arsw.weather.persistance.weatherPersistance;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2108263
 */
@RestController
@RequestMapping (value = "/index")
@Service
public class WeatherApi {
    @Autowired
    weatherPersistance wet;
    
    @RequestMapping(method = RequestMethod.GET,value="/{city}")
    public ResponseEntity<?> getinfo(@PathVariable("city") String city){
        try{
            return new ResponseEntity<>(wet.getWeather(city),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(WeatherApi .class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }
}
