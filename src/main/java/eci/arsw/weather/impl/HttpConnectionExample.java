/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.arsw.weather.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author 2108263
 */
@Service
public class HttpConnectionExample extends Thread{
    
    @Autowired
    private externalUrlGetter Uget;
    
    private static final String USER_AGENT = "Mozilla/5.0";
    
    private String URL;

    private static String result;

    public String getResult() throws IOException {
        return result;
    }

    @Override
    public void run(){
        URL obj;
        try {
            obj = new URL(URL);
        
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            result=response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpConnectionExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpConnectionExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void enlace(String City){
        URL = Uget.getUrl(City);
    }
        
    
    public String getURL() {
        return URL;
    }

}
