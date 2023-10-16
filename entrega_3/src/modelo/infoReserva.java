package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

//import uniandes.dpoo.taller0.modelo.ProductoMenu;

public class infoReserva {
	
	private int id;
	private String tiempoReserva;
	//private Cliente cliente;
	//private Carro carroEnReserva;
	private float precio30;
	private float precioServicioCompleto;
	private ArrayList<Conductor>  conductor; 
	private String medioDePago;
	private Seguro seguro; 
	private int temporada; 
	private String sedeEntrega;
	private String sedeDevuelta;
	private Boolean enCurso; 
	private Date fechaInicio;
	
	
	
	//agregar cliente 
	//agregar como parametro de entrada el atributo carroEnReserva
	public infoReserva(String tiempoReservap,float precio30p,ArrayList<Conductor>  conductorp,
			           String medioDePagop,Seguro segurop, String sedeEntregap)
	
	{
		//cliente=clientep;
		//carroEnReserva=carroEnReservap;
		tiempoReserva= tiempoReservap;
		precio30= precio30p;
		conductor= conductorp;
		medioDePago=medioDePagop;
		seguro=segurop;
		sedeEntrega=sedeEntregap;
	}
	
	
//public int getCliente(){  
//	return cliente;
//}

//public int getCarroEnReserva(){ 
//	return carroEnReserva;
//}

//public int setCarroEnReserva(Carro nuevoCarro){  
//	return this.carroEnReserva = nuevoCarro;
//}
	
	
public int getId(){ 
	return id;
}
public void setId(int id) {
	this.id = id;
}
	
public String getTiempoReserva(){
	return tiempoReserva;
}
	
public void setTiempoReserva(String tiempoReserva) {
	this.tiempoReserva = tiempoReserva;
}

public float getPrecio30(){
	return precio30;
}

public void setPrecio30(float precio30) {
	this.precio30 = precio30;
}

public float getPrecioServicioCompleto() {
	return precioServicioCompleto;
}

public void setPrecioServicioCompleto(float precioServicioCompleto) {
	this.precioServicioCompleto = precioServicioCompleto;
}

public ArrayList<Conductor> getConductor() {
	return conductor;
} 

public void setConductor(ArrayList<Conductor> conductor) {
	this.conductor = conductor;
}

public String getMedioDePago() {
	return medioDePago;
}

public void setMedioDePago(String medioDePago) {
	this.medioDePago = medioDePago;
}

public Seguro getSeguro() {
	return seguro;
}

public void setSeguro(Seguro seguro) {
	this.seguro = seguro;
}

public int getTemporada() {
	return temporada;
}

public void setTemporada(int temporada) {
	this.temporada = temporada;
}

public String getSedeDevuelta() {
	return sedeDevuelta;
}

public void setSedeDevuelta(String sedeDevuelta) {
	this.sedeDevuelta = sedeDevuelta;
}

public String getSedeEntrega() {
	return sedeEntrega;
}

public void setSedeEntrega(String sedeEntrega) {
	this.sedeEntrega = sedeEntrega;
}

public Boolean getEnCurso() {
	return enCurso;
}

public void setEnCurso(Boolean enCurso) {
	this.enCurso = enCurso;
}

public void agregarConductor(Conductor conductorNuevo) {
	conductor.add(conductorNuevo);
}

public void compararFecha(Date fecha) {
	//private Date fecha = new Date();
	//inforeserva.compararFecha(fecha);
	if (fechaInicio.compareTo(fecha)== 0) {
		enCurso = true;
		//carroEnReserva.nuevoAlquiler();
	}
}


//public void cancelarReserva()
}