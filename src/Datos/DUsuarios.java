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
public class DUsuarios {
    
    public static void registrarUsuarios (String doc, String nom, String ape, String cel, String email, String rol, String ficha){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("insert into usuarios values ('"+doc+"', '"+nom+"', '"+ape+"', '"+cel+"', '"+email+"', '"+rol+"', '"+ficha+"' )");
            JOptionPane.showMessageDialog(null, "Usuario Guardado");
            
        } catch (SQLException ex) {
            Logger.getLogger(DUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Guardadar El Usuario");
        }
    }
    
    public static void eliminarAprendicesFicha (String ficha){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from usuarios where ficha = '"+ficha+"' ");
            JOptionPane.showMessageDialog(null, "Usuarios Eliminado");
            
        } catch (SQLException ex) {
            Logger.getLogger(DUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Eliminar Los Usuarios");
        }
    }
    
    public static void eliminarAdministrativo (String doc){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from usuarios where documento = '"+doc+"' ");
            JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            
        } catch (SQLException ex) {
            Logger.getLogger(DUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Eliminar El Usuario");
        }
    }
    
    public static void modificarUsuario (String usu, String nom, String ape, String cel, String email, String rol, String ficha){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("update usuarios set documento = '"+usu+"', nombres ='"+nom+"', apellido='"+ape+"', celular='"+cel+"', correo_electronico='"+email+"', id_rol='"+rol+"', ficha='"+ficha+"' where documento = '"+usu+"' ");   
            JOptionPane.showMessageDialog(null, "Usuario Editado");
            
        } catch (SQLException ex) {
            Logger.getLogger(DUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Editar El Usuario");
        }
    }
    
    public static void buscarRol(){
    
       try {
            Statement st = Conexion.getConect().createStatement();
             ResultSet rs = st.executeQuery("select rol from rol ");
            
            while(rs.next()){
            
            Vista.VUsuario.getCbxRol().addItem(rs.getString("rol"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static ResultSet buscarUsuario(String doc){
        
        ResultSet rs = null;
        
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select * from usuarios where documento = '"+doc+"' " );
            
        } catch (SQLException ex) {
            Logger.getLogger(DUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return  rs;
    }
    
    public static ResultSet buscarUsuario(){
        
        ResultSet rs = null;
        
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select * from usuarios" );
            
        } catch (SQLException ex) {
            Logger.getLogger(DUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return  rs;
    }
}
