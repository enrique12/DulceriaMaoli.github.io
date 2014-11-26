package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.negocio.ControlAdministrarProveedor;
import com.tlamatini.negocio.ControlAgregaProveedor;
import com.tlamatini.presentacion.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaAgregarProveedor extends JFrame {
	private Usuario usuario;
	private Proveedor proveedor;
	private ControlAgregaProveedor control;
	ConexionDB conexion;

	private JPanel contentPane;
	private JTextField jtextFieldEmpresa;
	private JTextField jtextFieldTelefono;

	private JButton jButtonCancelar = new JButton("Cancelar");
	private JButton jbuttonAceptar = new JButton("Aceptar");
	private JTextArea jtextAreaDireccion = new JTextArea();
	private JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
	private JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
	private JLabel lblEmpresa = new JLabel("Empresa:");
	private JLabel jLabelUsuario;
	private JLabel lblUsuario = new JLabel("Usuario:");
	private JPanel panel = new JPanel();
	
    
	
	

	/**
	 * Create the frame.
	 */
	public VentanaAgregarProveedor(ConexionDB con) {
		conexion=con;
		control = new ControlAgregaProveedor(usuario,conexion);
		setTitle("Tlamatini");
		setType(Type.UTILITY);

		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 368, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Agregar Proveedor", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel.setBounds(10, 21, 331, 281);
		contentPane.add(panel);
		panel.setLayout(null);
		

		lblUsuario.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user.png"));
		lblUsuario.setBounds(195, 11, 90, 14);
		panel.add(lblUsuario);
		jLabelUsuario= new JLabel("Admin");
		jLabelUsuario.setBounds(267, 11, 69, 14);
		panel.add(jLabelUsuario);

		lblEmpresa.setBounds(47, 79, 74, 14);
		panel.add(lblEmpresa);
		

		lblDireccin.setBounds(47, 115, 74, 14);
		panel.add(lblDireccin);
		

		lblTelfono.setBounds(47, 182, 74, 14);
		panel.add(lblTelfono);
		
		jtextFieldEmpresa = new JTextField();
		jtextFieldEmpresa.setBounds(110, 79, 164, 20);
		panel.add(jtextFieldEmpresa);
		jtextFieldEmpresa.setColumns(10);
		
		jtextAreaDireccion.setBounds(110, 110, 164, 58);
		panel.add(jtextAreaDireccion);
		
		jtextFieldTelefono = new JTextField();
		jtextFieldTelefono.setBounds(110, 179, 164, 20);
		panel.add(jtextFieldTelefono);
		jtextFieldTelefono.setColumns(10);
		
		
		
		jbuttonAceptar.setBounds(60, 222, 114, 29);
		panel.add(jbuttonAceptar);
		jbuttonAceptar.setEnabled(false);
		
		
		jButtonCancelar.setBounds(184, 222, 114, 29);
		panel.add(jButtonCancelar);
		
		jbuttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtextFieldEmpresa.getText().compareTo("")==0||jtextFieldTelefono.getText().compareTo("")==0||jtextAreaDireccion.getText().compareTo("")==0)
					JOptionPane.showMessageDialog(null, "Faltan campos por llenar");
				//proveedor = new Proveedor(, , ));
				else{
					String empresa=(jtextFieldEmpresa.getText());
					String direccion=(jtextAreaDireccion.getText());
					int telefono =(Integer.parseInt(jtextFieldTelefono.getText()));
					//control.agregarProveedor(proveedor);
					proveedor = new Proveedor(empresa, direccion, telefono);
					if(control.agregarProveedor(proveedor)){
						jtextFieldEmpresa.setText("");
						jtextAreaDireccion.setText("");
						jtextFieldTelefono.setText("");
						JOptionPane.showMessageDialog(null, "Proveedor Agregado");
						}else
							JOptionPane.showMessageDialog(null, "Error: Proveedor no agregado");
					}
			}
		});
		jButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		jtextFieldEmpresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(jtextFieldEmpresa.getText().compareTo("")!=0||jtextFieldTelefono.getText().compareTo("")!=0 || jtextAreaDireccion.getText().compareTo("")!=0)
					jbuttonAceptar.setEnabled(true);
			}
		});
		
		jtextFieldTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(jtextFieldEmpresa.getText().compareTo("")!=0||jtextFieldTelefono.getText().compareTo("")!=0 || jtextAreaDireccion.getText().compareTo("")!=0)
					jbuttonAceptar.setEnabled(true);
				
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
		

		
		jtextAreaDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(jtextFieldEmpresa.getText().compareTo("")!=0||jtextFieldTelefono.getText().compareTo("")!=0 || jtextAreaDireccion.getText().compareTo("")!=0)
					jbuttonAceptar.setEnabled(true);

			}
		});
		
	}
}
