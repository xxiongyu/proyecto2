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
	
	private String id;
	private Cliente cliente;
	private String carroEnReserva;
	private double precio30;
	private double precioServicioCompleto;
	private ArrayList<Conductor>  conductor; 
	private String medioDePago;
	private Seguro seguro; 
	private String temporada; 
	private String sedeEntrega;
	private String sedeDevuelta;
	private Boolean enCurso; 
	private Date fechaInicio;
	private Date fechaEntrega;
	
	public InfoReserva(String idp,double precio30p,double precioServicioCompletop,ArrayList<Conductor> coductorp,String medioDePagop,Seguro segurop, 
			String Temporadap,String sedeEntregap,String sedeDeVueltap, Date fechaIniciop,Date fechaEntregap,Cliente clientep,String carroEnReservap)
	
	{
		id=idp;
		cliente=clientep;
		carroEnReserva=carroEnReservap;
		cliente=clientep;
		carroEnReserva=carroEnReservap;
		precio30= precio30p;
		precioServicioCompleto=precioServicioCompletop;
		conductor= coductorp;
		medioDePago=medioDePagop;
		seguro=segurop;
		temporada=Temporadap;
		sedeEntrega=sedeEntregap;
		sedeDevuelta=sedeDeVueltap;
		enCurso= false;
		fechaInicio=fechaIniciop;
		fechaEntrega=fechaEntregap;
		
	}
		
public String getNameCliente(){  
	return cliente.getNombre();
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}



public String getCarroEnReserva(){ 
	return carroEnReserva;
}

public void setCarroEnReserva(String carroEnReserva){ 
	this.carroEnReserva=carroEnReserva;
}
	

public String getId(){ 
	return id;
}
public void setId(String id) {
	this.id = id;
}
	

//public Date getTiempoReserva(){
//	return tiempoReserva;
//}
//	
//public void setTiempoReserva(Date fechaInicio,) {
//	
//	this.tiempoReserva = tiempoReserva;
//}


public double getPrecio30(){
	return precio30;
}

public void setPrecio30(float precio30) {
	this.precio30 = precio30;
}


public double getPrecioServicioCompleto() {
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

public void setEnCurso() {
	this.enCurso = true;
}


public Date getFechaInicio() {
	return fechaInicio;
}

public void setFechaInicio(String fechaInicio) {
	String[] partes= fechaInicio.split("\\.");
	this.fechaInicio = new Date(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]),
			Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]));
}
public void setFechaEntrega(String fechaEntrega) {
	String[] partes= fechaEntrega.split("\\.");
	this.fechaEntrega = new Date(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]),
			Integer.parseInt(partes[2]),Integer.parseInt(partes[3]),Integer.parseInt(partes[4]));
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
	texto+= getId()+"&";
	//texto+= getTiempoReserva()+"+";
	texto+=  getPrecio30()+"&";
	texto+= getPrecioServicioCompleto()+"&";
	for (int i = 0 ;i < conductor.size(); i++) {
		texto+=conductor.get(i).generarTexto()+ ",";//4
	}
	texto= texto.substring(0,texto.length()-1) ;//5
	texto+="&";
	texto+= getMedioDePago()+"&";//4
	texto+= seguro.generarTexto()+"&";//5
	texto+=getTemporada()+"&";//6
	texto+= getSedeEntrega()+"&";//7
	texto+= getSedeDevuelta()+"&";//8
	texto+= generarTextoFechaI()+"&";//9
	texto+=generarTextoFechaE()+"&";//10
	texto+= cliente.generarTexto()+"&";//11
	texto+= getCarroEnReserva();//12
	return texto;
}
public String generarTextoFechaI() {
	String texto = "";
	int anio=fechaInicio.getYear()+1900;
	int mes=fechaInicio.getMonth()+1;
	String.valueOf(anio);
	String.valueOf(mes);
	texto += anio + "." + mes + "." + fechaInicio.getDate() + "." + fechaInicio.getHours() + "." + fechaInicio.getMinutes();
	return texto;
}

public String generarTextoFechaE() {
	String texto = "";
	int anio=fechaEntrega.getYear()+1900;
	int mes=fechaEntrega.getMonth()+1;
	String.valueOf(anio);
	String.valueOf(mes);
	texto += anio + "." + mes + "." + fechaEntrega.getDate() + "." + fechaEntrega.getHours() + "." + fechaEntrega.getMinutes() + "." + fechaEntrega.getSeconds();
	return texto;
}
public String generarFechaAenseñarI() {
	String texto = "";
//	int anio=fechaInicio.getYear()-1900;
//	String.valueOf(anio);
	texto += fechaInicio.getYear() + "." + fechaInicio.getMonth() + "." + fechaInicio.getDate() + "." + fechaInicio.getHours() + "." + fechaInicio.getMinutes();
	return texto;
}

public String generarFechaAenseñarE() {
	String texto = "";
//	int anio=fechaEntrega.getYear()-1900;
//	String.valueOf(anio);
	texto += fechaEntrega.getYear() + "." + fechaEntrega.getMonth() + "." + fechaEntrega.getDate() + "." + fechaEntrega.getHours() + "." + fechaEntrega.getMinutes();

	return texto;
}


public void guardarReserva(File archivo, boolean seCreo)throws IOException, FileNotFoundException{
	String texto = "";
	if (seCreo==false) {
		System.out.println("entró false");
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
		System.out.println("entró true");
		BufferedWriter reservaDoc = new BufferedWriter(new FileWriter(archivo));
		texto += generarTextoReserva();
		reservaDoc.write(texto);
		reservaDoc.close();
	}
}


//public ArrayList<Conductor> cargarConductores(String conductores) throws IOException{
//	ArrayList<Conductor> finalArray= new ArrayList<Conductor>();
//	String[] porConductor= conductores.split(",");
//	for (int i = 0 ;i < porConductor.length;) {
//		String[] partes= porConductor[i].split(":");
//		String[] parteFecha = partes[2].split(".");
//		finalArray.add(new Conductor(new Licencia(Integer.parseInt(partes[0]), partes[1], generarFecha(parteFecha), null)));
//	}
//	return finalArray;
//}

    


//public void cancelarReserva()
}