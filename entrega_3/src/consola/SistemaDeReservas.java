package consola;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import modelo.Carro;

import modelo.Cliente;
import modelo.Conductor;
import modelo.Carro;
import modelo.Documento;
import modelo.InfoReserva;
import modelo.Licencia;
import modelo.Seguro;

public class SistemaDeReservas {
	private String clienteLogeado;
	private Cliente clienteEnCurso;
	private ArrayList<InfoReserva> reservasDelCliente;
	private ArrayList<String> idsReservasDelCliente=new ArrayList<String>();
	private ArrayList<Seguro>  seguros; 
	private ArrayList<InfoReserva> reservas;
	private ArrayList<Carro> carros;
	private ArrayList<Carro> carrosDisponibles;
	private InfoReserva reserva; 
	private InfoReserva reservaEnCurso2;
	private double tarifaPorDia=50000.0; 
	private double tarifaPorHora=10000.0;


	
//public void iniciarReserva(String tiempoReserva,float precio30,ArrayList<Conductor>  conductor,
//		                   String medioDePago,Seguro seguro, String sedeEntrega) {
//	reservaEnCurso= new InfoReserva( tiempoReserva, precio30, conductor,
//            medioDePago, seguro,  sedeEntrega, fechaInicio, cliente, carroEnReserva);
//}

	
	
public double calcularCostoReserva(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        long diasDiferencia = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        long horasDiferencia = ChronoUnit.HOURS.between(fechaInicio, fechaFin);

        if (diasDiferencia >= 1) {
            return diasDiferencia * tarifaPorDia;
        } else {
            return horasDiferencia * tarifaPorHora;
        }
    }	

public String identificarTemporada() {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(new Date());

	        int mes = cal.get(Calendar.MONTH) + 1; 
	        if (mes >= 1 && mes <= 4) {
	            return "Baja";
	        } else if (mes >= 5 && mes <= 8) {
	            return "Alta";
	        } else  {
	            return "media";
	        } 
	}
	
public Carro encontrarCarro(String placa) {
	for(int i=0;i<carrosDisponibles.size();i++){
		if(carrosDisponibles.get(i).getPlaca().equals(placa) ) {
			return carrosDisponibles.get(i);
		}
	}
	return null;
}

public Cliente getClienteEnCurso() {
	return clienteEnCurso;
}
public String generarId(){
	return Integer.toString(reservas.size()+1);
}

public ArrayList<Conductor> cargarConductores(String conductores) throws IOException{
	ArrayList<Conductor> finalArray= new ArrayList<Conductor>();
	String[] porConductor= conductores.split(",");
	for (int i = 0 ;i < porConductor.length;i++) {
		String[] partes= porConductor[i].split(":");
		String[] parteFecha = partes[2].split("\\.");
		finalArray.add(new Conductor(new Licencia(partes[0], partes[1], generarFecha(parteFecha))));
	}
	return finalArray;
}

public ArrayList<Carro> totalCarros(){
	return carros;
}

public  ArrayList<Carro> carrosDisponibles(){
	return carrosDisponibles;
}

public Date generarFecha(String[] partesFecha){
	int ano = Integer.parseInt(partesFecha[0]);
	int mes = Integer.parseInt(partesFecha[1]);
	int dia = Integer.parseInt(partesFecha[2]);
	int hora = Integer.parseInt(partesFecha[3]);
	int minuto = Integer.parseInt(partesFecha[4]);;
	Date fecha = new Date(ano, mes, dia,hora,minuto);
	return fecha;
}

public ArrayList<Seguro> getSeguros() {
	return seguros;
}

public void actualizarReservas(InfoReserva nuevaReserva) {
	int p=0;
	for(int i=0;i<reservas.size();i++){
		System.out.println(reservas.size());
		if(reservas.get(i)==nuevaReserva ) {
			p= i;
		}
	}
	reservas.set(p, nuevaReserva);
}

public ArrayList<String> getIdsReservasDelCliente() {
	System.out.println("ids"+idsReservasDelCliente.size());
	
	if(idsReservasDelCliente==null) {
		idsReservasDelCliente.add("No tienes reservas");
	}
	return idsReservasDelCliente;
}

public InfoReserva encontrarReservaDelCliente(String id) {
	InfoReserva reserva=null;
	for(int i=0;i<reservasDelCliente.size();i++){
		System.out.println(reservasDelCliente.size());
		if(reservasDelCliente.get(i).getId().equals(id)) {
			reserva= reservasDelCliente.get(i);
		}
	}
	return reserva;
}

public void eliminarDocReser() {
    File archivo = new File("data/reservas.txt"); 
    archivo.delete();
}
public void salavarReservas() throws IOException, FileNotFoundException {
	File archivo = new File("data/reservas.txt");
    boolean seCreo= false;
    archivo.createNewFile();

	for(int i=0;i<reservas.size();i++){
		System.out.println(i+"p reserva");
		if (i!=0) {
			seCreo=true;
		}
		reservas.get(i).guardarReserva(archivo,seCreo);
	}
}

public Seguro encontrarSeguroDelCliente(String cobertura) {
	Seguro nuevoSeguro=null;
	for(int i=0;i<seguros.size();i++) {
		if(seguros.get(i).getCobertura().equals(cobertura)) {
			nuevoSeguro= seguros.get(i);
	     }
	}
	return nuevoSeguro;
}



public Seguro cargarSeguro(String infSeguro) {
	String[] partes= infSeguro.split("'");
	Seguro seguro=new Seguro(partes[0], partes[1], partes[2], partes[3]);
	return seguro;
}

public void cargarReservas() throws FileNotFoundException, IOException {
	FileReader fr = new FileReader("data/reservas.txt");
	reservas=new ArrayList<InfoReserva>();
	BufferedReader br = new BufferedReader(fr);
	String linea = br.readLine();
	boolean seCreo=false;
	while (linea != null) {
		//System.out.println(linea);
		String[] partes = linea.split("&");
//		for(int i=0;i<partes.length;i++) {
//		        System.out.println(i+ partes[i]);
//		}
		
		String id = partes[0];
		
		float precio30= Float.parseFloat(partes[1]);
		
		float precioServicioCompleto= Float.parseFloat(partes[2]);
		
		ArrayList<Conductor> coductor = cargarConductores(partes[3]);
		
		
		String medioDePago =partes[4];
		
		Seguro seguro= cargarSeguro(partes[5]);
		
		String Temporada=partes[6];
		
		String sedeEntrega=partes[7];
		
		String sedeDeVuelta=partes[8];
		
		Date fechaInicio= generarFecha(partes[9].split("\\."));
		
		Date fechaEntrega= generarFecha(partes[10].split("\\."));
		
		String[] partesCliente = partes[11].split(">");
		String[] idReservas=partesCliente[5].split("<");
		ArrayList<String> ids=new ArrayList<String>(); 
		for (int i = 0 ;i < idReservas.length;i++) {
			ids.add(idReservas[i]);
		}
		
		
		Cliente cliente = new Cliente(partesCliente[0], partesCliente[1], partesCliente[2],partesCliente[3],partesCliente[4], ids);
		
		String carro = partes[12];

		InfoReserva reserva = new InfoReserva(id,precio30, precioServicioCompleto, coductor,medioDePago,seguro, Temporada,sedeEntrega,sedeDeVuelta, fechaInicio,fechaEntrega,cliente,carro);

		if (partesCliente[0].equals(clienteLogeado)) {
			clienteEnCurso=cliente;
			idsReservasDelCliente.add(id);
//			this.idsReservasDelCliente= new ArrayList<String>();
//			this.idsReservasDelCliente.add(id);
			if(seCreo== false) {
				this.reservasDelCliente= new ArrayList<InfoReserva>();
				seCreo=true;
			}
			this.reservasDelCliente.add(reserva);
		}
		
		reservas.add(reserva);
		linea = br.readLine();
	}
}

public void cargarSeguros() throws FileNotFoundException, IOException {
	FileReader fr = new FileReader("data/Seguros.txt");
	ArrayList<Seguro> listaSeguro=new ArrayList<Seguro>();
	BufferedReader br = new BufferedReader(fr);
	String linea = br.readLine();
	while (linea != null) {
		String[] partes = linea.split("'");
		System.out.println(linea);
		Seguro seguro=new Seguro(partes[0],partes[1],partes[2], partes[3]);
		listaSeguro.add(seguro);
		linea = br.readLine();
	}
	seguros=listaSeguro;	
	br.close();
}

public void cargarCarros() throws FileNotFoundException, IOException {
	FileReader fr = new FileReader("data/Carros.txt");
	ArrayList<Carro> listaCarros=new ArrayList<Carro>();
	ArrayList<Carro> listaCarrosDisponibles=new ArrayList<Carro>();
	BufferedReader br = new BufferedReader(fr);
	String linea = br.readLine();
	while (linea != null) {
		String[] partes = linea.split("p0");
		for(int i=0;i<partes.length;i++) {
			System.out.println(partes[i]);
		}
			
		Carro carro=new Carro(partes[0],partes[1],partes[2], partes[3],partes[4],
				partes[5],partes[6], partes[7],Boolean.parseBoolean(partes[8]),Float.parseFloat(partes[9]));
		if(Boolean.parseBoolean(partes[8])==true) {
			listaCarrosDisponibles.add(carro);
		}
		listaCarros.add(carro);
		linea = br.readLine();
		
	}
	carros=listaCarros;	
	carrosDisponibles=listaCarrosDisponibles;
	for(int i=0;i<carrosDisponibles.size();i++){
		System.out.println(carrosDisponibles.get(i));
	} 
	br.close();
}

public void setClienteLogeado(String clienteLogeado){
	this.clienteLogeado=clienteLogeado;
	
}

public void enseñarReserva() {
	for(int i = 0 ;i < reservas.size();i++) {
		System.out.println(reservas.get(i).generarTextoFechaE());
		
	}
}

public void enseñarSeguros() {
	for(int i = 0 ;i < seguros.size();i++) {
		System.out.println(seguros.get(i).getCobertura());
	}
}

public void crearReserva(InfoReserva reservaNueva) throws IOException, FileNotFoundException{
    File archivo = new File("data/reservas.txt");
    boolean seCreo= false;
    if (!archivo.exists()) {
        archivo.createNewFile();
        seCreo=true;
    }
//    ArrayList<Conductor> list=new ArrayList<Conductor>(); 
//    list.add(new Conductor(new Licencia("10777222","Colombia", new Date())));
//	ArrayList<String> idreservas = new ArrayList<String>();
//	idreservas.add("7");
////	idreservas.add("8");
//    InfoReserva reservaEnCurso = new InfoReserva( "8",10000.0, 400000.0, 
//    		new ArrayList<Conductor>(list),
//    		"tarjeta",new Seguro("todo", new Date(), new Date (), "compania"),
//            "alta","¨Principal","chapinero", new Date(),new Date(),
//            new Cliente("g.chaparr","3456","Juan Vasquez", "j.vasquez@uniandes.edu.co", "320555", idreservas),"XZY-666");
    
    reservaNueva.guardarReserva(archivo,seCreo);
	
}

public void crearSeguro( Seguro nuevoSeguro)throws IOException, FileNotFoundException{
	File archivoSeguro = new File("data/Seguros.txt");
    boolean seCreo= false;
    if (!archivoSeguro.exists()) {
    	archivoSeguro.createNewFile();
    	seCreo=true;
    }
    nuevoSeguro.guardarSeguro(archivoSeguro,seCreo);
    
}

public void agregarCarro( Carro nuevoCarro)throws IOException, FileNotFoundException{
	File archivoCarro = new File("data/Carros.txt");
    boolean seCreo= false;
    if (!archivoCarro.exists()) {
    	archivoCarro.createNewFile();
    	seCreo=true;
    }
    nuevoCarro.guardarCarro(archivoCarro,seCreo);
    
}





//public void cargarLicencia() {
//	String ruta = input("Ingrese la ruta de la imagen(ej->C:\\Users\\arfie\\Downloads\\licencia.jpeg)");
//	try {
//		BufferedImage imagenLicencia = null;
//		imagenLicencia = ImageIO.read(new File(ruta));
//		System.out.println("Se ha leido");
//		licencia = new Licencia(123, "Col", fechaInicio, imagenLicencia);
//		ImageIO.write(imagenLicencia, "png", new File("data/licencia.png"));
//		System.out.println("Se creo la licencia");
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}
//
//public void cargarImagen(String tipoDoc,String numDoc) {
//	String ruta = input("Ingrese la ruta de la imagen(ej->C:\\Users\\arfie\\Downloads\\licencia.jpeg)");
//	try {
//		if (tipoDoc == "documento") {
//			BufferedImage imagenDocumento = null;+
//			imagenDocumento = ImageIO.read(new File(ruta));
//			System.out.println("Se ha leido");
//			documento= new Documento(imagenDocumento,numDoc);
//			ImageIO.write(imagenDocumento, "png", new File("data/Documento"+numDoc+".png"));
//		}else { 
//			BufferedImage imagenLicencia = null;
//			imagenLicencia = ImageIO.read(new File(ruta));
//			System.out.println("Se ha leido");
//			licencia = new Licencia(123, "Col", fechaInicio, imagenLicencia);
//			ImageIO.write(imagenLicencia, "png", new File("data/licencia"+numDoc+".png"));
//			System.out.println("Se creo la licencia");
//		}
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//}

public void asignarReserva(){
	for(int i=0;i<reservas.size();i++) {
		
	}
}

public String input(String mensaje)
{
	try
	{
		System.out.print(mensaje + ": ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}
	catch (IOException e)
	{
		System.out.println("Error leyendo de la consola");
		e.printStackTrace();
	}
	return null;
}

public static void main(String[] args) throws FileNotFoundException, IOException {  
//	Interfazlog log= new Interfazlog();
//	log.setLocationRelativeTo(null);
//	log.setVisible(true);	
	SistemaDeReservas sistemaDeReservas= new SistemaDeReservas();
//	sistemaDeReservas.crearReserva();
//	sistemaDeReservas.crearSeguro();
//	String hello = "1";
//	sistemaDeReservas.cargarSeguros();
	sistemaDeReservas.cargarCarros();
//	Carro carro= new Carro(null, null, null, null, null, null, null, null, false, null, null)
//	sistemaDeReservas.agregarCarro();
	//sistemaDeReservas.enseñarSeguros();
	//sistemaDeReservas.cargarReservas();
	//sistemaDeReservas.enseñarReserva();
	//Pedir numDocumento y pedir numLic
//	sistemaDeReservas.cargarImagen("lic","123");
}
	
}
