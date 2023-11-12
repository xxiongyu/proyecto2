package consola;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.util.ArrayList;

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

public class InterfazCliente extends JFrame {
	private JTabbedPane reservarVehiculo;
	private JTabbedPane modDatosReserva;

	private JPanel panelReservarVehiculo;
	private JPanel panelReserCentro;
	private JPanel panelReserNorth;
	private JPanel panelReserSouth;
	private JPanel panelReserEste;
	private JComboBox<String> carros ;
	private JComboBox<String> seguros;
	private JList<String> reservas;
	private JButton reservarVehículo;
	private JButton modificarReserva;
	
	
	private JPanel panelModificarReserva;
	
	private JTextField txtFechaSalida;

	private JTextField txtSedeSalida;
	
	private JTextField txtFechaDeVuelta;
	
	private JTextField txtSedeDeVuelta;
	
	private JTextField txtNumTarjeta;
	
	private JTextField txtFechaExpiracion;
	
	private JTextField txtCvv;
	
	
	
	public InterfazCliente(ArrayList<String> reservasp) {
		setReservas(reservasp);
		int tamX =700;
		int tamY=550;
		setTitle("CLIENTE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(tamX,tamY);
		setLayout(new BorderLayout());
		//setResizable(false);
		reservarVehiculo= new JTabbedPane();
		reservarVehiculo.setFocusable(false);

		

//		panelReservarVehiculo.setLayout(new GridLayout(4,0));
		
		panelReservarVehiculo = new JPanel();
		panelReservarVehiculo.setLayout(new BorderLayout());
		
		panelReserNorth=new JPanel();
		
		panelReserNorth.setLayout(new GridLayout(3,1));
		
		JLabel cliente=new JLabel("CLIENTE");
		cliente.setHorizontalAlignment(JLabel.CENTER);
		panelReserNorth.add(cliente);
		
		JLabel reserva=new JLabel("Reservar un vehículo");
		reserva.setHorizontalAlignment(JLabel.CENTER);
		panelReserNorth.add(reserva);
		panelReserNorth.add(new Label());
		
		panelReservarVehiculo.add(panelReserNorth,BorderLayout.NORTH);
		
		panelReserCentro= new JPanel();
		JPanel panelReserCentroCentro= new JPanel();
		panelReserCentro.setLayout(new BorderLayout());
		panelReserCentroCentro.setLayout(new GridLayout(6,2));

		
		JLabel lbFechaSalida = new JLabel("Fecha a reclamar el carro:");
		txtFechaSalida = new JTextField(4);
	    
		JLabel lbSedeSalida = new JLabel("Sede donde desea recoger el carro:");
		txtSedeSalida = new JTextField(4);
		
		JLabel lbFechaDeVuelta = new JLabel("Fecha a entregar el carro: ");
		txtFechaDeVuelta = new JTextField(4);
		
		JLabel lbSedeDeVuelta = new JLabel("Sede donde desea entregar el carro: ");
		txtSedeDeVuelta = new JTextField(4);
		
		
		
		panelReserCentroCentro.add(lbFechaSalida);

		panelReserCentroCentro.add(txtFechaSalida);

		panelReserCentroCentro.add(lbSedeSalida);

		panelReserCentroCentro.add(txtSedeSalida);

		panelReserCentroCentro.add(lbFechaDeVuelta);

		panelReserCentroCentro.add(txtFechaDeVuelta);

	    
		panelReserCentroCentro.add(lbSedeDeVuelta);
		

		panelReserCentroCentro.add(txtSedeDeVuelta);
		
		panelReserSouth=new JPanel();
		panelReserSouth.add(new JLabel("Seguros:"));
		seguros=new JComboBox<String>();
		seguros.addItem("#1 Cubre todo");
		panelReserSouth.add(seguros);
		panelReserCentroCentro.add(panelReserSouth,BorderLayout.SOUTH);
		panelReserCentro.add(panelReserCentroCentro,BorderLayout.CENTER);
		
		JPanel panelMetodoPago = new JPanel();
		JPanel panelMetodoPagoCentro = new JPanel();
		panelMetodoPagoCentro.setLayout(new GridLayout(4,2));
		JLabel lbMetodopago = new JLabel("       METODO DE PAGO       ");
		panelMetodoPagoCentro.add(lbMetodopago);
		JLabel lbNumTarjeta = new JLabel("Numero de tarjeta:      ");
		txtNumTarjeta = new JTextField(4);
		
		JLabel lbFechaExpiracion = new JLabel("Fecha de expiración:      ");
		txtFechaExpiracion = new JTextField(4);
		
		JLabel lbCvv = new JLabel("CVV:      ");
		txtCvv= new JTextField(4);
		
		panelMetodoPagoCentro.add(new Label());
		panelMetodoPagoCentro.add(lbNumTarjeta);
		panelMetodoPagoCentro.add(txtNumTarjeta);
		panelMetodoPagoCentro.add(lbFechaExpiracion);
		panelMetodoPagoCentro.add(txtFechaExpiracion);
		panelMetodoPagoCentro.add(lbCvv);
		panelMetodoPagoCentro.add(txtCvv);
		panelMetodoPago.add(panelMetodoPagoCentro,BorderLayout.CENTER);
		panelMetodoPago.add(new JPanel(),BorderLayout.EAST);
		
		
		
		
		
		panelReserCentro.add(panelMetodoPago,BorderLayout.SOUTH);
		panelReserCentro.add(panelMetodoPago,BorderLayout.SOUTH);
		panelReserCentro.add(panelReserCentroCentro,BorderLayout.CENTER);
		panelReserCentro.add(new JPanel(),BorderLayout.EAST);
		panelReservarVehiculo.add(panelReserCentro,BorderLayout.CENTER);
		
		
		panelReserEste=new JPanel();
		panelReserEste.setLayout(new GridLayout(8,1));
//		if(reservas.getModel().getSize()!=0) {
//			panelReserEste.add(new JLabel("Tus reservas"));
//			panelReserEste.add(reservas);
//			panelReserEste.add(new JLabel());
//			modificarReserva=new JButton("Modificar reservas");
//			panelReserEste.add(modificarReserva);
//		}
		panelReserEste.add(new JLabel("        Tus reservas        "));
		JScrollPane scrollPane = new JScrollPane(reservas);
		scrollPane.setPreferredSize(new Dimension(210, 150));
		panelReserEste.add(scrollPane) ;
		modificarReserva=new JButton("Modificar reserva");
		panelReserEste.add(modificarReserva);
		panelReserEste.add(new JLabel("        Carros disponibles:        "));
		carros=new JComboBox<String>();
		carros.addItem("carro 1");
		panelReserEste.add(carros);
		panelReserEste.add(new JPanel());
		reservarVehículo=new JButton("Reservar vehículo");
		panelReserEste.add(reservarVehículo);
	
		panelReservarVehiculo.add(panelReserEste,BorderLayout.EAST);
		
		ImageIcon iconReser = new ImageIcon("iconos\\iconReserva.png");


        Image reserNu = iconReser.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

        ImageIcon resizedReser = new ImageIcon(reserNu);

		reservarVehiculo.add("Reservar vehículo",panelReservarVehiculo);

		reservarVehiculo.setIconAt(0, resizedReser);

		
		add(reservarVehiculo);
        

		
		
	}
	
    public void setReservas(ArrayList<String> reservas) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (int i = 0; i < reservas.size(); i++) {
            modeloLista.addElement(reservas.get(i));
        }

        this.reservas = new JList<>(modeloLista);
    }
    
	
//	public static void main(String[] args) {
//		ArrayList<String> reservas = new ArrayList<String>();
//		reservas.add("hola casa de ");
//		reservas.add("hola");
//		reservas.add("perro");
//		reservas.add("casa");
//		reservas.add("casa");
//		reservas.add("casa");
//		reservas.add("casa");
//		reservas.add("casa");
//		reservas.add("casa");
//		reservas.add("casa");
//		InterfazCliente interfazCli =new InterfazCliente(reservas);
//		interfazCli.setLocationRelativeTo(null);
//		interfazCli.setVisible(true);		
//		
//	}
}
