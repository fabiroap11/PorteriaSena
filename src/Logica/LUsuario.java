/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import Datos.Conexion;
import Datos.DUsuarios;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import static Vista.VUsuario.TxtUsu;
import static Vista.VUsuario.TxtNombre;
import static Vista.VUsuario.TxtApellido;
import static Vista.VUsuario.TxtCelular;
import static Vista.VUsuario.TxtCorreo;
import static Vista.VUsuario.CbxRol;
import static Vista.VUsuario.TxtFormacion;
import static Vista.VUsuario.TblUsua;
import javax.swing.JOptionPane;


/**
 *
 * @author APRENDIZ
 */
public class LUsuario {
    
    String usu;
    String nom;
    String ape;
    String cel;
    String email;
    Integer rol;
    Integer ficha;

    
    public  void registrarUsuarios (String archivoE ){
        
        int cont = 1;
        
        try {

            Workbook archivo = Workbook.getWorkbook(new File(archivoE));
            
            for (int hojas = 0; hojas < archivo.getNumberOfSheets(); hojas++) {
                Sheet hoja = archivo.getSheet(hojas);
                int numColum = hoja.getColumns();
                int numFilas = hoja.getRows();
                String dato;
                
                for (int fila = 6; fila < numFilas; fila++) {
                    for (int columna = 1; columna < numColum; columna++) {
                        
                        dato  = hoja.getCell(columna, fila).getContents();
                        JOptionPane.showMessageDialog(null, "Usuarios Guardados");
                
                       switch (columna){
                            case 1:
                                usu = dato;
                                cont++;
                                break;
                            case 2:
                                nom = dato;
                                cont++;
                                break;
                            case 3:
                                ape = dato;
                                cont++;
                                break;
                            case 4:
                                cel = dato;
                                cont++;
                                break;
                            case 5:
                                email = dato;
                                cont++;
                                break;
                            case 6:
                                rol = Integer.parseInt(dato);
                                cont++;
                                break;
                            case 7:
                                ficha = Integer.parseInt(dato);
                                cont++;
                                break;
                        }
                    }
                   try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("insert into usuarios values ('"+usu+"', '"+nom+"', '"+ape+"', '"+cel+"', '"+email+"', '"+rol+"', '"+ficha+"' )");
            
        } catch (SQLException ex) {
            Logger.getLogger(DUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No Se Pudo Gardar Los Usuarios");
        }
                }  
            }
        } catch (Exception ioe) {
           ioe.printStackTrace();
            
        } 
    }
    
    public static void buscarFormacion(String doc){
        
        ResultSet rs = null;
        
        if (doc.equals("")){
        rs = Datos.DUsuarios.buscarUsuario();
        }
        else{
        rs = Datos.DUsuarios.buscarUsuario(doc);
        }
        
         DefaultTableModel modelo = new DefaultTableModel();
         Vista.VUsuario.getTblUsua().setModel(modelo);
         
         modelo.addColumn("Documento");
         modelo.addColumn("Nombres");
         modelo.addColumn("Apellidos");
         modelo.addColumn("Celular");
         modelo.addColumn("E-mail");
         modelo.addColumn("Rol");
         modelo.addColumn("Ficha");

         
        try {
            while(rs.next()){
                
                Object [] fila = new Object[7];
                
                fila[0]=(rs.getString(1));
                fila[1]=(rs.getString(2));
                fila[2]=(rs.getString(3));
                fila[3]=(rs.getString(4));
                fila[4]=(rs.getString(5));
                fila[5]=(rs.getString(6));
                fila[6]=(rs.getString(7));

                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void llenarCapmos(){
        
        int fila = TblUsua.getSelectedRow();
  
        TxtUsu.setText((String)TblUsua.getValueAt(fila, 0));
        TxtNombre.setText((String)TblUsua.getValueAt(fila, 1));
        TxtApellido.setText((String)TblUsua.getValueAt(fila, 2));
        TxtCelular.setText((String)TblUsua.getValueAt(fila, 3));
        TxtCorreo.setText((String)TblUsua.getValueAt(fila, 4));
        int rol =Integer.parseInt(TblUsua.getValueAt(fila, 5).toString());
        CbxRol.setSelectedIndex(rol);
        //int ficha =Integer.parseInt(TblUsua.getValueAt(fila, 6).toString());
        //CbxFicha.setSelectedIndex(ficha);
        TxtFormacion.setText((String)TblUsua.getValueAt(fila, 6));
       
    }
    
}
