package consola;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Cliente;
import modelo.usuario;
import modelo.Admin_General;
import modelo.admin_local;
import modelo.Empleado;

public class Interfazlog extends JFrame{
	private JLabel userNameL;
	private JLabel passwordL;
	private JLabel titulo;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JButton loginButton;
	private JButton registerButton;
	private JTextField txtType;
	ArrayList<usuario> lista_empleado = new ArrayList<>();
	ArrayList<usuario> lista_adminG = new ArrayList<>();
	ArrayList<usuario> lista_adminL = new ArrayList<>();
	ArrayList<usuario> lista_cliente = new ArrayList<>();
	ArrayList<String> empleadosp = new ArrayList<>();
	
	
	public Interfazlog()   {
		int tamX =600;
		int tamY=550;
		setTitle("Sistema de reservas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(tamX,tamY);
		setResizable(false);
		setLayout(null);
		
		titulo= new JLabel("BIENVENIDO");
		titulo.setBounds(215, 50, 300,50);
		Font font = new Font("Impact", Font.PLAIN, 36);
		titulo.setFont(font);
		add(titulo,BorderLayout.NORTH);
		

		userNameL = new JLabel("Usuario");
		userNameL.setBounds(115, 150, 80, 25);
		add(userNameL);

		txtUser = new JTextField(20);
		txtUser.setBounds(195, 150, 220, 30);
		add(txtUser);

		passwordL = new JLabel("Password");
		passwordL.setBounds(115, 200, 80, 25);
		add(passwordL);

		txtPassword = new JTextField(20);
		txtPassword.setBounds(195, 200, 220, 30);
		add(txtPassword);
		
		txtType = new JTextField(20);
		txtType.setBounds(425, 150, 100,30);
		add(txtType);
		
		ArrayList<String> id = new ArrayList<String>();
		id.add("1");
		id.add("2");
		Cliente c1 = new Cliente("g.chaparr", "12345","pedro","clienteprueba@gmail.com","111111",id);
		lista_cliente.add(c1);
		Admin_General g1 = new Admin_General("generalprueba","12345");
		lista_adminG.add(g1);
		admin_local l1 = new admin_local("localprueba","12345");
		lista_adminL.add(l1);
		SistemaDeReservas sistemaDeReservas= new SistemaDeReservas();
		try {
			sistemaDeReservas.cargarReservas();
			sistemaDeReservas.cargarSeguros();
			sistemaDeReservas.cargarCarros();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		loginButton = new JButton("Entrar");
		loginButton.setBounds(200, 255, 100, 45);
		ActionListener listenLoginBtn=new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				String tipo_usuario = txtType.getText();
				String login = txtUser.getText();
				String pwrod = txtPassword.getText();
				
				System.out.println("si entro");
				if(tipo_usuario.equals("cliente")) {
					System.out.println("si entro");
					if (Cliente.entrar(login,pwrod,lista_cliente)== true) {
						
						sistemaDeReservas.setClienteLogeado(login);
						InterfazCliente interfazCli =new InterfazCliente(sistemaDeReservas.getIdsReservasDelCliente(),sistemaDeReservas.getSeguros(), sistemaDeReservas.carrosDisponibles(), sistemaDeReservas);
						interfazCli.setLocationRelativeTo(null);
						interfazCli.setVisible(true);
					}
				}
				else if(tipo_usuario.equals("administrador local")) {
					if (admin_local.entrar(login,pwrod,lista_adminL)) {
						InterfazAdminLocal interAL = new InterfazAdminLocal(empleadosp);
						interAL.setLocationRelativeTo(null);
						interAL.setVisible(true);
					}
					
				}
				else if (tipo_usuario.equals("administrador general")) {
					if (Admin_General.entrar(login, pwrod, lista_adminG)) {
						ArrayList<String> sedes = new ArrayList<String>();
						sedes.add("Usaquen");
						sedes.add("Chapinero");
						sedes.add("Secundaria");
						sedes.add("Principal");
						InterfazAdminGeneral interAG = new InterfazAdminGeneral(sistemaDeReservas.totalCarros(),sedes,sistemaDeReservas.getSeguros(),sistemaDeReservas);
						interAG.setLocationRelativeTo(null);
						interAG.setVisible(true);
					}
				}

			}
		};
		
		loginButton.addActionListener(listenLoginBtn);
		add(loginButton);
		
		
		registerButton = new JButton("registrarse");
		registerButton.setBounds(310, 255, 100, 45);
		add(registerButton);
		
	}


	
	public static void main(String[] args) {
		Interfazlog interfaz =new Interfazlog();
		interfaz.setLocationRelativeTo(null);
		interfaz.setVisible(true);		
		
	}

}
