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
import java.util.ArrayList;
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
	private ArrayList<String> idsReservasDelCliente;
	private ArrayList<Seguro>  Seguros; 
	private ArrayList<InfoReserva> reservas;
	private ArrayList<Carro> carros;
	private InfoReserva reserva; 

	
//public void iniciarReserva(String tiempoReserva,float precio30,ArrayList<Conductor>  conductor,
//		                   String medioDePago,Seguro seguro, String sedeEntrega) {
//	reservaEnCurso= new InfoReserva( tiempoReserva, precio30, conductor,
//            medioDePago, seguro,  sedeEntrega, fechaInicio, cliente, carroEnReserva);
//}

public ArrayList<Conductor> cargarConductores(String conductores) throws IOException{
	ArrayList<Conductor> finalArray= new ArrayList<Conductor>();
	String[] porConductor= conductores.split(",");
	for (int i = 0 ;i < porConductor.length;i++) {
		String[] partes= porConductor[i].split(":");
		String[] parteFecha = partes[2].split("\\.");
		finalArray.add(new Conductor(new Licencia(partes[0], partes[1], generarFecha(parteFecha), null)));
	}
	return finalArray;
}

public Date generarFecha(String[] partesFecha){
	int ano = Integer.parseInt(partesFecha[0]);
	int mes = Integer.parseInt(partesFecha[1]);
	int dia = Integer.parseInt(partesFecha[2]);
	int hora = Integer.parseInt(partesFecha[3]);
	int minuto = Integer.parseInt(partesFecha[4]);
	int segundo = Integer.parseInt(partesFecha[5]);
	Date fecha = new Date(ano, mes, dia, hora, minuto, segundo);
	return fecha;
}

public ArrayList<String> getIdsReservasDelCliente() {
	idsReservasDelCliente=new ArrayList<String>();
	System.out.println(idsReservasDelCliente.size());
	if(idsReservasDelCliente.size()==0) {
		idsReservasDelCliente.add("No tienes reservas");
	}
	return idsReservasDelCliente;
}

public Seguro cargarSeguro(String infSeguro) {
	String[] partes= infSeguro.split("'");
	Seguro seguro=new Seguro(partes[0], partes[1], generarFecha(partes[2].split("\\.")), generarFecha(partes[3].split("\\.")), partes[4]);
	return null;
}

public void cargarReservas() throws FileNotFoundException, IOException {
	FileReader fr = new FileReader("data/reservas.txt");
	reservas=new ArrayList<InfoReserva>();
	BufferedReader br = new BufferedReader(fr);
	String linea = br.readLine();
	while (linea != null) {
		//System.out.println(linea);
		String[] partes = linea.split("&");
		
		
		String id = partes[0];
		
		float precio30= Float.parseFloat(partes[1]);
		
		float precioServicioCompleto= Float.parseFloat(partes[2]);
		//System.out.println(partes[3]);
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
		
		if (partesCliente[0]==clienteLogeado) {
			System.out.println("si");
			clienteEnCurso=cliente;
			idsReservasDelCliente=ids;
			reservasDelCliente.add(reserva);
		}
		
		reservas.add(reserva);
		linea = br.readLine();
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

public void crearReserva() throws IOException, FileNotFoundException{
    File archivo = new File("data/reservas.txt");
    boolean seCreo= false;
    if (!archivo.exists()) {
        archivo.createNewFile();
        seCreo=true;
    }
    ArrayList<Conductor> list=new ArrayList<Conductor>(); 
    list.add(new Conductor(new Licencia("10777222","Colombia", new Date(), null)));
	ArrayList<String> idreservas = new ArrayList<String>();
	idreservas.add("01");
	idreservas.add("33");
    InfoReserva reservaEnCurso = new InfoReserva( "3",4.5f, 4.6f, 
    		new ArrayList<Conductor>(list),
    		"tarjeta",new Seguro("poliza", "todo", new Date(), new Date (), "compania"),
            "alta","¨Principal","secundaria", new Date(),new Date(),
            new Cliente("ja.fierro","3456","Jairo Fierro", "ja.fierro@uniandes.edu.co", "320555", idreservas),"XZY");
    reservaEnCurso.guardarReserva(archivo,seCreo);
	
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
	//SistemaDeReservas sistemaDeReservas= new SistemaDeReservas();
	//sistemaDeReservas.crearReserva();
//	String hello = "1";
	//sistemaDeReservas.cargarReservas();
	//sistemaDeReservas.enseñarReserva();
	//Pedir numDocumento y pedir numLic
//	sistemaDeReservas.cargarImagen("lic","123");
}
	
}
