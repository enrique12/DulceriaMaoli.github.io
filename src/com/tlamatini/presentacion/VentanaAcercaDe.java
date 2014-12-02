package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Canvas;
import javax.swing.ImageIcon;

public class VentanaAcercaDe extends JFrame {

	private JPanel contentPane;

	private JSeparator separator = new JSeparator();
	private JLabel lblNewLabel_3 = new JLabel("J. Alberto Ayala S\u00E1nchez.");
	private JLabel lblNewLabel_2 = new JLabel("L. Enrique Acosta Meza.\r\n");
	private JLabel lblNewLabel_1 = new JLabel("E. Mart\u00ED  De Jes\u00FAs Bautista.\r\n");
	private JLabel lblNewLabel = new JLabel("Victor H. Hern\u00E1ndez Garcia.\r\n");
	private JLabel lblCreadores = new JLabel("Creadores:");
	private JPanel panel_1 = new JPanel();
	private JLabel lblTlamatiniVer = new JLabel("Tlamatini Ver 1.0");
	private JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAcercaDe frame = new VentanaAcercaDe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAcercaDe() {
		setTitle("Tlamatini");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setBounds(100, 100, 364, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Acerca De", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 22, 328, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		

		lblTlamatiniVer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTlamatiniVer.setBounds(80, 11, 175, 42);
		panel.add(lblTlamatiniVer);
		

		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 94, 328, 161);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		

		lblCreadores.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user_gray.png"));
		lblCreadores.setBounds(10, 11, 120, 23);
		panel_1.add(lblCreadores);
		

		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\award_star_silver_3.png"));
		lblNewLabel.setBounds(49, 45, 201, 14);
		panel_1.add(lblNewLabel);
		

		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\award_star_silver_2.png"));
		lblNewLabel_1.setBounds(49, 70, 180, 14);
		panel_1.add(lblNewLabel_1);
		

		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\award_star_silver_3.png"));
		lblNewLabel_2.setBounds(49, 95, 190, 14);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\award_star_silver_2.png"));
		lblNewLabel_3.setBounds(49, 120, 180, 14);
		panel_1.add(lblNewLabel_3);
		
		
		separator.setBounds(20, 36, 292, 2);
		panel_1.add(separator);
	}
}
