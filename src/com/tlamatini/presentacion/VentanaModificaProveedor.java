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
	
	private JSeparator separator = new JSeparator();
	private JButton jButtonBuscar = new JButton("Buscar");
	private JButton buttonCancelar = new JButton("Cancelar");
	private JButton buttonModificar = new JButton("Modificar");
	private JLabel label_4 = new JLabel("Tel\u00E9fono:");
	private JTextArea jtextAreaDireccion = new JTextArea();
	private JLabel label_3 = new JLabel("Admin");
	private JLabel label_2 = new JLabel("Usuario:");
	private JLabel label_1 = new JLabel("Nombre:");
	private JLabel label = new JLabel("Direcci\u00F3n:");
	private JPanel panel = new JPanel();
	ConexionDB conexion;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VentanaModificaProveedor(ConexionDB con) {
		conexion=con;
		daoproveedor = new DAOProveedor(conexion);
		control = new ControlModificaProveedor(daoproveedor,conexion);
		setTitle("Tlamatini");
		setType(Type.UTILITY);

		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Modificar Proveedor", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel.setBounds(10, 21, 362, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		

		label.setBounds(50, 131, 74, 14);
		panel.add(label);
		
		label_1.setBounds(29, 54, 69, 14);
		panel.add(label_1);
		
		jtextFieldNombre = new JTextField();
		jtextFieldNombre.setColumns(10);
		jtextFieldNombre.setBounds(94, 51, 164, 20);
		panel.add(jtextFieldNombre);
		


		label_2.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user.png"));
		label_2.setBounds(211, 11, 90, 14);
		panel.add(label_2);
		

		label_3.setBounds(283, 11, 69, 14);
		panel.add(label_3);
		

		jtextAreaDireccion.setBounds(113, 126, 164, 58);
		panel.add(jtextAreaDireccion);
		

		label_4.setBounds(50, 198, 74, 14);
		panel.add(label_4);
		
		jtextFieldTelefono = new JTextField();
		jtextFieldTelefono.setColumns(10);
		jtextFieldTelefono.setBounds(113, 195, 164, 20);
		panel.add(jtextFieldTelefono);
		

		buttonModificar.setBounds(63, 254, 114, 29);
		panel.add(buttonModificar);
		

		buttonCancelar.setBounds(187, 254, 114, 29);
		panel.add(buttonCancelar);
		
		jButtonBuscar.setBounds(263, 50, 89, 23);
		panel.add(jButtonBuscar);
		
		
		separator.setBounds(10, 100, 342, 2);
		panel.add(separator);
		
		buttonModificar.addActionListener(new ActionListener() {
			Proveedor aux=null;
			public void actionPerformed(ActionEvent arg0) {
				if(jtextFieldNombre.getText().compareTo("")==0 || jtextFieldTelefono.getText().compareTo("")==0)
					JOptionPane.showMessageDialog(null, "Debes llenar los campos");
				else
					aux=new Proveedor(jtextFieldNombre.getText(), jtextAreaDireccion.getText(), Integer.parseInt(jtextFieldTelefono.getText()));
					control.modificar(aux);
					JOptionPane.showMessageDialog(null, "Los Datos han sido actualizados");
					jtextFieldNombre.setText("");
					jtextAreaDireccion.setText("");
					jtextFieldTelefono.setText("");
			}
		});
	
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	
		jButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedor aux=null;
				if(jtextFieldNombre.getText().compareTo("")==0)
					JOptionPane.showMessageDialog(null, "Debes llenar el campo");
				else{
					String direccion = jtextFieldNombre.getText();
					aux=control.busca(direccion);
										
					if(aux!=null){
						jtextAreaDireccion.setText((String)aux.getDireccion());
						jtextFieldTelefono.setText(""+aux.getTelefono());
					}else{
						JOptionPane.showMessageDialog(null, "No existe el provedor");
						jtextFieldNombre.setText("");
						jtextAreaDireccion.setText("");
						jtextFieldTelefono.setText("");
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
