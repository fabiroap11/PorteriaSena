/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Conexion;
import Datos.DFormaciones;
import Datos.DUsuarios;
import Vista.VFormaciones;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import static Vista.VFormaciones.TblFormaciones;
import static Vista.VFormaciones.TxtFicha;
import static Vista.VFormaciones.TxtForm;
import static Vista.VFormaciones.CbxHorario;

/**
 *
 * @author APRENDIZ
 */
public class LFormaciones {

    Integer ficha;
    String form;
    Integer hor;
    
    public  void registrarFormaciones (String archivoE ){
        
        int cont = 1;
        
        try {

            Workbook archivo = Workbook.getWorkbook(new File(archivoE));
            
            for (int hojas = 0; hojas < archivo.getNumberOfSheets(); hojas++) {
                Sheet hoja = archivo.getSheet(hojas);
                int numColum = hoja.getColumns();
                int numFilas = hoja.getRows();
                String dato;
                
                for (int fila = 1; fila < numFilas; fila++) {
                    for (int columna = 0; columna < numColum; columna++) {
                        
                        dato  = hoja.getCell(columna, fila).getContents();
                        System.out.println(dato +" ");
                
                       switch (columna){
                            case 0:
                                ficha = Integer.parseInt(dato);
                                cont++;
                                break;
                            case 1:
                                form = dato;
                                cont++;
                                break;
                            case 2:
                                hor = Integer.parseInt(dato);
                                cont++;
                                break;
                        }
                    }         
            try {
            Statement st = Conexion.getConect().createStatement();
            
            st.execute("insert into formaciones values ('"+ficha+"', '"+form+"', '"+hor+"')");
            JOptionPane.showMessageDialog(null, "Formaciones Guardadas");
            
        } catch (SQLException ex) {
            Logger.getLogger(DFormaciones.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo Guardar");
        }
                } 
            }
        } catch (Exception ioe) {
           ioe.printStackTrace();   
        } 
    }
    
    public static void buscarFormacion(String fic){
        
        ResultSet rs = null;
        
        if (fic.equals("")){
        rs = Datos.DFormaciones.buscarFormacion();
        }
        else{
        rs = Datos.DFormaciones.buscarFormacion(fic);
        }
        
         DefaultTableModel modelo = new DefaultTableModel();
         Vista.VFormaciones.getTblFormaciones().setModel(modelo);
         
         modelo.addColumn("Ficha");
         modelo.addColumn("Programa");
         modelo.addColumn("Horario");

         
        try {
            while(rs.next()){
                
                Object [] fila = new Object[3];
                
                fila[0]=(rs.getString(1));
                fila[1]=(rs.getString(2));
                fila[2]=(rs.getString(3));

                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LFormaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void llenarCapmos(){
        
        int fila = TblFormaciones.getSelectedRow();
  
        TxtFicha.setText((String)TblFormaciones.getValueAt(fila, 0));
        TxtForm.setText((String)TblFormaciones.getValueAt(fila, 1));
        int hor =Integer.parseInt(TblFormaciones.getValueAt(fila, 2).toString());
        CbxHorario.setSelectedIndex(hor);
       
    }
    
}
