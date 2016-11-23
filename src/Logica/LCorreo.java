/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author CLAUDIA
 */
public class LCorreo {
    private String usuarioCorreo;
    private String contraseña;
    private String rutaArchivo;
    private String nombreArchivo;
    private String destino;
    private String asunto;
    private String mensaje;

    /**
     * @return the usuarioCorreo
     */
    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    /**
     * @param usuarioCorreo the usuarioCorreo to set
     */
    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the rutaArchivo
     */
    public String getRutaArchivo() {
        return rutaArchivo;
    }

    /**
     * @param rutaArchivo the rutaArchivo to set
     */
    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    void getContraseña(String cristiancamilo) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public boolean enviaCorreo(LCorreo c){
        try {
              Properties p= new Properties();
               p.put("mail.smtp.host","smtp.gmail.com");
               p.setProperty("mail.smtp.starttls.enable", "true");
               p.setProperty("mail.smtp.port", "587");
               p.setProperty("mail.smtp.user", c.getUsuarioCorreo());
               p.setProperty("mail.smtp.auth", "true");
                      
               
     Session s= Session.getDefaultInstance(p,null);
     BodyPart texto=new MimeBodyPart();
     texto.setText(c.getMensaje());
     BodyPart adjunto= new MimeBodyPart();
     
     
         if(!c.getRutaArchivo().equals(" ")){
             
             adjunto.setDataHandler(new DataHandler(new FileDataSource(c.getRutaArchivo())));
             adjunto.setFileName(c.getNombreArchivo());
         
         }
         
         MimeMultipart m= new MimeMultipart();
         m.addBodyPart(texto);
         
         if(!c.getRutaArchivo().equals(" ")){
             m.addBodyPart(adjunto);
         }
         
         MimeMessage mensaje=new MimeMessage(s);
         mensaje.setFrom(new InternetAddress(c.getUsuarioCorreo()));
         mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getDestino()));
         mensaje.setSubject(c.getAsunto());
         mensaje.setContent(m);
         
         Transport t=s.getTransport("smtp");
         t.connect(c.getUsuarioCorreo(),c.getContraseña());
         t.sendMessage(mensaje,mensaje.getAllRecipients());
         t.close();
         return true;  
         
      
        } catch (Exception e) {
            System.out.print("error" + e);
             return false;   
        }
    } 
 
}
