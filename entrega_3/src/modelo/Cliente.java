package modelo;

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
		texto+= getNombre()+">";
		texto+= getCorreo()+">";
		texto+= getCelular();
		return texto;
	
}
}
