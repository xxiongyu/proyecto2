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
	public generarTexto() {
		texto+= getNombre()+":";
		texto+= getCorreo()+":";
		texto+= getCel();
	
	
}
}
