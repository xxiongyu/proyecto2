package modelo;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
public class Carro {

    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String transmision;
    private String estado;
    private String categoria;
    private String ubicacion;
    private boolean alquilado;
    private String disponibilidad;
    private BigDecimal precio;
    private static ArrayList<String> historialInformes = new ArrayList<>();

    // Constructor para inicializar todos los atributos
    public Carro(String placa, String marca, String modelo, String color, String transmision,
                 String estado, String categoria, String ubicacion, boolean alquilado,String disponibilidad,BigDecimal precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.transmision = transmision;
        this.estado = estado;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.alquilado=alquilado;
        this.disponibilidad=disponibilidad;
        this.precio=precio;
    }

    // Getters y Setters 
    public BigDecimal getPrecio() {
		return precio;
	}
    
    public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    // Getter para Estado
    public String getEstado() {
        return estado;
    }

    // Método para cambiar el estado (este método hace lo mismo que setEstado)
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

 
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

 
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public boolean getAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    

    public String generarTexto() {
    	String texto="";
    	texto+= getPlaca()+"p0";
    	texto+= getMarca()+"p0";
    	texto+= getModelo()+"p0";
    	texto+= getColor()+"p0";
    	texto+= getTransmision()+"p0";
    	texto+= getEstado()+"p0";
    	texto+= getCategoria()+"p0";
    	texto+= getUbicacion()+"p0";
    	texto+= getAlquilado()+"p0";
    	texto+= getDisponibilidad()+"p0";
    	texto+=getPrecio().toString();
    	return texto;
    }
    public String paCuando(String listopara) {
        if ("Disponible".equals(listopara) || "No Disponible".equals(listopara)) {
            return listopara;
        } else {
            return "a partir de " + listopara;
        }
    }
    public String informe() {
        String listopara=null;
		String informeActual = "Informe del Carro:" +
            "\nPlaca: " + placa +
            "\nMarca: " + marca +
            "\nModelo: " + modelo +
            "\nColor: " + color +
            "\nTransmisión: " + transmision +
            "\nEstado: " + estado +
            "\nCategoría: " + categoria +
            "\nUbicación : " + ubicacion+
            "\nEsta alquilado a:"+getAlquilado()+
            "\nEsta disponible:"+paCuando(listopara);

        historialInformes.add(informeActual);

        return informeActual;
    }

    public static void guardarHistorialEnArchivo(String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            for (String informe : historialInformes) {
                writer.write(informe);
                writer.newLine(); 
                writer.newLine(); // Dos líneas nuevas para separar cada informe
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

