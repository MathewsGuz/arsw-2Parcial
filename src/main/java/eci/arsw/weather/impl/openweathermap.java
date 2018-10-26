/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.weather.impl;

/**
 *
 * @author 2108263
 */
public class openweathermap implements externalUrlGetter{
    public String url;
    @Override
    public String getUrl(String city) {
        url ="http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=c73bafead5576aac411eb50844cdaa53";
        return url;
    }
    
}
