/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Vista.ManejadoraPantalla;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author APRENDIZ
 */
public class Porteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
   
            Datos.Conexion.conexion();
            
            
            
            File filename= new File("C:\\Users\\fabian\\Documents\\NetBeansProjects\\porteria\\formato.xlsx");
            
LListadoAsistencia.generarListadoAsistencia(filename);
    
     
     
       
    
    } 
}
