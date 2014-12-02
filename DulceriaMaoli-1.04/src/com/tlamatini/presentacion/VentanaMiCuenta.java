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

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.negocio.ControlMiCuenta;
import com.tlamatini.persistencia.DAOUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaMiCuenta extends JFrame {
	private Usuario user;
	private ControlMiCuenta control;
	private DAOUsuario daousario; 
	
	private JPanel contentPane;
	private JLabel jtextFieldNombre;
	private JLabel jtextFieldApellido;
	private JTextField jtextFieldTelefono;
	private JTextField jtextFieldCorreo;
	private JTextField jtextFieldContrasena;
	private JTextField jtextFieldRepetirContrasena;

	private JLabel jLabelAdmin;
	private JButton jbuttonAceptar = new JButton("Aceptar");
	private JButton jbuttonCancelar = new JButton("Cancelar");
	private JLabel label_6 = new JLabel("Repetir Conse\u00F1a:");
	private JLabel label_5 = new JLabel("Contrase\u00F1a:");
	private JLabel label_4 = new JLabel("Correo:");
	private JLabel label_3 = new JLabel("Apellido:");
	private JLabel label_2 = new JLabel("Telefono:");
	private JLabel label_1 = new JLabel("Nombre:");
	private JLabel label = new JLabel("Nick:");
	private JLabel jLabelUsuario;
	private JLabel lblUsuario = new JLabel("Usuario:");
	private JPanel panel = new JPanel();
	ConexionDB conexion;

	/**
	 * Create the frame.
	 * @param control 
	 */
	public VentanaMiCuenta(ControlMiCuenta control,ConexionDB con) {
		conexion=con;
		daousario = new DAOUsuario(conexion);
		setTitle("Tlamatini");
		this.control=control;
	
		user = daousario.buscaUsuario(control.dameUsuario());
		setType(Type.UTILITY);

		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 405, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Mi cuenta", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel.setBounds(10, 22, 371, 339);
		contentPane.add(panel);
		panel.setLayout(null);
		
		

		lblUsuario.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user.png"));
		lblUsuario.setBounds(243, 11, 82, 14);
		panel.add(lblUsuario);

		jLabelAdmin = new JLabel((String)control.dameUsuario());
		jLabelUsuario = new JLabel((String)control.dameUsuario());
		jLabelUsuario.setBounds(323, 11, 81, 14);
		panel.add(jLabelUsuario);
		

		label.setBounds(35, 36, 76, 14);
		panel.add(label);
		

		label_1.setBounds(35, 70, 76, 14);
		panel.add(label_1);
		
		jtextFieldNombre = new JLabel();
		//jtextFieldNombre.setColumns(10);
		jtextFieldNombre.setBounds(141, 64, 169, 20);
		panel.add(jtextFieldNombre);
		jtextFieldNombre.setText(user.getNombre());
		
		jtextFieldApellido = new JLabel();
		//jtextFieldApellido.setColumns(10);
		jtextFieldApellido.setBounds(141, 98, 169, 20);
		panel.add(jtextFieldApellido);
		jtextFieldApellido.setText(user.getApellido());
		
		jtextFieldTelefono = new JTextField();
		jtextFieldTelefono.setColumns(10);
		jtextFieldTelefono.setBounds(141, 136, 169, 20);
		panel.add(jtextFieldTelefono);
		jtextFieldTelefono.setText(""+user.getTelefono());

		label_2.setBounds(35, 142, 88, 14);
		panel.add(label_2);
		

		label_3.setBounds(35, 104, 88, 14);
		panel.add(label_3);
		

		label_4.setBounds(35, 178, 88, 14);
		panel.add(label_4);
		
		jtextFieldCorreo = new JTextField();
		jtextFieldCorreo.setColumns(10);
		jtextFieldCorreo.setBounds(141, 172, 169, 20);
		panel.add(jtextFieldCorreo);
		jtextFieldCorreo.setText(user.getCorreo());
		
		jtextFieldContrasena = new JTextField();
		jtextFieldContrasena.setColumns(10);
		jtextFieldContrasena.setBounds(141, 206, 169, 20);
		panel.add(jtextFieldContrasena);
		

		label_5.setBounds(35, 212, 88, 14);
		panel.add(label_5);
		

		label_6.setBounds(35, 246, 108, 14);
		panel.add(label_6);
		
		jtextFieldRepetirContrasena = new JTextField();
		jtextFieldRepetirContrasena.setColumns(10);
		jtextFieldRepetirContrasena.setBounds(141, 240, 169, 20);
		panel.add(jtextFieldRepetirContrasena);
		
		

		jbuttonCancelar.setBounds(194, 283, 160, 39);
		panel.add(jbuttonCancelar);
		
		
		jbuttonAceptar.setBounds(24, 283, 160, 39);
		panel.add(jbuttonAceptar);
		
		
		jLabelAdmin.setBounds(141, 36, 46, 14);
		panel.add(jLabelAdmin);
		
		jbuttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jbuttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario aux;
				if(jtextFieldNombre.getText().compareTo("")==0||jtextFieldApellido.getText().compareTo("")==0||jtextFieldTelefono.getText().compareTo("")==0||jtextFieldContrasena.getText().compareTo("")==0||jtextFieldRepetirContrasena.getText().compareTo("")==0)
					JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
				else{
					if(jtextFieldContrasena.getText().compareTo(jtextFieldRepetirContrasena.getText())!=0)
						JOptionPane.showMessageDialog(null, "Las contraseñas no coiciden");
					else{
						aux=new Usuario(user.getNick(), jtextFieldNombre.getText(), jtextFieldApellido.getText(), jtextFieldContrasena.getText(), Integer.parseInt(jtextFieldTelefono.getText()), jtextFieldCorreo.getText(), user.isEsAdministrador());
						if(daousario.modificaUsuario(aux)){
							JOptionPane.showMessageDialog(null, "Usuario Modificado");
						   jtextFieldCorreo.setText("");
						   jtextFieldContrasena.setText("");
						   jtextFieldTelefono.setText("");
						   jtextFieldRepetirContrasena.setText("");
						}else
							JOptionPane.showMessageDialog(null, "Error: Usuario no modificado");
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
