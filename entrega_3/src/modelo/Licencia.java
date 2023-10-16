package modelo;

import java.awt.image.BufferedImage;
import java.util.Date;


public class Licencia {

	private int numero;
	private String pais;
	private Date fechaVencimiento;
	private BufferedImage imagenLicencia;
	
	public Licencia(int numerop,String paisp,Date fechaVencimientop,BufferedImage imagenLicenciap) {
		numero=numerop;
		pais=paisp;
		fechaVencimiento= fechaVencimientop;
		imagenLicencia=imagenLicenciap;	
	}
	
public Date getFechaVencimiento() {
	return fechaVencimiento;
}

public int getNumero() {
	return numero;
}

public String getPais() {
	return pais;
}
	
public BufferedImage getImagenLicencia() {
	return imagenLicencia;
}

}
