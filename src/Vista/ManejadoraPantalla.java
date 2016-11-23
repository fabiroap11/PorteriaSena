/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author APRENDIZ
 */
public class ManejadoraPantalla {
    
    private static VReporteFecha pantallaReporte;
    private static VGenerarReportes pantallaGenerarReportes;
    private static VReportePersona pantallaReorteFecha;
    private static VEnviar_correo pantallaCorreo;
    private static VUsuario pantallaUsuario;
    private static VFormaciones pantallaFormacion;
    private static VCopiaSeguridad pantallaBackup;
    
    public static void abrirReportePersona(){
    
        setPantallaReporte(new VReporteFecha());
        getPantallaReporte().setVisible(true);
        getPantallaReporte().setLocationRelativeTo(null);
    
    }
    
    public static void cerrarReportePersona(){
    
        getPantallaReporte().setVisible(false);
        setPantallaReporte(null);
    
    }
    
    public static void abrirGenerarReportes(){
    
        setPantallaGenerarReportes(new VGenerarReportes());
        getPantallaGenerarReportes().setVisible(true);
        getPantallaGenerarReportes().setLocationRelativeTo(null);
    }
    
    public static void cerrarGenerarReportes(){
    
        getPantallaGenerarReportes().setVisible(false);
        setPantallaGenerarReportes(null);
    }
    
    public static void abrirReporteFecha(){
    
        setPantallaReorteFecha(new VReportePersona());
        getPantallaReorteFecha().setVisible(true);
        getPantallaReorteFecha().setLocationRelativeTo(null);
    }
    
    public static void cerrarReporteFecha(){
    
        getPantallaReorteFecha().setVisible(false);
        setPantallaReorteFecha(null);
    }
    
    public static void abrirCorreo(){
    
        setPantallaCorreo(new VEnviar_correo());
        getPantallaCorreo().setVisible(true);
        getPantallaCorreo().setLocationRelativeTo(null);
    }
    
    public static void cerrarCorreo(){
    
        getPantallaCorreo().setVisible(false);
        setPantallaCorreo(null);
    }
    
    public static void abrirUsuario(){
    
        setPantallaUsuario(new VUsuario());
        getPantallaUsuario().setVisible(true);
        getPantallaUsuario().setLocationRelativeTo(null);
    }
    
    public static void cerrarUsuario(){
    
        getPantallaUsuario().setVisible(false);
        setPantallaUsuario(null);
    }
    
    public static void abrirFormacion(){
    
        setPantallaFormacion(new VFormaciones());
        getPantallaFormacion().setVisible(true);
        getPantallaFormacion().setLocationRelativeTo(null);
    }
    
    public static void cerrarFormacion(){
    
        getPantallaFormacion().setVisible(false);
        setPantallaFormacion(null);
    }
    
    public static void abrirBackup(){
    
        setPantallaBackup(new VCopiaSeguridad());
        getPantallaBackup() .setVisible(true);
        getPantallaBackup() .setLocationRelativeTo(null);
    }
    
    public static void cerrarBackup(){
    
        getPantallaBackup() .setVisible(false);
        setPantallaBackup(null);
    }

    /**
     * @return the pantallaReporte
     */
    public static VReporteFecha getPantallaReporte() {
        return pantallaReporte;
    }

    /**
     * @param aPantallaReporte the pantallaReporte to set
     */
    public static void setPantallaReporte(VReporteFecha aPantallaReporte) {
        pantallaReporte = aPantallaReporte;
    }

    /**
     * @return the pantallaGenerarReportes
     */
    public static VGenerarReportes getPantallaGenerarReportes() {
        return pantallaGenerarReportes;
    }

    /**
     * @param aPantallaGenerarReportes the pantallaGenerarReportes to set
     */
    public static void setPantallaGenerarReportes(VGenerarReportes aPantallaGenerarReportes) {
        pantallaGenerarReportes = aPantallaGenerarReportes;
    }

    /**
     * @return the pantallaReorteFecha
     */
    public static VReportePersona getPantallaReorteFecha() {
        return pantallaReorteFecha;
    }

    /**
     * @param aPantallaReorteFecha the pantallaReorteFecha to set
     */
    public static void setPantallaReorteFecha(VReportePersona aPantallaReorteFecha) {
        pantallaReorteFecha = aPantallaReorteFecha;
    }

    /**
     * @return the pantallaCorreo
     */
    public static VEnviar_correo getPantallaCorreo() {
        return pantallaCorreo;
    }

    /**
     * @param aPantallaCorreo the pantallaCorreo to set
     */
    public static void setPantallaCorreo(VEnviar_correo aPantallaCorreo) {
        pantallaCorreo = aPantallaCorreo;
    }

    /**
     * @return the pantallaUsuario
     */
    public static VUsuario getPantallaUsuario() {
        return pantallaUsuario;
    }

    /**
     * @param aPantallaUsuario the pantallaUsuario to set
     */
    public static void setPantallaUsuario(VUsuario aPantallaUsuario) {
        pantallaUsuario = aPantallaUsuario;
    }

    /**
     * @return the pantallaFormacion
     */
    public static VFormaciones getPantallaFormacion() {
        return pantallaFormacion;
    }

    /**
     * @param aPantallaFormacion the pantallaFormacion to set
     */
    public static void setPantallaFormacion(VFormaciones aPantallaFormacion) {
        pantallaFormacion = aPantallaFormacion;
    }

    /**
     * @return the pantallaBackup
     */
    public static VCopiaSeguridad getPantallaBackup() {
        return pantallaBackup;
    }

    /**
     * @param aPantallaBackup the pantallaBackup to set
     */
    public static void setPantallaBackup(VCopiaSeguridad aPantallaBackup) {
        pantallaBackup = aPantallaBackup;
    }
    
}
