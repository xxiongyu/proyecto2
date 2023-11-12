package modelo;

import java.util.ArrayList;

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
		return texto;
	
}
}
