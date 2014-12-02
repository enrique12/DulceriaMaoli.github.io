package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

import java.awt.Window.Type;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;

import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.negocio.ControlVentanaLogin;
import com.tlamatini.negocio.ControlVentanaPrincipal;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldNick;
	private TextField jtextFieldContrasena;
	private ControlVentanaLogin control;
	private ConexionDB conexion;

	public VentanaLogin(ControlVentanaLogin control,ConexionDB con) {
		conexion=con;
		this.control=control;
		File miDir=new File(".");
		setType(Type.UTILITY);
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage(miDir.getCanonicalPath()+"\\iconos\\user.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setTitle("Tlamatini");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 190);
		contentPane = new JPanel();
		contentPane.setToolTipText("Tlamatini");
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Ingresar al sistema", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		jtextFieldNick = new JTextField();
		jtextFieldNick.setBounds(117, 10, 129, 22);
		panel.add(jtextFieldNick);
		
		jtextFieldContrasena = new TextField();
		jtextFieldContrasena.setEchoChar('*');
		jtextFieldContrasena.setBounds(117, 46, 129, 22);
		panel.add(jtextFieldContrasena);
		
		final JButton jButtonAceptar = new JButton("Aceptar");
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manejoBotonAceptar();
			}
		});
		jButtonAceptar.setEnabled(false);
		jButtonAceptar.setBounds(10, 86, 114, 37);
		panel.add(jButtonAceptar);
		
		final JButton JButtonCancelar = new JButton("Cancelar");
		JButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JButtonCancelar.setBounds(134, 86, 109, 37);
		panel.add(JButtonCancelar);
		
		JLabel lblNick = new JLabel("Nick:");
		try {
			lblNick.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\user.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNick.setBounds(10, 18, 95, 14);
		panel.add(lblNick);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		try {
			lblContrasea.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\key.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblContrasea.setBounds(10, 54, 95, 14);
		panel.add(lblContrasea);
		contentPane.setLayout(gl_contentPane);
		

		jtextFieldContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(jtextFieldNick.getText().compareTo("")!=0||jtextFieldContrasena.getText().compareTo("")!=0)
					jButtonAceptar.setEnabled(true);
			}
		});
		

		jtextFieldNick.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(jtextFieldNick.getText().compareTo("")!=0||jtextFieldContrasena.getText().compareTo("")!=0)
					jButtonAceptar.setEnabled(false);
			}
		});
		
	}

	protected void manejoBotonAceptar() {
		if(jtextFieldNick.getText().compareTo("")==0||jtextFieldContrasena.getText().compareTo("")==0)
			JOptionPane.showMessageDialog (null, "Es necesario llenar los campos");
		else if(valida(jtextFieldContrasena))
				if(control.comparaDatos(jtextFieldNick.getText(), jtextFieldContrasena.getText())){
					ControlVentanaPrincipal principal=new ControlVentanaPrincipal(control.getUsuario(),conexion);
					this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				}
		}

	/**
	 * Este método valida si se cumple el RFN 1
	 * @param contrasena
	 * @return return true si se cumple else false
	 */
	
	private boolean valida(TextField contrasena) {
		// TODO Auto-generated method stub
		return contrasena.getText().length()<=20;
	}	
		
}
