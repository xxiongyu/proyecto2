package modelo;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Documento {

    private int numero;
    private String pais;
    private String nacimiento;
    private BufferedImage imagen;

    // Constructor
    public Documento(int numero, String pais, String nacimiento, String pathImagen) throws IOException {
        this.numero = numero;
        this.pais = pais;
        this.nacimiento = nacimiento;
        this.imagen = ImageIO.read(new File(pathImagen));
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

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(String pathImagen) throws IOException {
        this.imagen = ImageIO.read(new File(pathImagen));
    }
}
