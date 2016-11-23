/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author APRENDIZ
 */
public class UFechas {
    public static String convertirDateAString (Date fecha){
        String fechaString;
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        fechaString = formato.format(fecha);
        
        return fechaString;
    }
    
    public static Date convertirStrinADate( String fecha){
        Date fechaDate = null;
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            fechaDate = formato.parse(fecha);
            
        } catch (ParseException ex) {
            Logger.getLogger(UFechas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fechaDate;
    }
}
