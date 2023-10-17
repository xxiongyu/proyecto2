package modelo;
import java.util.List;

public class admin_local extends usuario{

	public admin_local(String log, String pword) {
		super(log, pword);
	}
	
	public void nuevo_empleado(String log, String pword, List<Empleado> lista) {
		Empleado employee = new Empleado(log,pword);
		lista.add(employee);
		
	}
	public void cambio_datos(String log, String pword, List<Empleado> lista) {
		int a = 0;
		Empleado instancias = lista.get(a);
		String empleado_instancia = instancias.getLogin()
		if(log != empleado_instancia) {
			a += 1;
			cambio_datos(log,pword,lista);
			
		}else {
			instancias.setPassword(pword);
		}
	}
	
	

}
