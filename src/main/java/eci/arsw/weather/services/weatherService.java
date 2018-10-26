/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.weather.services;
import eci.arsw.weather.impl.HttpConnectionExample;
import eci.arsw.weather.persistance.weatherPersistance;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author 2108263
 */
@Service
public class weatherService implements weatherPersistance{
    public String answer=null;
    @Autowired
    HttpConnectionExample enlace;
    @Override
    public Object getWeather(String city) {
        enlace.enlace(city);
        try {
            enlace.run();
            answer =enlace.getResult();
        } catch (IOException ex) {
            Logger.getLogger(weatherService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return answer;
    }
}
