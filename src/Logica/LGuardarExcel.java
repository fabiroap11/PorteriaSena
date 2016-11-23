/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Vista.VReporteFecha;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import static Vista.VReporteFecha.TblReporte;

/**
 *
 * @author APRENDIZ
 */
public class LGuardarExcel {
    
    private File file;
    private List<JTable> tabla;
    private List<String> nom_files;

    public LGuardarExcel(File file, List<JTable> tabla, List<String> nom_files) throws Exception {
        this.file = file;
        this.tabla = tabla;
        this.nom_files = nom_files;
        
        if (nom_files.size()!=tabla.size()) {
            throw new Exception("Error");  
        }  
    }
    
    public boolean exportar(){
    
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            WritableWorkbook w = Workbook.createWorkbook(out);
            for (int index = 0; index <tabla.size(); index++) {
                JTable table = tabla.get(index);
                WritableSheet s=w.createSheet(nom_files.get(index), 0);
                for (int i = 0; i <table.getColumnCount(); i++) {
                    for (int j = 0; j <table.getRowCount(); j++) {
                        Object object = table.getValueAt(j, i);
                        s.addCell(new Label(i,j,String.valueOf(object)));
                    }
                } 
            }
            w.write();
            w.close();
            return true;
            
        } 
        catch (IOException | WriteException e) {
            return false;
        }
    
    }
    
    public static void guardarExcel(){
        
        if (VReporteFecha.getTblReporte().getRowCount() == 0){
            
            JOptionPane.showMessageDialog(null, "No hay datos para exportar","Porteria",JOptionPane.INFORMATION_MESSAGE);
            VReporteFecha.getjTextField1().grabFocus();
            return;
        }
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de EXEL", ".xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Gardar Archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
            List<JTable> tb = new ArrayList<>();
            List<String> nom = new ArrayList<>();
            tb.add(TblReporte);
            nom.add("usuarios");
            String file = chooser.getSelectedFile().toString().concat(".xls");
            try {
                Logica.LGuardarExcel e = new LGuardarExcel(new File(file),tb,nom);
                
                if (e.exportar()){
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a EXCEL","Porteria",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un ERROR " +e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }
    
}
