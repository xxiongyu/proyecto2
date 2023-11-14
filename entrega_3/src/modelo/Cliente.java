package modelo;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;


public class Cliente extends usuario{
	private String nombre;
	private String correo;
	private String celular;
	private ArrayList<String> idReserva=new ArrayList<String>();
	

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
	public void setIdReserva(ArrayList<String> idReserva ) {
		if(this.idReserva.size()==0) {
			this.idReserva.add(idReserva.get(0));
		}else {
        for (int i = 0; i < this.idReserva.size(); i++) {
        	this.idReserva.add(idReserva.get(i));
        }
		
	}
	}
	
	public String generarTexto() {
		String texto= "";
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
//		texto+= getNombre()+":";
//		texto+= getCorreo()+":";
//		texto+= getCelular();
		return texto;
}
}
