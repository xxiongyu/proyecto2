package consola;

import javax.swing.JFrame;
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

public class InterfazRegistroCliente extends JFrame{
	
	private JTextField txtNombreCliente;
	
	private JTextField txtCelular;
	
	private JTextField txtContraseña;

	private JTextField txtUser;
	
	private JTextField txtFechaNacimiento;

	private JTextField txtNacionalidad;
	
	private JTextField txtNumeroLicencia;
	
	private JTextField txtPaisExpedicion;
	
	private JTextField txtVencimiento;
	
	private JButton btnregistrar;

	public InterfazRegistroCliente() {
		
		int tamX =700;
		int tamY=550;
		setTitle("ADMINISTRADOR LOCAL");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(tamX,tamY);
		//setLayout(new BorderLayout());
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setLayout(new BorderLayout());
		
		JPanel panelTitle= new JPanel();
		panelTitle.setLayout(new GridLayout(1,3));
		panelTitle.add(new Label());
		JLabel title=new JLabel("REGISTRARSE");
		title.setHorizontalAlignment(JLabel.CENTER);
		panelTitle.add(title);
		panelTitle.add(new Label());
		panelRegistro.add(panelTitle,BorderLayout.NORTH);
		
		
		JPanel panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(11,4));
		JLabel lbNombreCliente=new JLabel("Nombre:");
		txtNombreCliente=new JTextField(4);
		
		JLabel lbCelular=new JLabel("Celular:");
		txtCelular=new JTextField(4);
		
		JLabel lbFechaNacimiento=new JLabel("Fecha nacimiento:");
		txtFechaNacimiento=new JTextField(4);
		
		JLabel lbNacionalidad=new JLabel("Nacionalidad:");
		txtNacionalidad=new JTextField(4);
		
		JLabel lbNumeroLicencia=new JLabel("Numero licencia:");
		txtNumeroLicencia=new JTextField(4);
		
		JLabel lbPaisExpedicion=new JLabel("Pais expedicion:");
		txtPaisExpedicion=new JTextField(4);
		
		JLabel lbVencimiento=new JLabel("Vencimiento:");
		txtVencimiento=new JTextField(4);
		
		panelDatos.add(lbNombreCliente);
		panelDatos.add(txtNombreCliente);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		panelDatos.add(lbCelular);
		panelDatos.add(txtCelular);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		panelDatos.add(lbFechaNacimiento);
		panelDatos.add(txtFechaNacimiento);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		

		panelDatos.add(lbNacionalidad);
		panelDatos.add(txtNacionalidad);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		panelDatos.add(lbNumeroLicencia);
		panelDatos.add(txtNumeroLicencia);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		panelDatos.add(lbPaisExpedicion);
		panelDatos.add(txtPaisExpedicion);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		panelDatos.add(lbVencimiento);
		panelDatos.add(txtVencimiento);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		JLabel lbUser=new JLabel("User:");
		txtUser=new JTextField(4);
		panelDatos.add(lbUser);
		panelDatos.add(txtUser);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		JLabel lbContraseña=new JLabel("Contraseña:");
		txtContraseña=new JTextField(4);
		panelDatos.add(lbContraseña);
		panelDatos.add(txtContraseña);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		btnregistrar=new JButton("Registrarse");
		panelDatos.add(new JLabel());
		panelDatos.add(btnregistrar);
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		panelDatos.add(new JLabel());
		
		panelRegistro.add(panelDatos,BorderLayout.CENTER);
		
		add(panelRegistro);
		
		
		
	}
	public static void main(String[] args) {
		InterfazRegistroCliente interfazAdmin =new InterfazRegistroCliente();
		interfazAdmin.setLocationRelativeTo(null);
		interfazAdmin.setVisible(true);		
	}
}
