/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.weather.persistance;

/**
 *
 * @author 2108263
 */


public interface weatherPersistance {
    
     /**
     * 
     * @param city location that will be searched
     * @return the weather of the given city
     * @throws 
     */
    public Object getWeather(String city);
}
