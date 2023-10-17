package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import modelo.Conductor;
//import uniandes.dpoo.taller0.modelo.ProductoMenu;

public class InfoReserva {
	
	private int id;
	private String tiempoReserva;
	private Cliente cliente;
	private Carro carroEnReserva;
	private float precio30;
	private float precioServicioCompleto;
	private ArrayList<Conductor>  conductor; 
	private String medioDePago;
	private Seguro seguro; 
	private String temporada; 
	private String sedeEntrega;
	private String sedeDevuelta;
	private Boolean enCurso; 
	private Date fechaInicio;
	
	
	//agregar cliente 
	//agregar como parametro de entrada el atributo carroEnReserva
	public InfoReserva(String tiempoReservap,float precio30p,ArrayList<Conductor>  conductorp,
			           String medioDePagop,Seguro segurop, String sedeEntregap,Date fechaIniciop,Cliente clientep,Carro carroEnReservap)
	
	{
		//cliente=clientep;
		//carroEnReserva=carroEnReservap;
		tiempoReserva= tiempoReservap;
		precio30= precio30p;
		conductor= conductorp;
		medioDePago=medioDePagop;
		seguro=segurop;
		sedeEntrega=sedeEntregap;
		fechaInicio=fechaIniciop;
		enCurso= false;
		cliente=clientep;
		carroEnReserva=carroEnReservap;
		
	}
	
	
public String getCliente(){  
	return cliente.getLogin();
}

public String getCarroEnReserva(){ 
	return carroEnReserva.getPlaca();
}


	
	
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

public String getTemporada() {
	return temporada;
}

public void setTemporada(String temporada) {
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

public Date getFechaInicio() {
	return fechaInicio;
}

public void setFechaInicio(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
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


public String generarTextoReserva() {
	String texto="";
	texto+= getId()+"+";
	texto+= getTiempoReserva()+"+";
	texto+=  getPrecio30()+"+";
	texto+= getPrecioServicioCompleto()+"+";
	for (int i = 0 ;i < conductor.size(); i++) {
		texto+=conductor.get(i).generarTexto()+ ",";
	}
	texto= texto.substring(0,texto.length()-1) ;
	texto+="+";
	texto+= getMedioDePago()+"+";
	texto+= seguro.generarTexto()+"+";
	texto+=getTemporada()+"+";
	texto+= getSedeEntrega()+"+";
	texto+= getSedeDevuelta()+"+";
	texto+= getFechaInicio()+"+";
	texto+= cliente.generarTexto()+"+";
	texto+= carroEnReserva.generarTexto();
	
	return texto;
}
    
public void guardarReserva(File archivo, boolean seCreo)throws IOException, FileNotFoundException{
	String texto = "";
	if (seCreo==false) {
		BufferedReader docReserva = new BufferedReader(new FileReader(archivo));
		String linea=docReserva.readLine();
		while (linea != null) {
			texto += linea + ";";
			linea = docReserva.readLine();
		}
		docReserva.close();
		texto += generarTextoReserva();
		String[] lineas = texto.split(";");
		BufferedWriter reservaDoc = new BufferedWriter(new FileWriter(archivo));
		for (int i = 0 ;i < lineas.length; i++) {
			reservaDoc.write(lineas[i]);
			reservaDoc.newLine();
		}
		reservaDoc.close();
	} else {
		BufferedWriter reservaDoc = new BufferedWriter(new FileWriter(archivo));
		texto += generarTextoReserva();
		reservaDoc.write(texto);
		reservaDoc.close();
	}
} 
    

    


//public void cancelarReserva()
}