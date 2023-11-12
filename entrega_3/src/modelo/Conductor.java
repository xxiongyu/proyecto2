package modelo;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Conductor {
	//private Documento documento;
	private Licencia datoslicencia;
	
public Conductor( Licencia licenciap ) {
	datoslicencia= licenciap;
	
}	

public Licencia obtenerLicencia() {
	return datoslicencia;
}

public String generarTexto() {
	return datoslicencia.generarTexto();
}

}
