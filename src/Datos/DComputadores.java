/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author APRENDIZ
 */
public class DComputadores {
    
    public static void registrarComputador (String serial, String marca, String prop){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("insert into equipos values ('"+serial+"', '"+marca+"', '"+prop+"' )");
            
        } catch (SQLException ex) {
            Logger.getLogger(DComputadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void eliminarComputador (String equi){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            
            st.execute("delete from equipos where serial_equipo = '"+equi+"' ");
            
        } catch (SQLException ex) {
            Logger.getLogger(DComputadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
