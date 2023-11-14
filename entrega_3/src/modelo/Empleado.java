package modelo;

import java.util.List;

import javax.swing.JTextField;

import consola.EmpleadoI;
import modelo.Carro;
import modelo.InfoReserva;
import modelo.Cliente;
import modelo.Sede;

public class Empleado extends usuario implements EmpleadoI{

	private Sede sede;

	public Empleado(String log, String pword) {
		super(log, pword);

	}
	
	
	
	public void estado_carro(String placa,String estado, List<Carro> lista) {
		int a = 0;
		Carro instancias = lista.get(a);
		String estado_instancia = instancias.getEstado();
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
    public void entregaCarros(Carro carro) {
        carro.cambiarEstado("alquilado");
        carro.setAlquilado(true);
    }
    public void devolucionCarro(Carro carro) {
        carro.cambiarEstado("sucio");
        carro.setAlquilado(false);
    }
    public void registroConductor() {
        // Puede llamar a ese método para obtener la información deseada
        String infoNLic = obtenerTextoInfoNLic();
        String infoNP = obtenerTextoInfoNP();
        String infoNV = obtenerTextoInfoNV();
        String direccionImagen = obtenerDireccionImagen();

        // Unir los Strings en uno solo
        String informacionCompleta = infoNLic + "," + infoNP + "," + infoNV + "," + direccionImagen;

        InfoReserva infoReserva = new InfoReserva();

        // Llamar al método cargarConductores de la clase InfoReserva
        String resultadoCargarConductores = infoReserva.cargarConductores(informacionCompleta);
    }

    private String obtenerTextoInfoNLic(JTextField textField) {
        return textField.getText();
    }

    private String obtenerTextoInfoNP(JTextField textField) {
        return textField.getText();
    }

    private String obtenerTextoInfoNV(JTextField textField) {
        return textField.getText();
    }

    private String obtenerDireccionImagen(JTextField textField) {
        return textField.getText();
    }
		
		
	}
