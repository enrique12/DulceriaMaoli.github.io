package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.negocio.ControlAdministrarProveedor;
import com.tlamatini.negocio.ControlModificaProveedor;
import com.tlamatini.persistencia.DAOProveedor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaModificaProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldNombre;
	private JTextField jtextFieldTelefono;

	private Proveedor pro;
	private DAOProveedor daoproveedor;
	private ControlModificaProveedor control;
	private JButton buttonCancelar = new JButton("Cancelar");
	private JButton buttonModificar = new JButton("Modificar");
	private JLabel label_4 = new JLabel("Tel\u00E9fono:");
	private JTextArea jtextAreaDireccion = new JTextArea();
	private JLabel label_3= new JLabel();
	private JLabel label_2 = new JLabel("Usuario:");
	private JLabel label_1 = new JLabel("Nombre:");
	private JLabel label = new JLabel("Direcci\u00F3n:");
	private JPanel panel = new JPanel();
	private Proveedor provedor;
	ConexionDB conexion;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VentanaModificaProveedor(ControlModificaProveedor con,ConexionDB cone,Proveedor prove) {
		conexion=cone;
		provedor=prove;
		control=con;
		
		label_3.setText(control.getLoggedIn().getNick());
		setTitle("Tlamatini");
		setType(Type.UTILITY);

		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 283, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Modificar Proveedor", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel.setBounds(10, 21, 362, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		

		label.setBounds(10, 85, 74, 14);
		panel.add(label);
		
		label_1.setBounds(10, 54, 69, 14);
		panel.add(label_1);
		
		jtextFieldNombre = new JTextField();
		jtextFieldNombre.setColumns(10);
		jtextFieldNombre.setBounds(66, 51, 164, 20);
		panel.add(jtextFieldNombre);
		


		label_2.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user.png"));
		label_2.setBounds(86, 11, 90, 14);
		panel.add(label_2);
		

		label_3.setBounds(172, 11, 69, 14);
		panel.add(label_3);
		

		jtextAreaDireccion.setBounds(66, 83, 164, 58);
		panel.add(jtextAreaDireccion);
		

		label_4.setBounds(10, 152, 74, 14);
		panel.add(label_4);
		
		jtextFieldTelefono = new JTextField();
		jtextFieldTelefono.setColumns(10);
		jtextFieldTelefono.setBounds(66, 149, 164, 20);
		panel.add(jtextFieldTelefono);
		

		buttonModificar.setBounds(10, 188, 114, 29);
		panel.add(buttonModificar);
		

		buttonCancelar.setBounds(134, 188, 114, 29);
		panel.add(buttonCancelar);
		
		ingresaProvedor();
		buttonModificar.addActionListener(new ActionListener() {
			Proveedor aux=null;
			public void actionPerformed(ActionEvent arg0) {
				
				if(jtextFieldNombre.getText().compareTo("")==0 || jtextFieldTelefono.getText().compareTo("")==0){
					JOptionPane.showMessageDialog(null, "Debes llenar los campos");
				}else{
					provedor.setEmpresa(jtextFieldNombre.getText());
					provedor.setDireccion(jtextAreaDireccion.getText());
					provedor.setTelefono(Integer.parseInt(jtextFieldTelefono.getText()));
					
					//aux=new Proveedor(jtextFieldNombre.getText(), jtextAreaDireccion.getText(), Integer.parseInt(jtextFieldTelefono.getText()));
					control.modificar(provedor);
					JOptionPane.showMessageDialog(null, "Los Datos han sido actualizados");
					jtextFieldNombre.setText("");
					jtextAreaDireccion.setText("");
					jtextFieldTelefono.setText("");
				}
			}
		});
	
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
	public void ingresaProvedor(){
		jtextFieldNombre.setText(provedor.getEmpresa());
		jtextAreaDireccion.setText(provedor.getDireccion());
		jtextFieldTelefono.setText(String.valueOf(provedor.getTelefono()));
	}
}
