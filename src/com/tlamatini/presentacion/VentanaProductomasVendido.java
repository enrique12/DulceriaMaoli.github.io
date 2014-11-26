package com.tlamatini.presentacion;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.tlamatini.modelo.Producto;
import com.tlamatini.negocio.ControlConsultaInventario;
import com.tlamatini.negocio.ControlProductomasVendido;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaProductomasVendido extends JFrame {

	private JPanel contentPane;
	private JTable jtableProductos;
	private JButton jButtonAceptar = new JButton("Cerrar");
	private JSeparator separator = new JSeparator();
	private JLabel lblProductos = new JLabel("Productos:");
	private JButton jButtonBuscar = new JButton("Buscar");
	private JLabel lblClave = new JLabel("Mes:");
	private JLabel lblAdmin = new JLabel();
	private JLabel lblUsuario = new JLabel("Usuario:");
	private JPanel panel = new JPanel();
	private Producto[] mostrar;
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Create the frame.
	 * @param control 
	 */
	public VentanaProductomasVendido(final ControlProductomasVendido control) { // aqui
		lblAdmin.setText(control.getUser().getNick());
		setTitle("Scrum Sprint 1");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setAlwaysOnTop(true);
		setBounds(100, 100, 702, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Producto más Vendido", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		panel.setBounds(20, 23, 656, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		

		lblUsuario.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user.png"));
		lblUsuario.setBounds(468, 11, 97, 14);
		panel.add(lblUsuario);
		

		lblAdmin.setBounds(560, 11, 73, 14);
		panel.add(lblAdmin);
		

		lblClave.setBounds(27, 40, 88, 14);
		panel.add(lblClave);

		

		jButtonBuscar.setBounds(490, 36, 143, 23);
		panel.add(jButtonBuscar);
		

		lblProductos.setBounds(10, 94, 105, 14);
		panel.add(lblProductos);
		scrollPane.setBounds(10, 117, 636, 224);
		
		panel.add(scrollPane);
		
		jtableProductos = new JTable();
		scrollPane.setViewportView(jtableProductos);
		jtableProductos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Producto", "Cantidad"
			}
		));
		jtableProductos.getColumnModel().getColumn(0).setPreferredWidth(125);
		jtableProductos.getColumnModel().getColumn(1).setPreferredWidth(183);
		//jtableProductos.getColumnModel().getColumn(4).setPreferredWidth(60);
		//jtableProductos.getColumnModel().getColumn(5).setPreferredWidth(60);
		//jtableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		

		separator.setBounds(10, 77, 518, 2);
		panel.add(separator);
		jButtonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		
		
		jButtonAceptar.setBounds(518, 352, 115, 35);
		panel.add(jButtonAceptar);
		
		final JComboBox comboBoxMes = new JComboBox();
		
		comboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"---------->", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBoxMes.setMaximumRowCount(12);
		comboBoxMes.setBounds(125, 37, 88, 20);
		panel.add(comboBoxMes);
		
		jButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearTable();
				//String busca=jtextFieldClave.getText();
				mostrar=control.masVendido(comboBoxMes.getSelectedItem()); //aqui
				for(int i=0;i<mostrar.length;i++){
					/*String precio=""+mostrar[i].getCostoUnitario()*1.15;
					BigDecimal dosDecimales=new BigDecimal(precio);
					dosDecimales=dosDecimales.setScale(2, BigDecimal.ROUND_HALF_UP);
					System.out.println(mostrar[i].getNombre());*/
					//jtableProductos.setValueAt(mostrar[i].getIdProducto(), i, 0);
					jtableProductos.setValueAt(mostrar[i].getNombre(), i, 0);
					jtableProductos.setValueAt(mostrar[i].getNumProducto(), i, 1);
			//		jtableProductos.setValueAt(mostrar[i].getFechaCaducidad(), i, 3);
			//		jtableProductos.setValueAt(mostrar[i].getCantidad(), i, 4);
			//		jtableProductos.setValueAt("$ "+dosDecimales, i, 5);
				}
			}
		});
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	public void clearTable() {
		   for (int i = 0; i < jtableProductos.getRowCount(); i++)
		      for(int j = 0; j < jtableProductos.getColumnCount(); j++)
		    	  jtableProductos.setValueAt("", i, j);
	}
}