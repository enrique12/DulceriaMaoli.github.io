package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.negocio.ControlAdministrarUsuario;
import com.tlamatini.persistencia.DAOUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaAdministrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldRepetirContrasena;
	private JTextField jtextFieldContrasena;
	private JTextField jtextFieldCorreo;
	private JTextField jtextFieldTelefono;
	private JTextField jtextFieldApellid;
	private JTextField jtextFieldNombre;
	private JTextField jtextFieldNick;
	
	private JButton btnNewButton = new JButton("Aceptar");
	private JButton btnNewButton_1 = new JButton("Cancelar");
	private JLabel lblUsuario = new JLabel("Usuario:");
	private JLabel lblAdmin = new JLabel();
	private JRadioButton jRadioButtonAdmin = new JRadioButton("Administrador");
	
	private Usuario user;
	private ControlAdministrarUsuario control;
	ConexionDB conexion;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaAdministrarUsuario(ControlAdministrarUsuario contro,ConexionDB con) {
		conexion=con;
		control=contro;
		lblAdmin.setText(control.getLoggedIn().getNick());
		setTitle("Tlamatini");
		
		//control = new ControlAdministrarUsuario(user,conexion);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Agregar Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 21, 399, 370);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nick:");
		lblNewLabel.setBounds(55, 41, 76, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(55, 75, 76, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(55, 109, 88, 14);
		panel.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(55, 147, 88, 14);
		panel.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(55, 183, 88, 14);
		panel.add(lblCorreo);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(55, 217, 88, 14);
		panel.add(lblContrasea);
		
		JLabel lblRepetirConsea = new JLabel("Repetir Conse\u00F1a:");
		lblRepetirConsea.setBounds(55, 251, 108, 14);
		panel.add(lblRepetirConsea);
		
		jtextFieldRepetirContrasena = new JTextField();
		jtextFieldRepetirContrasena.setBounds(161, 245, 169, 20);
		panel.add(jtextFieldRepetirContrasena);
		jtextFieldRepetirContrasena.setColumns(10);
		
		jtextFieldContrasena = new JTextField();
		jtextFieldContrasena.setBounds(161, 211, 169, 20);
		panel.add(jtextFieldContrasena);
		jtextFieldContrasena.setColumns(10);
		
		jtextFieldCorreo = new JTextField();
		jtextFieldCorreo.setBounds(161, 177, 169, 20);
		panel.add(jtextFieldCorreo);
		jtextFieldCorreo.setColumns(10);
		
		jtextFieldTelefono = new JTextField();
		jtextFieldTelefono.setBounds(161, 141, 169, 20);
		panel.add(jtextFieldTelefono);
		jtextFieldTelefono.setColumns(10);
		
		jtextFieldApellid = new JTextField();
		jtextFieldApellid.setBounds(161, 103, 169, 20);
		panel.add(jtextFieldApellid);
		jtextFieldApellid.setColumns(10);
		
		jtextFieldNombre = new JTextField();
		jtextFieldNombre.setBounds(161, 69, 169, 20);
		panel.add(jtextFieldNombre);
		jtextFieldNombre.setColumns(10);
		
		jtextFieldNick = new JTextField();
		jtextFieldNick.setBounds(161, 35, 169, 20);
		panel.add(jtextFieldNick);
		jtextFieldNick.setColumns(10);
		
	
		btnNewButton.setBounds(26, 320, 160, 39);
		panel.add(btnNewButton);

		btnNewButton_1.setBounds(196, 320, 160, 39);
		panel.add(btnNewButton_1);
		

		lblUsuario.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user.png"));
		lblUsuario.setBounds(217, 10, 98, 14);
		panel.add(lblUsuario);
		

		lblAdmin.setBounds(307, 10, 82, 14);
		panel.add(lblAdmin);
		

		jRadioButtonAdmin.setBounds(154, 290, 109, 23);
		panel.add(jRadioButtonAdmin);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario aux;
				boolean administrador=false;
				if(jtextFieldNick.getText().compareTo("")==0 || jtextFieldNombre.getText().compareTo("")==0 || jtextFieldTelefono.getText().compareTo("")==0||jtextFieldCorreo.getText().compareTo("")==0||jtextFieldContrasena.getText().compareTo("")==0||jtextFieldRepetirContrasena.getText().compareTo("")==0)
					JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
				else{
					if(jRadioButtonAdmin.isSelected()){
						administrador=true;
						}
					if(jtextFieldContrasena.getText().compareTo(jtextFieldRepetirContrasena.getText())!=0)
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
					else{
						aux = new Usuario(jtextFieldNick.getText(), jtextFieldNombre.getText(), jtextFieldApellid.getText(), jtextFieldContrasena.getText(), Integer.parseInt(jtextFieldTelefono.getText()), jtextFieldCorreo.getText(), administrador);
						if(control.agregarUsuario(aux)){
							JOptionPane.showMessageDialog(null, "Usuario Agregado");
							jtextFieldNick.setText("");
							jtextFieldNombre.setText("");
							jtextFieldApellid.setText("");
							jtextFieldContrasena.setText(""); 
							jtextFieldTelefono.setText("");
							jtextFieldCorreo.setText("");
							jRadioButtonAdmin.setSelected(false);
						}else
							JOptionPane.showMessageDialog(null, "Error: Usuario no agregado");
					}
				}
				
					
				
			}
		});
		
		jtextFieldTelefono.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
					}
				}
			});
	
	}
}
