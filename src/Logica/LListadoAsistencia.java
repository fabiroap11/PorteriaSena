/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
HOLA FABI ROA P 11

import Datos.Conexion;
import static Datos.DListadoAsistencia.consultarUsuaFicha;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author APRENDIZ
 */
public class LListadoAsistencia {
    
    public static void generarListadoAsistencia(File fileName) 
    {
        
     ArrayList<LAprendiz> aprendices= LAprendiz.crearListaAprendices("901620"); // listado de la ficha 
     int fila=12;
       
          try {
            InputStream inp = new FileInputStream(fileName);
 
            XSSFWorkbook wb =  new XSSFWorkbook(inp);
            XSSFSheet sheet = wb.getSheetAt(0);
            
              for (LAprendiz aprendiz : aprendices) { // recorremos lista de aprendices 
              
             fila++; // aumentamos la fila      
             
            XSSFRow rowDoc = sheet.getRow(fila);
            Cell cellDoc = rowDoc.getCell(1);
           cellDoc.setCellType(Cell.CELL_TYPE_BLANK);      //escribimos el documento 
           cellDoc.setCellValue(aprendiz.getDocumento());
           
           
            XSSFRow rowName = sheet.getRow(fila);
            Cell cellName = rowName.getCell(2);
           cellName.setCellType(Cell.CELL_TYPE_BLANK);      //escribimos  el nombre
           cellName.setCellValue(aprendiz.getNombres()+" "+aprendiz.getApellidos());
           
           
                                 
                                                     
          ArrayList<String> asistencias= aprendiz.getAsistencia(); // obtenemos el listado de asistencia para el aprendiz en curso
          int columna=12;
                  for (String asistencia : asistencias) {
            
             columna++;
            XSSFRow rowMarca = sheet.getRow(fila);
            Cell cellMarca = rowMarca.getCell(columna);
           cellMarca.setCellType(Cell.CELL_TYPE_BLANK);      //escribimos  las inasistencias
           cellMarca.setCellValue(asistencia);
           
                  }
           
              }          
            
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\fabian\\Documents\\NetBeansProjects\\porteria\\formato.xlsx");
            wb.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    
        
        
     
           }
    public static void buscarDocumento(String ficha){
        
        ResultSet rs = null;
        
        if (ficha.equals("")){
        rs = Datos.DListadoAsistencia.consultarUsuaFicha();
        }
        else{
        rs = Datos.DListadoAsistencia.consultarUsuaFicha(ficha);
        
        }
        
         DefaultTableModel modelo = new DefaultTableModel();
         Vista.VConsulta.getTblDocum().setModel(modelo);
         
         modelo.addColumn("Documento");

        try {
            while(rs.next()){
                
                Object [] fila = new Object[1];
                
                fila[0]=(rs.getString(1));

                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LListadoAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
