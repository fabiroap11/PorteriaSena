/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Conexion;
import static Datos.DListadoAsistencia.consultarUsuaFicha;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CLAUDIA
 */
public class LAprendiz {
    
    
    private String documento;
    private String nombres;
    private String apellidos;
    private ArrayList<String> asistencia;
    
    
    public LAprendiz(String doc, String nom, String ape){
    this.documento= doc;
    this.nombres=nom;
    this.apellidos=ape;
    this.asistencia = llenarArregloAsistencia(doc);
    }

    
    public static ArrayList  llenarArregloAsistencia(String doc){
    ArrayList asistenciaA=null;
      Date fecha = new Date();
      Calendar cal1 = Calendar.getInstance();
      int dia = cal1.get(Calendar.DAY_OF_MONTH);
            
      
       for (int i = 1; i <= dia ; i++) {
           
           
        try {
            Statement st = Conexion.getConect().createStatement();
            ResultSet  rs = st.executeQuery("select c1.suma_e,c2.suma_s, SEC_TO_TIME(TIMESTAMPDIFF(SECOND,c1.suma_e,c2.suma_s)) AS TIEMPO_ADENTRO from (select  sec_to_time(sum(time_to_sec(hora_ingreso))) as suma_e from ingreso_salida_usu where estado='adentro' and fecha_ingreso='2016/11/10' and documento='"+doc+"')  AS c1, (select sec_to_time(sum(time_to_sec(hora_ingreso))) as suma_s From ingreso_salida_usu where estado='afuera' and fecha_ingreso='2016/11/10' and documento='"+doc+"' )as c2 ");
       
        
            if (rs.getRow()==0){
        
                
          while(rs.next()){
                           
                            
                            String tiempoAdentro=(rs.getString("TIEMPO_ADENTRO"));
                            System.out.println("tiempo "+tiempoAdentro);
                            String [] ta= tiempoAdentro.split(":");
                            int tiempoAdentInt= Integer.parseInt(ta[0]);
                            System.out.println("horas  "+ta[0]); 
                            
                            
                            if(tiempoAdentInt>=03){
                                
                                asistenciaA.add(i,"a");
                 
                            }
                            else{
                                
                             
                                 asistenciaA.add(i,"x");
                                
                            }
                            
                                                       
                        }
            }else{
            
             asistenciaA.add(i, "x");
            }
            
            
            
        
        
        } catch (SQLException ex) {
            Logger.getLogger(LAprendiz.class.getName()).log(Level.SEVERE, null, ex);
        }
                      
           
           
           
           
           
    
       }
    
    
    
    
    
    return asistenciaA;
    }
    
    
    
    
    
    
    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public  static ArrayList<LAprendiz> crearListaAprendices(String idFicha){
          ArrayList<LAprendiz> aprendices = new ArrayList<>();
            ResultSet rs11= consultarUsuaFicha(idFicha);
            
        try {
            while(rs11.next()){
                LAprendiz aprendiz= new LAprendiz(rs11.getString("documento"), rs11.getString("nombres"), rs11.getString("apellido"));
               
                aprendices.add(aprendiz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LListadoAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aprendices;
    }

    /**
     * @return the asistencia
     */
    public ArrayList<String> getAsistencia() {
        return asistencia;
    }

    /**
     * @param asistencia the asistencia to set
     */
    public void setAsistencia(ArrayList<String> asistencia) {
        this.asistencia = asistencia;
    }
    
}
