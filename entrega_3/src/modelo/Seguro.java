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


	
}
