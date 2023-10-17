package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends usuario{
	private String nombre;
	private String correo;
	private int celular;

	public Cliente(String log, String pword, String name, String mail, int cel ) {
		super(log, pword);
		this.nombre = name;
		this.correo = mail;
		this.celular = cel;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public int getCelular() {
		return celular;
	}
	
	public String generarTexto() {
		String texto= "";
		texto+= getNombre()+":";
		texto+= getCorreo()+":";
<<<<<<< HEAD
		texto+= getCel();
=======
		texto+= getCelular();
		return texto;
	
>>>>>>> refs/remotes/origin/main
}
	public void reservar_carro(String tiempoReservap,float precio30p,ArrayList<Conductor>  conductorp,
	           String medioDePagop,Seguro segurop, String sedeEntregap,Date fechaIniciop, List<InfoReserva> list) {
		InfoReserva reserva = new InfoReserva(tiempoReservap, precio30p, conductorp, medioDePagop,segurop,  sedeEntregap,fechaIniciop);
		lista.add(reserva);
		
	}
}
