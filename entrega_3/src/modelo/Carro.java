package partesProyecto1;

public class Carro {

    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String transmision;
    private String estado;
    private String categoria;
    private int ubicacion;
    private String alquilado;
    private String disponibilidad;

    // Constructor para inicializar todos los atributos
    public Carro(String placa, String marca, String modelo, String color, String transmision,
                 String estado, String categoria, int ubicacion, String Alquilado,String Disponibilidad) {
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
    }

    // Getters y Setters 
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

    // Getter y Setter para Estado
    public String getEstado() {
        return estado;
    }

    // Método para cambiar el estado (este método hace lo mismo que setEstado
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

 
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

 
    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getAlquilado() {
        return (alquilado != null && !alquilado.isEmpty()) ? alquilado : "No está alquilado";
    }

    public void setAlquilado(String alquilado) {
        this.alquilado = alquilado;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    public generarTexto() {
    	texto+= getPlaca()+":";
    	texto+= getMarca()+":";
    	texto+= getModelo()+":";
    	texto+= getColor()+":";
    	texto+= getTransmision()+":";
    	texto+= getEstado()+":";
    	texto+= getUbicacion()+":";
    	texto+= getCapacidad()+":";
    	texto+= getCategoria();
    	
    }
    public String paCuando(String listopara) {
        if ("Disponible".equals(listopara) || "No Disponible".equals(listopara)) {
            return listopara;
        } else {
            return "a partir de " + listopara;
        }
    }

    public String Informe() {
        return "Informe del Carro:" +
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
    }
}

