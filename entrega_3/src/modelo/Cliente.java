package modelo;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Date;
import java.util.List;
>>>>>>> branch 'main' of https://github.com/xxiongyu/entrega-3.git

public class Cliente extends usuario{
	private String nombre;
	private String correo;
	private String celular;
	private ArrayList<String> idReserva;
	

	public Cliente(String log, String pword, String name, String mail, String cel, ArrayList<String> idReserva) {
		super(log, pword);
		this.nombre = name;
		this.correo = mail;
		this.celular = cel;
		setIdReserva(idReserva);
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public String getCelular() {
		return celular;
	}
	public ArrayList<String> getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(ArrayList<String> idReserva) {
		ArrayList<String> idReserva2=new ArrayList<String>();
        for (int i = 0; i < idReserva.size(); i++) {
        	idReserva2.add(idReserva.get(i));
        }
		this.idReserva = idReserva2;
	}
	
	public String generarTexto() {
		String texto= "";
<<<<<<< HEAD
		texto+= getLogin()+">";
		texto+= getPassword()+">";
		texto+= getNombre()+">";
		texto+= getCorreo()+">";
		texto+= getCelular()+">";
		for(int i = 0; i < idReserva.size(); i++) {
			texto+=idReserva.get(i)+"<";
		}
		System.out.println(texto);
		//texto+= getIdReserva();
=======
		texto+= getNombre()+":";
		texto+= getCorreo()+":";
<<<<<<< HEAD
		texto+= getCel();
=======
		texto+= getCelular();
>>>>>>> branch 'main' of https://github.com/xxiongyu/entrega-3.git
		return texto;
	
>>>>>>> refs/remotes/origin/main
}
	public void reservar_carro(String tiempoReservap,float precio30p,ArrayList<Conductor>  conductorp,
	           String medioDePagop,Seguro segurop, String sedeEntregap,Date fechaIniciop, List<InfoReserva> list) {
		InfoReserva reserva = new InfoReserva(tiempoReservap, precio30p, conductorp, medioDePagop,segurop,  sedeEntregap,fechaIniciop);
		lista.add(reserva);
		
	}
}
