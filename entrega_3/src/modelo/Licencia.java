package partesProyecto1;

import java.util.Date;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Licencia {

    private int numero;
    private String pais;
    private Date fechaVencimiento;
    private BufferedImage imagen;

    // Constructor
    public Licencia(int numero, String pais, Date fechaVencimiento, String pathImagen) throws IOException {
        this.numero = numero;
        this.pais = pais;
        this.fechaVencimiento = fechaVencimiento;
        this.imagen = ImageIO.read(new File("D://Escritorio//banvelkozpls.png"));
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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
}
