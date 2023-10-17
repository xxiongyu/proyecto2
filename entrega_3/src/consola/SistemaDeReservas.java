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

import modelo.Conductor;
import modelo.Documento;
import modelo.InfoReserva;
import modelo.Licencia;
import modelo.Seguro;

public class SistemaDeReservas {
	private int temporada= 2; 
	private String sedeEntrega="principal";
	private String sedeDevuelta="principal";
	private Boolean enCurso=true; 
	private Date fechaInicio = new Date();
	private String tiempoReserva="2 dias";
	private float precio30= 0.04f;
	private float precioServicioCompleto;
	private Licencia licencia;
	private Documento documento;
	private ArrayList<Conductor>  conductor=new ArrayList<Conductor>(); 
	private String medioDePago="tarjeta";
	private Seguro seguro = new Seguro("", "", fechaInicio, fechaInicio, ""); 
	
	private InfoReserva reservaEnCurso = new InfoReserva(tiempoReserva, precio30, conductor, medioDePago, seguro, sedeEntrega,fechaInicio);
	

//agregar cliente 
//agregar como parametro de entrada el atributo carroEnReserva
public void iniciarReserva(String tiempoReserva,float precio30,ArrayList<Conductor>  conductor,
		                   String medioDePago,Seguro seguro, String sedeEntrega) {
	reservaEnCurso= new InfoReserva(tiempoReserva,precio30, conductor,medioDePago, seguro,sedeEntrega,fechaInicio);
}
	
	 
public void crearReserva() throws IOException, FileNotFoundException{
    File archivo = new File("data/reservas.txt");
    boolean seCreo= false;
    if (!archivo.exists()) {
        archivo.createNewFile();
        seCreo=true;
    }
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
//			BufferedImage imagenDocumento = null;
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
	SistemaDeReservas sistemaDeReservas= new SistemaDeReservas();
	sistemaDeReservas.crearReserva();
	String hello = "°o°";
	System.out.println(hello);
	//Pedir numDocumento y pedir numLic
//	sistemaDeReservas.cargarImagen("lic","123");
}

//public void guardaReserva(archivo)throws IOException, FileNotFoundException{
//	
//}	 
	
}
