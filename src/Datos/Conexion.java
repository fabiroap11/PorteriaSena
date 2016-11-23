/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author APRENDIZ
 */
public class Conexion {
    
    private static Connection conect = null;
    
    public static void conexion (){
        
        try {
            try {
                 Class.forName("com.mysql.jdbc.Driver");
               Connection  con = DriverManager.getConnection("jdbc:mysql://localhost/porteria","root","admin");
                setConect(con);
                JOptionPane.showMessageDialog(null, "Ok");
                
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Error");
            }
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    /**
     * @return the conect
     */
    public static Connection getConect() {
        return conect;
    }

    /**
     * @param aConect the conect to set
     */
    public static void setConect(Connection aConect) {
        conect = aConect;
    }
    Connection conexion;
    
}

