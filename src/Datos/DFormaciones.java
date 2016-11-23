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
public class DFormaciones {
    
    public static void registrarFormacion (String ficha, String form, String hor){
    
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("insert into formaciones values ('"+ficha+"', '"+form+"', '"+hor+"')");
            JOptionPane.showMessageDialog(null, "Formacion Guardada");
            
        } catch (SQLException ex) {
            Logger.getLogger(DFormaciones.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Guardadar La Formacion");
        }
    }
    
    public static void eliminarFormacion (String ficha){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from formaciones where ficha = '"+ficha+"' ");
            JOptionPane.showMessageDialog(null, "Formacion Eliminada");
            
        } catch (SQLException ex) {
            Logger.getLogger(DFormaciones.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Eliminar La Formacion");

        }
    }
    public static void editarFormacion (String ficha, String form, String hor){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("update formaciones set ficha ='"+ficha+"', nom_formacion='"+form+"', id_horario='"+hor+"' where ficha = '"+ficha+"' ");
            JOptionPane.showMessageDialog(null, "Formacion Editada");
            
        } catch (SQLException ex) {
            Logger.getLogger(DFormaciones.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Editar La Formacion");

        }
    }
    
    public static void buscarHorario (){
        
        try {
            Statement st = Conexion.getConect().createStatement(); 
            ResultSet rs = st.executeQuery("select descripcion from horarios");
            while(rs.next()){
            
            Vista.VFormaciones.getCbxHorario().addItem(rs.getString("descripcion"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DFormaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet buscarFormacion(String fic){
        
        ResultSet rs = null;
        
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select * from formaciones where ficha = '"+fic+"' " );
            
        } catch (SQLException ex) {
            Logger.getLogger(DFormaciones.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return  rs;
    }
    
    public static ResultSet buscarFormacion(){
        
        ResultSet rs = null;
        
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select * from formaciones" );
            
        } catch (SQLException ex) {
            Logger.getLogger(DFormaciones.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return  rs;
    }
}
