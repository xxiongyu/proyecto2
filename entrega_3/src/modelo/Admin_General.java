package modelo;
import java.util.List;

import modelo.Carro;

public class Admin_General extends usuario{
	;
	
	public Admin_General(String log, String pword) {
		super(log,pword);
		
		
	}
	
	public void nuevo_carro(String placa , String marca, String modelo, String color, String transmision,
			String estado, String ubicacion, int capacidad, String categoria, List<Car> lista) {
		
		Car carro = new Car(placa,marca,modelo,color,transmision,estado,ubicacion,capacidad,categoria);
		
		lista.add(carro);
	}
	public void carro_fuera(String placa, List<Car> lista) {
		int a = 0;
		Car instancias = lista.get(a);
		String placa_instancia = instancias.getPlaca();
		if(placa != placa_instancia) {
			a += 1;
			carro_fuera(placa,lista);
			
		}else {
			lista.remove(a);
		}
	}

}
