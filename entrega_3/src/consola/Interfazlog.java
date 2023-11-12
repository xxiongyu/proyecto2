package consola;

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

public class Interfazlog extends JFrame{
	private JLabel userNameL;
	private JLabel passwordL;
	private JLabel titulo;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton loginButton;
	private JButton registerButton;
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

		txtPassword = new JPasswordField(20);
		txtPassword.setBounds(195, 200, 220, 30);
		add(txtPassword);

		loginButton = new JButton("Entrar");
		loginButton.setBounds(200, 255, 100, 45);
		ActionListener listenLoginBtn=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				String us="kk";
				if(us=="kk") {
					SistemaDeReservas sistemaDeReservas= new SistemaDeReservas();
					try {
						sistemaDeReservas.cargarReservas();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sistemaDeReservas.setClienteLogeado(us);
					InterfazCliente interfazCli =new InterfazCliente(sistemaDeReservas.getIdsReservasDelCliente());
					interfazCli.setLocationRelativeTo(null);
					interfazCli.setVisible(true);
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
