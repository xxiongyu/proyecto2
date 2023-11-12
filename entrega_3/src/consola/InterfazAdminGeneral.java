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

public class InterfazAdminGeneral extends JFrame{
	
	private JTabbedPane ventanaAdminGeneral;

	private JPanel pnRegistrarCarro;
	
	private JPanel pnTraslado;
	
	private JTextField txtModelo;
	
	private JTextField txtPlaca;
	
	private JTextField txtMarca;

	private JTextField txtColor;
	
	private JTextField txtTransmision;
	
	private JTextField txtEstado;
	
	private JTextField txtUbicacion;
	
	private JButton btnAgregar;
	
	private JList<String> vehiculos;
	
	private JList<String> sedes;
	
	private JTextField txtSedeNueva;
	
	private JTextField txtCarroTrasladoDesecho;
	
	private JButton bnTraslado;
	
	private JButton bnEliminarVehiculo;
	
	public InterfazAdminGeneral(ArrayList<String> vehiculos,ArrayList<String> sedes) {
		int tamX =700;
		int tamY=550;
		setTitle("ADMINISTRADOR GENERAL");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(tamX,tamY);
		setLayout(new BorderLayout());
		
		ventanaAdminGeneral= new JTabbedPane();
		ventanaAdminGeneral.setFocusable(false);
		
		setpnRegistrarCarro();
		setVehiculos(vehiculos);
		setSedes(sedes);
		setPnTraslado();
	
		ImageIcon iconNuevoCar = new ImageIcon("iconos\\iconoNuevoCar.png");
		ImageIcon iconTraslado = new ImageIcon("iconos\\iconModCar.png");
		Image  nuevoCar = iconNuevoCar.getImage().getScaledInstance(24,24, Image.SCALE_SMOOTH);
		Image modCar = iconTraslado.getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH);
		ImageIcon resizedNuevoCar = new ImageIcon(nuevoCar);
		ImageIcon resizedModCar = new ImageIcon(modCar);
		ventanaAdminGeneral.add("Registrar nuevo carro",pnRegistrarCarro);
    	ventanaAdminGeneral.add("Actualizar información de un carro",pnTraslado);
		ventanaAdminGeneral.setIconAt(0, resizedNuevoCar);
      	ventanaAdminGeneral.setIconAt(1, resizedModCar);
		add(ventanaAdminGeneral);
		
	}
	
	public void setPnTraslado() {
		this.pnTraslado=new JPanel();
		pnTraslado.setLayout(null);
		JLabel titulo= new JLabel("Traslado vehículo ");
		titulo.setBounds(290, 10, 200,20);
		pnTraslado.add(titulo);
		
		JLabel lbTextField =new JLabel("Vehículos en inventario");
		lbTextField.setBounds(60, 50, 180,20);
		pnTraslado.add(lbTextField);
		
		pnTraslado.add(new JLabel("Vehículos en inventario"));
		JScrollPane scrollPane = new JScrollPane(vehiculos);
		scrollPane.setBounds(30, 85, 200,150);
		pnTraslado.add(scrollPane) ;
		
		JLabel lbSedes =new JLabel("Sedes");
		lbSedes.setBounds(110, 280, 180,20);
		pnTraslado.add(lbSedes);
		
		JScrollPane scrollPane2 = new JScrollPane(sedes);
		scrollPane2.setBounds(30, 310, 200,150);
		pnTraslado.add(scrollPane2) ;
		
		JLabel lbvehiculo=new JLabel("Ingresa el Vehículo:");
		lbvehiculo.setBounds(350, 85, 180,20);
		pnTraslado.add(lbvehiculo);
		
		txtCarroTrasladoDesecho=new JTextField(4);
		txtCarroTrasladoDesecho.setBounds(350, 110, 150,35);
		pnTraslado.add(txtCarroTrasladoDesecho);
		
		JLabel lbTraslado=new JLabel("En caso que desees hacer un traslado a otra sede,");
		lbTraslado.setBounds(350, 180, 300,20);
		pnTraslado.add(lbTraslado) ;
		JLabel lbTraslado2=new JLabel("ingresa la sede de destino:");
		lbTraslado2.setBounds(350, 195, 180,20);
		pnTraslado.add(lbTraslado2) ;
		
		JLabel lbTraslado3=new JLabel("trasladar a:");
		lbTraslado3.setBounds(350, 230, 180,20);
		pnTraslado.add(lbTraslado3) ;
		
		txtSedeNueva= new JTextField(4);
		txtSedeNueva.setBounds(350, 255, 150,35);
		pnTraslado.add(txtSedeNueva);
		
		bnTraslado=new JButton("Trasladar");
		bnTraslado.setBounds(350, 350, 100,35);
		pnTraslado.add(bnTraslado);
		
		bnEliminarVehiculo=new JButton("Eliminar");
		bnEliminarVehiculo.setBounds(480, 350, 100,35);
		pnTraslado.add(bnEliminarVehiculo);
		
		
	}
	
	public void setpnRegistrarCarro(){
		this.pnRegistrarCarro= new JPanel();
		pnRegistrarCarro.setLayout(new BorderLayout());
		
		JPanel panelModCarroSur= new JPanel();
		JLabel titleModCar = new JLabel("AGREGAR VEHÍCULO A CATÁLOGO");
		titleModCar.setHorizontalAlignment(JLabel.CENTER);
		panelModCarroSur.add(titleModCar);
		pnRegistrarCarro.add(panelModCarroSur,BorderLayout.NORTH);
		
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
		btnAgregar= new JButton("Agregar");		
		panelModCarroCentro.add(btnAgregar);

		
		pnRegistrarCarro.add(panelModCarroCentro,BorderLayout.CENTER);
		
	}
	
	public void setVehiculos(ArrayList<String> vehiculos) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (int i = 0; i < vehiculos.size(); i++) {
            modeloLista.addElement(vehiculos.get(i));
        }

        this.vehiculos = new JList<>(modeloLista);
		
	}
	
	public void setSedes(ArrayList<String> sedes) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (int i = 0; i < sedes.size(); i++) {
            modeloLista.addElement(sedes.get(i));
        }

        this.sedes = new JList<>(modeloLista);
		
	}
	
	public static void main(String[] args) {
		ArrayList<String> empleados = new ArrayList<String>();
		empleados.add("hola casa de ");
		empleados.add("hola");
		empleados.add("perro");
		empleados.add("casa");
		empleados.add("casa");
		ArrayList<String> sedes = new ArrayList<String>();
		sedes.add("hola casa de ");
		sedes.add("hola");
		sedes.add("perro");
		sedes.add("casa");
		InterfazAdminGeneral interfazAdmin =new InterfazAdminGeneral(empleados,sedes);
		interfazAdmin.setLocationRelativeTo(null);
		interfazAdmin.setVisible(true);		
	}
}
