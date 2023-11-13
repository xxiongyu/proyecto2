package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Conductor;
import modelo.InfoReserva;
import modelo.Licencia;
import modelo.Seguro;

public class InterfazCliente extends JFrame {
	private static SistemaDeReservas sistemaDeReservas;
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
	private String idReservaSeleccionada;
	private String carroSeleccionado;
	private String seguroSeleccionado;
	private InfoReserva reservaSeleccionada;
	
	
	private JPanel panelModificarReserva;
	
	private JTextField txtFechaSalida;

	private JTextField txtSedeSalida;
	
	private JTextField txtFechaDeVuelta;
	
	private JTextField txtSedeDeVuelta;
	
	private JTextField txtHoraRecoger;
	
	private JTextField txtNumTarjeta;
	
	private JTextField txtFechaExpiracion;
	
	private JTextField txtCvv;
	
	private JTextField txtNumlicencia;
	
	private JTextField txtPais;
	
	private JTextField txtFechaVencimiento;
	
	
	
	public InterfazCliente(ArrayList<String> reservasp,ArrayList<Seguro> segurosp) {
		setReservas(reservasp);
		int tamX =850;
		int tamY=550;
		setTitle("CLIENTE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(tamX,tamY);
		setLayout(new BorderLayout());
		//setResizable(false);
		reservarVehiculo= new JTabbedPane();
		reservarVehiculo.setFocusable(false);
		
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
		setPanelReserCentro(panelReserCentro,segurosp);
		
		JPanel panelMetodoPago = new JPanel();
		JPanel panelMetodoPagoCentro = new JPanel();
		panelMetodoPagoCentro.setLayout(new GridLayout(4,4));
		JLabel lbMetodopago = new JLabel("       METODO DE PAGO       ");
		
		JLabel lbNumTarjeta = new JLabel("Numero de tarjeta:      ");
		txtNumTarjeta = new JTextField(4);
		
		JLabel lbFechaExpiracion = new JLabel("Fecha de expiración:      ");
		txtFechaExpiracion = new JTextField(4);
		
		JLabel lbCvv = new JLabel("CVV:      ");
		txtCvv= new JTextField(4);
		
		JLabel lbLicencia = new JLabel("       METODO DE PAGO       ");
		
		JLabel lbNumLicencia = new JLabel("Numero de licencia:");
		txtNumlicencia=new JTextField(4);
		
		JLabel lbPais = new JLabel("Pais:");
		txtPais=new JTextField(4);
		
		JLabel lbFechaVen = new JLabel("Fecha vencimiento:");
		txtFechaVencimiento=new JTextField(4);
		
		panelMetodoPagoCentro.add(lbMetodopago);
		panelMetodoPagoCentro.add(new Label());
		panelMetodoPagoCentro.add(lbLicencia);
		panelMetodoPagoCentro.add(new Label());
		panelMetodoPagoCentro.add(lbNumTarjeta);
		panelMetodoPagoCentro.add(txtNumTarjeta);
		panelMetodoPagoCentro.add(lbNumLicencia);
		panelMetodoPagoCentro.add(txtNumlicencia);
		panelMetodoPagoCentro.add(lbFechaExpiracion);
		panelMetodoPagoCentro.add(txtFechaExpiracion);
		panelMetodoPagoCentro.add(lbPais);
		panelMetodoPagoCentro.add(txtPais);
		panelMetodoPagoCentro.add(lbCvv);
		panelMetodoPagoCentro.add(txtCvv);
		panelMetodoPagoCentro.add(lbFechaVen);
		panelMetodoPagoCentro.add(txtFechaVencimiento);
		
		panelMetodoPago.add(panelMetodoPagoCentro,BorderLayout.CENTER);
		panelMetodoPago.add(new JPanel(),BorderLayout.EAST);
		
		panelReserCentro.add(panelMetodoPago,BorderLayout.SOUTH);
		panelReserCentro.add(panelMetodoPago,BorderLayout.SOUTH);
		panelReserCentro.add(new JPanel(),BorderLayout.EAST);
		panelReservarVehiculo.add(panelReserCentro,BorderLayout.CENTER);
		
		
		panelReserEste=new JPanel();
		panelReserEste.setLayout(new GridLayout(8,1));
		panelReserEste.add(new JLabel("        Tus reservas        "));
        reservas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                	idReservaSeleccionada = reservas.getSelectedValue();   
                	//System.out.println(idReservaSeleccionada);
                    reservaSeleccionada= sistemaDeReservas.encontrarReservaDelCliente(idReservaSeleccionada);
                	txtFechaSalida.setText(reservaSeleccionada.generarFechaAenseñarI());

                	txtSedeSalida.setText(reservaSeleccionada.getSedeEntrega());
                	
                	txtFechaDeVuelta.setText(reservaSeleccionada.generarFechaAenseñarE());
                	
                	txtSedeDeVuelta.setText(reservaSeleccionada.getSedeDevuelta());
                }}});
		JScrollPane scrollPane = new JScrollPane(reservas);
		scrollPane.setPreferredSize(new Dimension(210, 150));
		panelReserEste.add(scrollPane) ;
		modificarReserva=new JButton("Modificar reserva");
		modificarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(idReservaSeleccionada==null) {
            		JOptionPane.showMessageDialog(InterfazCliente.this, "Selecciona una de tus reservas!!", "Reserva no seleccionada", JOptionPane.WARNING_MESSAGE);
            	}else if(idReservaSeleccionada.equals("No tienes reservas")){
            		JOptionPane.showMessageDialog(InterfazCliente.this, "No tienes reservas, que esperas para hacer la tuya!!", "Sin reservas", JOptionPane.WARNING_MESSAGE);
            	}else {
                	reservaSeleccionada.setFechaInicio(txtFechaSalida.getText());
                	reservaSeleccionada.setSedeEntrega(txtSedeSalida.getText());
                	reservaSeleccionada.setFechaEntrega(txtFechaDeVuelta.getText());
                	reservaSeleccionada.setSedeDevuelta(txtSedeDeVuelta.getText());
                	reservaSeleccionada.setSeguro(sistemaDeReservas.encontrarSeguroDelCliente(seguroSeleccionado));
                	reservaSeleccionada.setCarroEnReserva(carroSeleccionado);
                	sistemaDeReservas.eliminarDocReser();
                	sistemaDeReservas.actualizarReservas(reservaSeleccionada);
                	try {
						sistemaDeReservas.salavarReservas();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                	System.out.println("Realizando acciones con: " + idReservaSeleccionada);
                	
                }
            }});
		
		panelReserEste.add(modificarReserva);
		panelReserEste.add(new JLabel("        Carros disponibles:        "));
		carros=new JComboBox<String>();
		carros.addItem("carro 1");
		carros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JComboBox placas = (JComboBox) e.getSource();
            	String placa= (String)placas.getSelectedItem();
                for (int i = 0; i < carros.getItemCount(); i++) {
                	String elemento = (String) carros.getItemAt(i);
                    if(placa.equals(elemento)) {
                    	carroSeleccionado=placa;
                    }
                }
            }});
		panelReserEste.add(carros);
		panelReserEste.add(new JPanel());
		reservarVehículo=new JButton("Reservar vehículo");
		reservarVehículo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	Conductor conductor= new Conductor(new Licencia(seguroSeleccionado, idReservaSeleccionada, null));
            	InfoReserva nuevaReserva=new InfoReserva(sistemaDeReservas.generarId(), 3.5f, 4, null, carroSeleccionado, null,
                      carroSeleccionado, seguroSeleccionado, idReservaSeleccionada, null, null, null, carroSeleccionado);
            	
            	reservaSeleccionada.setFechaInicio(txtFechaSalida.getText());
            	reservaSeleccionada.setSedeEntrega(txtSedeSalida.getText());
            	reservaSeleccionada.setFechaEntrega(txtFechaDeVuelta.getText());
            	reservaSeleccionada.setSedeDevuelta(txtSedeDeVuelta.getText());
            	reservaSeleccionada.setSeguro(sistemaDeReservas.encontrarSeguroDelCliente(seguroSeleccionado));
            	reservaSeleccionada.setCarroEnReserva(carroSeleccionado);
            	try {
					sistemaDeReservas.crearReserva(reservaSeleccionada);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	
            }});
		panelReserEste.add(reservarVehículo);
	
		panelReservarVehiculo.add(panelReserEste,BorderLayout.EAST);
		
		ImageIcon iconReser = new ImageIcon("iconos\\iconReserva.png");


        Image reserNu = iconReser.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);

        ImageIcon resizedReser = new ImageIcon(reserNu);

		reservarVehiculo.add("Reservar vehículo",panelReservarVehiculo);

		reservarVehiculo.setIconAt(0, resizedReser);

		
		add(reservarVehiculo);
        

		
		
	}
	
	public void setPanelReserCentro(JPanel panelReserCentro,ArrayList<Seguro> segurosp) {
		this.panelReserCentro = panelReserCentro;
		JPanel panelReserCentroCentro= new JPanel();
		this.panelReserCentro.setLayout(new BorderLayout());
		panelReserCentroCentro.setLayout(new GridLayout(7,2));

		
		JLabel lbFechaSalida = new JLabel("Fecha a reclamar el carro:");
		txtFechaSalida = new JTextField(4);
	    
		JLabel lbSedeSalida = new JLabel("Sede donde desea recoger el carro:");
		txtSedeSalida = new JTextField(4);
		
		JLabel lbFechaDeVuelta = new JLabel("Fecha a entregar el carro: ");
		txtFechaDeVuelta = new JTextField(4);
		
		JLabel lbSedeDeVuelta = new JLabel("Sede donde desea entregar el carro: ");
		txtSedeDeVuelta = new JTextField(4);
		
		panelReserCentroCentro.add(new JLabel("Formato de fechas y horas"));
		panelReserCentroCentro.add(new JLabel("(YYYY.dd.MM.HH.mm)"));
		
		panelReserCentroCentro.add(lbFechaSalida);

		panelReserCentroCentro.add(txtFechaSalida);

		panelReserCentroCentro.add(lbSedeSalida);

		panelReserCentroCentro.add(txtSedeSalida);

		panelReserCentroCentro.add(lbFechaDeVuelta);

		panelReserCentroCentro.add(txtFechaDeVuelta);

	    
		panelReserCentroCentro.add(lbSedeDeVuelta);
		panelReserCentroCentro.add(txtSedeDeVuelta);
		
		
		
		panelReserSouth=new JPanel();
		panelReserSouth.setLayout(null); 
		JLabel lbsSeguros= new JLabel("Seguros:");
		lbsSeguros.setBounds(1, 7, 51,30); 
		panelReserSouth.add(lbsSeguros);
		setSeguros(segurosp);
		seguros.setBounds(56, 4, 173,39 );
		seguros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JComboBox seguros = (JComboBox) e.getSource();
            	String seguro= (String)seguros.getSelectedItem();
                for (int i = 0; i < seguros.getItemCount(); i++) {
                	String elemento = (String) seguros.getItemAt(i);
                    if(seguro.equals(elemento)) {
                    	seguroSeleccionado=seguro;
                    	System.out.println(seguroSeleccionado);
                    }
                }
            }});
		panelReserSouth.add(seguros);
		panelReserCentroCentro.add(panelReserSouth,BorderLayout.SOUTH);
		this.panelReserCentro.add(panelReserCentroCentro,BorderLayout.CENTER);
	}	
	
	public void setSeguros( ArrayList<Seguro> seguros) {
		this.seguros=new JComboBox<String>();
		for(int i=0;i<seguros.size();i++) {
			this.seguros.addItem(seguros.get(i).getCobertura());;
		}
	}
	
    public void setReservas(ArrayList<String> reservas) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (int i = 0; i < reservas.size(); i++) {
            modeloLista.addElement(reservas.get(i));
        }

        this.reservas = new JList<>(modeloLista);
    }
    

	
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date fecha = new Date(2023 - 1900, 11 - 1, 12);

        // Define el formato que deseas
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        // Convierte la fecha a una cadena de texto en el formato deseado
        String fechaComoTexto = sdf.format(fecha);

        System.out.println("Fecha como texto: " + fechaComoTexto);
		sistemaDeReservas= new SistemaDeReservas();
		sistemaDeReservas.setClienteLogeado("g.chaparr");
		try {
			sistemaDeReservas.cargarReservas();
			sistemaDeReservas.cargarSeguros();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		InterfazCliente interfazCli =new InterfazCliente(sistemaDeReservas.getIdsReservasDelCliente(),sistemaDeReservas.getSeguros());
		interfazCli.setLocationRelativeTo(null);
		interfazCli.setVisible(true);		
		
	}
}
