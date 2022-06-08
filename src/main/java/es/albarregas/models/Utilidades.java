/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jesus
 */
public class Utilidades {

    public static Date stringToDate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);

        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public static String dateToString(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");
        String fechaString = null;
        
            fechaString = formato.format(fecha);

        
        return fechaString;
    }
    
    public static java.sql.Date utilDateToSqlDate(java.util.Date fecha) {
        return new java.sql.Date(fecha.getTime());
    }

}
