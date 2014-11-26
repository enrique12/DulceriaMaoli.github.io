package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import com.tlamatini.modelo.Compra;
import com.tlamatini.modelo.Venta;
import com.tlamatini.negocio.ControlEstadoFinanciero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaEstadoFinanciero extends JFrame {

	
	private JPanel contentPane;
	private JTextField jtextFieldAnioInicio;
	private JTextField jtextFieldAnioFinal;
	private File miDir=new File(".");

	private JButton jButtonAceptar = new JButton("Aceptar");
	private JLabel jlabel_salidaGanacia = new JLabel("0.0");
	private JLabel lblNewLabel_Ganacia = new JLabel("Ganancia Neta:");
	
	private JLabel lblNewLabel = new JLabel("Historial:");
	private JSeparator separator = new JSeparator();
	private JButton jButtonBuscar = new JButton("Buscar");
	private JComboBox jcomboBoxMesFinal = new JComboBox();
	private JComboBox jcomboBoxMesInicio = new JComboBox();
	private JComboBox jcomboBoxDiaFinal = new JComboBox();
	private JComboBox jcomboBoxDiaInicio = new JComboBox();
	private JLabel lblFecha = new JLabel("Fecha final:");
	private JLabel lblFechaInicio = new JLabel("Fecha inicio:");
	private JLabel lblAdmin = new JLabel("Admin");
	private JLabel jLabelUsuario = new JLabel("Usuario:");
	private JPanel panel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table = new JTable();

	/**
	 * Create the frame.
	 */
	public VentanaEstadoFinanciero(final ControlEstadoFinanciero control) {
		setType(Type.UTILITY);
		setTitle("Tlamatini");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Estado Financiero", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel.setBounds(10, 21, 414, 408);
		contentPane.add(panel);
		panel.setLayout(null);
		

		try {
			jLabelUsuario.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/iconos/user.png"));
		} catch (IOException e6) {
			// TODO Auto-generated catch block
			e6.printStackTrace();
		}
		jLabelUsuario.setBounds(264, 11, 82, 14);
		panel.add(jLabelUsuario);
		

		lblAdmin.setBounds(331, 11, 73, 14);
		panel.add(lblAdmin);
		

		try {
			lblFechaInicio.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/calendar.png"));
		} catch (IOException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
		lblFechaInicio.setBounds(10, 39, 94, 14);
		panel.add(lblFechaInicio);
		

		try {
			lblFecha.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/calendar.png"));
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		lblFecha.setBounds(10, 67, 94, 14);
		panel.add(lblFecha);
		

		jcomboBoxDiaInicio.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jcomboBoxDiaInicio.setBounds(114, 36, 44, 17);
		panel.add(jcomboBoxDiaInicio);


		jcomboBoxDiaFinal.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jcomboBoxDiaFinal.setBounds(114, 64, 44, 20);
		panel.add(jcomboBoxDiaFinal);


		jcomboBoxMesInicio.setModel(new DefaultComboBoxModel(new String[] {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"}));
		jcomboBoxMesInicio.setBounds(168, 36, 55, 20);
		panel.add(jcomboBoxMesInicio);
		

		jcomboBoxMesFinal.setModel(new DefaultComboBoxModel(new String[] {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"}));
		jcomboBoxMesFinal.setBounds(168, 64, 55, 20);
		panel.add(jcomboBoxMesFinal);
		
		jtextFieldAnioInicio = new JTextField();
		jtextFieldAnioInicio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				if(!"1234567890".contains(""+arg0.getKeyChar())){
					arg0.consume();
				}
			}
		});
		jtextFieldAnioInicio.setBounds(233, 36, 55, 20);
		panel.add(jtextFieldAnioInicio);
		jtextFieldAnioInicio.setColumns(10);
		
		jtextFieldAnioFinal = new JTextField();
		jtextFieldAnioFinal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!"1234567890".contains(""+e.getKeyChar())){
					e.consume();
				}
			}
		});
		jtextFieldAnioFinal.setBounds(233, 64, 55, 20);
		panel.add(jtextFieldAnioFinal);
		jtextFieldAnioFinal.setColumns(10);
		

		
		jButtonBuscar.setBounds(304, 39, 100, 32);
		panel.add(jButtonBuscar);
		

		separator.setBounds(10, 103, 394, 2);
		panel.add(separator);
		

		try {
			lblNewLabel.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/chart_bar.png"));
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		lblNewLabel.setBounds(10, 116, 82, 14);
		panel.add(lblNewLabel);
		

		try {
			lblNewLabel_Ganacia.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/money_add.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		lblNewLabel_Ganacia.setBounds(10, 344, 140, 14);
		panel.add(lblNewLabel_Ganacia);
		

		jlabel_salidaGanacia.setBounds(145, 344, 93, 14);
		panel.add(jlabel_salidaGanacia);
		
		

		jButtonAceptar.setBounds(284, 364, 100, 32);
		panel.add(jButtonAceptar);
		scrollPane.setBounds(10, 142, 394, 190);
		
		panel.add(scrollPane);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"fecha", "folio", "tipo de operacion", "importe"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		table.getColumnModel().getColumn(2).setPreferredWidth(151);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		
		scrollPane.setViewportView(table);
		
		jButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				//valida que los campos esten llenos
				if(jtextFieldAnioInicio.getText().equals("")||jtextFieldAnioFinal.getText().equals("")){
					JOptionPane.showMessageDialog(null, "llena los campos de anio");
				}
				//obtiene las fechas de inicio y fin
				
				Date fechaInicio = new Date(Integer.parseInt(jtextFieldAnioInicio.getText())-1900,jcomboBoxMesInicio.getSelectedIndex(),jcomboBoxDiaInicio.getSelectedIndex()+1);
				Date fechaFinal = new Date(Integer.parseInt(jtextFieldAnioFinal.getText())-1900,jcomboBoxMesFinal.getSelectedIndex(),jcomboBoxDiaFinal.getSelectedIndex()+1);
				
				//pide las ventas y compras realizadas en el intervalo de fechas
				Compra [] listaCompras = control.dameCompras(fechaInicio, fechaFinal);
				Venta[] listaVentas = control.dameVentas(fechaInicio, fechaFinal);
				
				//muestra listaCompras y lista Ventas
				
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				for(int i= model.getRowCount()-1; i>-1;i--){
					model.removeRow(i);
				}
				
				for(int i = 0;i<listaCompras.length;i++){
					model.insertRow(i, new Object[]{listaCompras[i].getFechaOperacion(),listaCompras[i].getFolio(),"COMPRA",listaCompras[i].getImporte()});
				}
				for(int i = 0;i<listaVentas.length;i++){
					model.insertRow(i, new Object[]{listaVentas[i].getFechaOperacion(),listaVentas[i].getFolio(),"VENTA",listaVentas[i].getImporte()});
				}
				
				//calcula ganancia neta
				
				ArrayList<Double> listaImporteVentas = new ArrayList<Double>();
				ArrayList<Double> listaImporteCompras = new ArrayList<Double>();
				
				for(int i = 0; i<listaCompras.length;i++){
					listaImporteCompras.add(listaCompras[i].getImporte());
				}	
				for(int i = 0; i<listaVentas.length;i++){
					listaImporteVentas.add(listaVentas[i].getImporte());
				}
				
				//muestra ganacia neta
				jlabel_salidaGanacia.setText(""+control.calculaGanancia(listaImporteVentas, listaImporteCompras));
				
			}
		});
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
}
