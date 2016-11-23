/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author APRENDIZ
 */
public class DReportes {
    
    public static ResultSet reporteAsistencia(String doc){
        
        ResultSet rs = null;
    
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select  usuarios.documento, usuarios.nombres, usuarios.apellido, rol.rol, usuarios.ficha, ingreso_salida_usu.fecha_ingreso, ingreso_salida_usu.hora_ingreso, ingreso_salida_usu.estado from usuarios inner join ingreso_salida_usu on usuarios.documento=ingreso_salida_usu.documento inner join rol on rol.id_rol=usuarios.id_rol WHERE usuarios.documento='"+doc+"' ");

        } catch (SQLException ex) {
            Logger.getLogger(DReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    
    
    public static ResultSet reporteFechaDoc(String fecha_ingreso, String fecha_salida, String doc){
        
        ResultSet rs = null;
    
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select  usuarios.documento, usuarios.nombres, usuarios.apellido, rol.rol, usuarios.ficha, ingreso_salida_usu.fecha_ingreso, ingreso_salida_usu.hora_ingreso, ingreso_salida_usu.estado from usuarios inner join ingreso_salida_usu on usuarios.documento=ingreso_salida_usu.documento inner join rol on rol.id_rol=usuarios.id_rol WHERE ingreso_salida_usu.fecha_ingreso between '"+fecha_ingreso+"' and '"+fecha_salida+"' and usuarios.documento = '"+doc+"'");

            
        } catch (SQLException ex) {
            Logger.getLogger(DReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public static ResultSet reporte(){
        
        ResultSet rs = null;
    
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select  usuarios.documento, usuarios.nombres, usuarios.apellido, rol.rol, usuarios.ficha, ingreso_salida_usu.fecha_ingreso, ingreso_salida_usu.hora_ingreso, ingreso_salida_usu.estado from usuarios inner join ingreso_salida_usu on usuarios.documento=ingreso_salida_usu.documento inner join rol on rol.id_rol=usuarios.id_rol");

            
        } catch (SQLException ex) {
            Logger.getLogger(DReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    
    
    public static ResultSet reporteFecha(String fecha_ingreso, String fecha_salida){
        
        ResultSet rs = null;
    
        try {
            Statement st = Conexion.getConect().createStatement();
            rs = st.executeQuery("select  usuarios.documento, usuarios.nombres, usuarios.apellido, rol.rol, usuarios.ficha, ingreso_salida_usu.fecha_ingreso, ingreso_salida_usu.hora_ingreso, ingreso_salida_usu.estado from usuarios inner join ingreso_salida_usu on usuarios.documento=ingreso_salida_usu.documento inner join rol on rol.id_rol=usuarios.id_rol WHERE ingreso_salida_usu.fecha_ingreso between '"+fecha_ingreso+"' and '"+fecha_salida+"' ");

            
        } catch (SQLException ex) {
            Logger.getLogger(DReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
}
