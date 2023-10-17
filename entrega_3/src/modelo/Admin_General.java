package modelo;
import java.util.List;


public class Admin_General extends usuario{
	;
	
	public Admin_General(String log, String pword) {
		super(log,pword);
		
		
	}
	
	public void nuevo_car(String placa, String marca, String modelo, String color, String transmision,
            String estado, String categoria, int ubicacion, String Alquilado,String Disponibilidad, List<Carro> lista) {
		
		Carro car = new Carro(placa,marca, modelo, color,  transmision,
                estado, categoria, ubicacion, Alquilado,Disponibilidad);
		lista.add(car);
	}
	public void carro_fuera(String placa, List<Carro> lista) {
		int a = 0;
		Carro instancias = lista.get(a);
		String placa_instancia = instancias.getPlaca();
		if(placa != placa_instancia) {
			a += 1;
			carro_fuera(placa,lista);
			
		}else {
			lista.remove(a);
		}
	}

}
