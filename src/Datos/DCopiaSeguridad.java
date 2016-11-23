/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author APRENDIZ
 */
public class DCopiaSeguridad {
    
    public static ResultSet buscarUsuario(){
        
        ResultSet rs = null;
        
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select * from ingreso_salida_usu" );
            
        } catch (SQLException ex) {
            Logger.getLogger(DCopiaSeguridad.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return  rs;
    }
    
    public static void borrarTabla(){

        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from ingreso_salida_usu" );
            JOptionPane.showMessageDialog(null,"Los Datos de la tabla Ingreso Fueron Eliminados");
            
        } catch (SQLException ex) {
            Logger.getLogger(DCopiaSeguridad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"No se pudieron eliminar datos");
        }  

    }
}
