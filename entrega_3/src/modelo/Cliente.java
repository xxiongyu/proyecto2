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
	public generarTexto() {
		texto+= getNombre()+":";
		texto+= getCorreo()+":";
		texto+= getCel();
}
	public void reservar_carro(String tiempoReservap,float precio30p,ArrayList<Conductor>  conductorp,
	           String medioDePagop,Seguro segurop, String sedeEntregap,Date fechaIniciop, List<InfoReserva> list) {
		InfoReserva reserva = new InfoReserva(tiempoReservap, precio30p, conductorp, medioDePagop,segurop,  sedeEntregap,fechaIniciop);
		lista.add(reserva);
		
	}
}
