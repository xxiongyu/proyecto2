package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Seguro {
	private String cobertura; 
	private Date inicio;
	private Date vencimiento;
	private String compania;
	
public Seguro(String coberturap, Date iniciop, Date vencimientop, String companiap ) {
	cobertura=coberturap;
	inicio=iniciop;
	vencimiento= vencimientop;
	compania= companiap;
	
}	
	
public String getCobertura() {
	return cobertura;
}

public void setCobertura(String cobertura) {
	this.cobertura = cobertura;
}

public String getCompania() {
	return compania;
}

public void setCompania(String compania) {
	this.compania = compania;
}

public Date getInicio() {
	return inicio;
}

public void setInicio(Date inicio) {
	this.inicio = inicio;
}

//public String getPoliza() {
//	return poliza;
//}
//
//public void setPoliza(String poliza) {
//	this.poliza = poliza;
//}

public Date getVencimiento() {
	return vencimiento;
}

public void setVencimiento(Date vencimiento) {
	this.vencimiento = vencimiento;
}

public String generarTextoFechaInicio() {
	String texto = "";
	int anio=inicio.getYear()+1900;
	String.valueOf(anio);
	texto += anio + "." + inicio.getMonth() + "." + inicio.getDate() + "." + inicio.getHours() + "." + inicio.getMinutes();
	return texto;
}

public String generarTextoVencimiento() {
	String texto = "";
	int anio=vencimiento.getYear()+1900;
	String.valueOf(anio);
	texto += anio + "." + vencimiento.getMonth() + "." + vencimiento.getDate() + "." + vencimiento.getHours() + "." + vencimiento.getMinutes();
	return texto;
}


public String generarTexto() {
	String texto="";
//	texto+=getPoliza()+"'";
	texto+= getCobertura()+"'";
	texto+=generarTextoFechaInicio()+"'";
	texto+=generarTextoVencimiento()+"'";
	texto+= getCompania();
	return texto;
}

public void guardarSeguro(File archivoSeguro, boolean seCreo)throws IOException, FileNotFoundException {
	String texto = "";
	if (seCreo==false) {
		BufferedReader docSeguro = new BufferedReader(new FileReader(archivoSeguro));
		String linea=docSeguro.readLine();
		while (linea != null) {
			texto += linea + ";";
			linea = docSeguro.readLine();
		}
		docSeguro.close();
		texto += generarTexto();
		String[] lineas = texto.split(";");
		BufferedWriter seguroDoc = new BufferedWriter(new FileWriter(archivoSeguro));
		for (int i = 0 ;i < lineas.length; i++) {
			seguroDoc.write(lineas[i]);
			seguroDoc.newLine();
		}
		seguroDoc.close();
	}else {
		BufferedWriter seguroDoc = new BufferedWriter(new FileWriter(archivoSeguro));
		texto += generarTexto();
		seguroDoc.write(texto);
		seguroDoc.close();
	}
}


	
}
