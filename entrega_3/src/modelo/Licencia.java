package modelo;

import java.util.Date;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Licencia {

    private String numero;
    private String pais;
    private Date fechaVencimiento;
    private BufferedImage imagen;

    // Constructor
    public Licencia(String numero, String pais, Date fechaVencimiento, String pathImagen) throws IOException {
        this.numero = numero;
        this.pais = pais;
        this.fechaVencimiento = fechaVencimiento;
        //this.imagen = ImageIO.read(new File("D://Escritorio//banvelkozpls.png"));
    }

    // Getters y setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(String pathImagen) throws IOException {
        this.imagen = ImageIO.read(new File(pathImagen));
    }
    public String generarTexto() {
    	String texto="";
    	texto+= getNumero()+":";
    	texto+= getPais()+":";
    	texto+=generarTextoFecha(getFechaVencimiento());

    	return texto;

    }
    public String generarTextoFecha(Date fecha) {
    	String texto = "";
    	//int anio=fechaVencimiento.getYear()+1900;
    	texto += fechaVencimiento.getYear() + "." + fechaVencimiento.getMonth() + "." + fechaVencimiento.getDate() + "." + fechaVencimiento.getHours() + "." + fechaVencimiento.getMinutes() + "." + fechaVencimiento.getSeconds();
    	return texto;
    }
}
