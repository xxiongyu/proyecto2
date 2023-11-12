package modelo;

import java.util.List;

public class Empleado extends usuario{
	private Sede sede;

	public Empleado(String log, String pword) {
		super(log, pword);

	}
	
	public void estado_carro(String placa,String estado, List<Car> lista) {
		int a = 0;
		Car instancias = lista.get(a);
		String estado_instancia = instancias.getEstado()
		if(placa != estado_instancia) {
			a += 1;
			estado_carro(placa,lista);
			
		}else {
			instancias.cambiarEstado(estado);
		}
	}
	public void nuevo_empleado(String log, String pword, String name, String mail, int cel, List<Cliente> lista) {
		Cliente customer = new Cliente(log,pword,name,mail,cel);
		lista.add(customer);
		
	}
		
		
	}

