/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Datos.DReportes;
/**
 *
 * @author APRENDIZ
 */
public class LReportes {
    
    public static void buscarPersona(String doc){
    
        ResultSet rs = null;
        
        if (doc.equals(" ")){
        
            rs = DReportes.reporte();
        }
        else{
            rs = DReportes.reporteAsistencia(doc);
            
        }
        DefaultTableModel modelo = new DefaultTableModel();
       
        Vista.VReporteFecha.getTblReporte().setModel(modelo);
        
        modelo.addColumn("Documento");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Rol");
        modelo.addColumn("Ficha");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Estado");

        try {
            while(rs.next()){
                
                Object [] fila = new Object[8];
                
                fila[0]=(rs.getString(1));
                fila[1]=(rs.getString(2));
                fila[2]=(rs.getString(3));
                fila[3]=(rs.getString(4));
                fila[4]=(rs.getString(5));
                fila[5]=(rs.getString(6));
                fila[6]=(rs.getString(7));
                fila[7]=(rs.getString(8));

                modelo.addRow(fila);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void buscarFecha(String fecha_ingreso, String fecha_salida){
    
        ResultSet rs = null;
        
        if (fecha_ingreso.equals(" ") && fecha_salida.equals(" ")){

           rs = DReportes.reporte();
           
        }  else{
            rs = DReportes.reporteFecha(fecha_ingreso, fecha_salida);
        }

        DefaultTableModel modelo = new DefaultTableModel(); 
        Vista.VReporteFecha.getTblReporte().setModel(modelo);
            
        modelo.addColumn("Documento");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Rol");
        modelo.addColumn("Ficha");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Estado");

        try {
            while(rs.next()){
                    
                Object [] fila = new Object[8];
                    
                fila[0]=(rs.getString(1));
                fila[1]=(rs.getString(2));
                fila[2]=(rs.getString(3));
                fila[3]=(rs.getString(4));
                fila[4]=(rs.getString(5));
                fila[5]=(rs.getString(6));
                fila[6]=(rs.getString(7));
                fila[7]=(rs.getString(8));

                modelo.addRow(fila);
   
            }
        } catch (SQLException ex) {
            Logger.getLogger(LReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void buscarFecha1(String fecha_ingreso, String fecha_salida, String doc){
    
        ResultSet rs = null;
        
        if (fecha_ingreso.equals(" ") && fecha_salida.equals(" ") && doc.equals(" ")){

           rs = DReportes.reporte();
           
        }  else{
            rs = DReportes.reporteFechaDoc(fecha_ingreso, fecha_salida, doc);
        }

        DefaultTableModel modelo = new DefaultTableModel(); 
        Vista.VReporteFecha.getTblReporte().setModel(modelo);
            
        modelo.addColumn("Documento");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Rol");
        modelo.addColumn("Ficha");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Estado");

        try {
            while(rs.next()){
                    
                Object [] fila = new Object[8];
                    
                fila[0]=(rs.getString(1));
                fila[1]=(rs.getString(2));
                fila[2]=(rs.getString(3));
                fila[3]=(rs.getString(4));
                fila[4]=(rs.getString(5));
                fila[5]=(rs.getString(6));
                fila[6]=(rs.getString(7));
                fila[7]=(rs.getString(8));

                modelo.addRow(fila);
   
            }
        } catch (SQLException ex) {
            Logger.getLogger(LReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
