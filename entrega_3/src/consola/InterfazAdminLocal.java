package consola;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class InterfazAdminLocal extends JFrame {
	
	private JTabbedPane ventanaAdminLocal;
	
	private JPanel panelModCarro;
	
	private JTextField txtNombreEmpleado;
	
	private JTextField txtSueldo;
	
	private JTextField txtUsuario;

	private JTextField txtNumeroDocumento;
	
	private JTextField txtSede;
	
	private JTextField txtModelo;
	
	private JTextField txtPlaca;
	
	private JTextField txtMarca;

	private JTextField txtColor;
	
	private JTextField txtTransmision;
	
	private JTextField txtEstado;
	
	private JTextField txtUbicacion;
	
	private JButton btnMod;
	
	private JButton btnRegistrar;
	
	private JButton btnGuardar;
	
	private JList<String> empleados;
	
	
	
	public InterfazAdminLocal(ArrayList<String> empleadosp) {
		setEmpleados(empleadosp);
		int tamX =700;
		int tamY=550;
		setTitle("ADMINISTRADOR LOCAL");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(tamX,tamY);
		setLayout(new BorderLayout());
		
		ventanaAdminLocal= new JTabbedPane();
		ventanaAdminLocal.setFocusable(false);
		
		setPanelModCarro();
		
		JPanel panelModReserEmpleado = new JPanel();
		
		JPanel panelTitle= new JPanel();
		panelTitle.setLayout(new GridLayout(1,3));
		panelTitle.add(new Label());
		JLabel title=new JLabel("INFORMACIÓN EMPLEADO");
		title.setHorizontalAlignment(JLabel.CENTER);
		panelTitle.add(title);
		panelTitle.add(new Label());
		panelModReserEmpleado.add(panelTitle,BorderLayout.NORTH);
		
		
		JPanel panelDatos= new JPanel();
		panelDatos.setLayout(new GridLayout(15,3));
		
		JLabel nombreEmpleado=new JLabel("Nombre del empleado:  ");
		txtNombreEmpleado= new JTextField(5);
		
		JLabel sueldo=new JLabel("Sueldo:  ");
		txtSueldo= new JTextField(4);
		
		JLabel usuario=new JLabel("Usuario:  ");
		txtUsuario= new JTextField(4);
		
		JLabel numeroDocumento=new JLabel("No Documento:  ");
		txtNumeroDocumento= new JTextField(4);
		
		JLabel sede=new JLabel("Sede en la que trabaja:  ");
		txtSede=new JTextField(4);
		
		panelDatos.add(nombreEmpleado);
		panelDatos.add(txtNombreEmpleado);
		panelDatos.add(new JLabel());
		panelDatos.add(sueldo);
		panelDatos.add(txtSueldo);
		panelDatos.add(new JLabel());
		panelDatos.add(usuario);
		panelDatos.add(txtUsuario);
		panelDatos.add(new JLabel());
		panelDatos.add(numeroDocumento);
		panelDatos.add(txtNumeroDocumento);
		panelDatos.add(new JLabel());
		panelDatos.add(sede);
		panelDatos.add(txtSede);
		panelDatos.add(new JLabel());
		
		for(int i=0;i<30;i++) {
			if(i==4) {
				btnRegistrar=new JButton("Registrar");
				panelDatos.add(btnRegistrar);
			}else {
				panelDatos.add(new JLabel());
			}
		}

		
		panelModReserEmpleado.add(panelDatos,BorderLayout.CENTER);
		
		JPanel infoEmpleados= new JPanel();
		infoEmpleados.setLayout(new GridLayout(5,1));
		

		infoEmpleados.add(new JLabel("         Elije un empleado"));
		JScrollPane scrollPane = new JScrollPane(empleados);
		scrollPane.setPreferredSize(new Dimension(145, 90));
		infoEmpleados.add(scrollPane);
		JPanel infoEmpleadosSur=new JPanel();
		btnMod=new JButton("Modificar informacion");
		infoEmpleadosSur.add(btnMod);
		infoEmpleados.add(infoEmpleadosSur,BorderLayout.SOUTH);
		panelModReserEmpleado.add(infoEmpleados,BorderLayout.EAST);
		
		ImageIcon iconEmpleado = new ImageIcon("iconos\\iconoMod.png");
		ImageIcon iconModCar = new ImageIcon("iconos\\iconModCar.png");
		Image modEmpleado = iconEmpleado.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		Image modCar = iconModCar.getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		ImageIcon resizedModEmpleado = new ImageIcon(modEmpleado);
		ImageIcon resizedModCar = new ImageIcon(modCar);
		ventanaAdminLocal.add("Registrar/Modificar datos empleado",panelModReserEmpleado);
		ventanaAdminLocal.add("Actualizar información de un carro",panelModCarro);
		ventanaAdminLocal.setIconAt(0, resizedModEmpleado);
		ventanaAdminLocal.setIconAt(1, resizedModCar);
		add(ventanaAdminLocal);
		
	}
	
	
	public void setEmpleados(ArrayList<String> empleados) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (int i = 0; i < empleados.size(); i++) {
            modeloLista.addElement(empleados.get(i));
        }

        this.empleados = new JList<>(modeloLista);
		
	}
	
	public void setPanelModCarro() {
		this.panelModCarro= new JPanel();
		panelModCarro.setLayout(new BorderLayout());
		
		JPanel panelModCarroSur= new JPanel();
		JLabel titleModCar = new JLabel("ACTUALIZAR INFORMACION DE UN CARRO");
		titleModCar.setHorizontalAlignment(JLabel.CENTER);
		panelModCarroSur.add(titleModCar);
		panelModCarro.add(panelModCarroSur,BorderLayout.NORTH);
		
		JPanel panelModCarroCentro= new JPanel();
		panelModCarroCentro.setLayout(new GridLayout(11,4));
	
		
		JLabel modelo = new JLabel("Modelo:");
		txtModelo= new JTextField(4);
		
		JLabel placa = new JLabel("Placa:");
		txtPlaca=new JTextField(4);
		
		JLabel marca = new JLabel("Marca:");
		txtMarca = new JTextField(4);
		
		JLabel color = new JLabel("Color:");
		txtColor= new JTextField(4);
		
		JLabel transmision = new JLabel("Transmision:");
		txtTransmision= new JTextField(4);
		
		JLabel estado = new JLabel("Estado:");
		txtEstado= new JTextField(4);
		
		JLabel ubicacion = new JLabel("Ubicacion:");
		txtUbicacion= new JTextField(4);
		
		for(int i=0;i<4;i++) {
			panelModCarroCentro.add(new JLabel());
		}
		panelModCarroCentro.add(modelo);
		panelModCarroCentro.add(txtModelo);
		panelModCarroCentro.add(new JLabel());
		panelModCarroCentro.add(new JLabel());
		
		panelModCarroCentro.add(placa);
		panelModCarroCentro.add(txtPlaca);
		panelModCarroCentro.add(new JLabel());
		panelModCarroCentro.add(new JLabel());
		
		panelModCarroCentro.add(marca);
		panelModCarroCentro.add(txtMarca);
		panelModCarroCentro.add(new JLabel());
		panelModCarroCentro.add(new JLabel());
		
		panelModCarroCentro.add(color);
		panelModCarroCentro.add(txtColor);
		panelModCarroCentro.add(new JLabel());
		panelModCarroCentro.add(new JLabel());
		
		panelModCarroCentro.add(transmision);
		panelModCarroCentro.add(txtTransmision);
		panelModCarroCentro.add(new JLabel());
		panelModCarroCentro.add(new JLabel());
		
		panelModCarroCentro.add(estado);
		panelModCarroCentro.add(txtEstado);
		panelModCarroCentro.add(new JLabel());
		panelModCarroCentro.add(new JLabel());
		
		panelModCarroCentro.add(ubicacion);
		panelModCarroCentro.add(txtUbicacion);
		panelModCarroCentro.add(new JLabel());
		panelModCarroCentro.add(new JLabel());
		
		for(int i=0;i<4;i++) {
			panelModCarroCentro.add(new JLabel());
		}

		panelModCarroCentro.add(new JLabel());
		btnGuardar= new JButton("Guardar");		
		panelModCarroCentro.add(btnGuardar);

		
		panelModCarro.add(panelModCarroCentro,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		ArrayList<String> empleados = new ArrayList<String>();
		empleados.add("hola casa de ");
		empleados.add("hola");
		empleados.add("perro");
		empleados.add("casa");
		empleados.add("casa");
		empleados.add("casa");
		empleados.add("casa");
		empleados.add("casa");
		empleados.add("casa");
		empleados.add("casa");
		InterfazAdminLocal interfazAdmin =new InterfazAdminLocal(empleados);
		interfazAdmin.setLocationRelativeTo(null);
		interfazAdmin.setVisible(true);		
	}

}
