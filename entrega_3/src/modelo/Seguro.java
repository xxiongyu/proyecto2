package modelo;

import java.util.Date;

public class Seguro {
	private String poliza;
	private String cobertura; 
	private Date inicio;
	private Date vencimiento;
	private String compania;
	
public Seguro(String polizap, String coberturap, Date iniciop, Date vencimientop, String companiap ) {
	poliza= polizap;
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

public String getPoliza() {
	return poliza;
}

public void setPoliza(String poliza) {
	this.poliza = poliza;
}

public Date getVencimiento() {
	return vencimiento;
}

public void setVencimiento(Date vencimiento) {
	this.vencimiento = vencimiento;
}

public String generarTextoFechaInicio() {
	String texto = "";
//	int anio=inicio.getYear()+1900;
	texto += inicio.getYear() + "." + inicio.getMonth() + "." + inicio.getDate() + "." + inicio.getHours() + "." + inicio.getMinutes() + "." + inicio.getSeconds();
	return texto;
}

public String generarTextoVencimiento() {
	String texto = "";
	//int anio=vencimiento.getYear()+1900;
	//String.valueOf(anio)
	texto += vencimiento.getYear() + "." + vencimiento.getMonth() + "." + vencimiento.getDate() + "." + vencimiento.getHours() + "." + vencimiento.getMinutes() + "." + vencimiento.getSeconds();
	return texto;
}


public String generarTexto() {
	String texto="";
	texto+=getPoliza()+"'";
	texto+= getCobertura()+"'";
	texto+=generarTextoFechaInicio()+"'";
	texto+=generarTextoVencimiento()+"'";
	texto+= getCompania();
	return texto;
}


	
}
