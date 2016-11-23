/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.LListadoAsistencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author APRENDIZ
 */
public class DListadoAsistencia {
    
    public static void buscarFicha(){
    
       try {
            Statement st = Conexion.getConect().createStatement();
             ResultSet rs = st.executeQuery("select ficha from formaciones ");
            
            while(rs.next()){
            
            Vista.VConsulta.getCbxFicha().addItem(rs.getString("ficha"));
            }     
        } catch (SQLException ex) {
            Logger.getLogger(LListadoAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static ResultSet consultarUsuaFicha (String ficha){
        
        ResultSet rs1 = null;
            
            try {
                Statement st = Conexion.getConect().createStatement();
                rs1 = st.executeQuery("select documento,nombres,apellido from usuarios where ficha = '"+ficha+"' " );

            } catch (SQLException ex) {
                Logger.getLogger(LListadoAsistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return rs1;
    }

    public static ResultSet consultarUsuaFicha (){
        
        ResultSet rs1 = null;
        
        try {
            Statement st = Conexion.getConect().createStatement();
            rs1 = st.executeQuery("select documento  from usuarios  " );
   
        } catch (SQLException ex) {
            Logger.getLogger(LListadoAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return rs1;
    }
    
}
