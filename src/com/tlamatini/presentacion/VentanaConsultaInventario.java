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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.tlamatini.modelo.Producto;
import com.tlamatini.negocio.ControlConsultaInventario;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class VentanaConsultaInventario extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldClave;
	private JTable jtableProductos;
	private JButton jButtonAceptar = new JButton("Cerrar");
	private JSeparator separator = new JSeparator();
	private JLabel lblProductos = new JLabel("Productos:");
	private JButton jButtonBuscar = new JButton("Buscar");
	private JButton jButtonMostrar = new JButton("Mostrar Todo");
	private JLabel lblClave = new JLabel("Producto:");
	private JLabel lblAdmin = new JLabel();
	private JLabel lblUsuario = new JLabel("Usuario:");
	private JPanel panel = new JPanel();
	private JButton btnEliminar = new JButton("Eliminar");
	private Producto[] productos;
	private Producto borrar = new Producto();
	private final JScrollPane scrollPane = new JScrollPane();
	ControlConsultaInventario control;
	/**
	 * Create the frame.
	 * @param control 
	 */
	public VentanaConsultaInventario(final ControlConsultaInventario contr) {
		
		control=contr;
		lblAdmin.setText(control.getUser().getNick());
		setTitle("Tlamatini");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setAlwaysOnTop(true);
		setBounds(100, 100, 702, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Inventario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		

		lblClave.setBounds(22, 40, 88, 14);
		panel.add(lblClave);
		
		jtextFieldClave = new JTextField();
		jtextFieldClave.setBounds(120, 37, 346, 20);
		panel.add(jtextFieldClave);
		jtextFieldClave.setColumns(10);

		

		jButtonBuscar.setBounds(490, 36, 143, 23);
		panel.add(jButtonBuscar);
		
		jButtonMostrar.setBounds(490, 66, 143, 23);
		panel.add(jButtonMostrar);

		lblProductos.setBounds(10, 94, 105, 14);
		panel.add(lblProductos);
		scrollPane.setBounds(10, 117, 636, 224);
		
		panel.add(scrollPane);
		
		jtableProductos = new JTable();
		scrollPane.setViewportView(jtableProductos);
		jtableProductos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null}
			},
			new String[] {
				"Clave", "Nombre", "Descripcion", "Fecha de Caducidad", "Cantidad", "Precio"
			}
		));
		jtableProductos.getColumnModel().getColumn(1).setPreferredWidth(125);
		jtableProductos.getColumnModel().getColumn(2).setPreferredWidth(183);
		jtableProductos.getColumnModel().getColumn(3).setPreferredWidth(130);
		jtableProductos.getColumnModel().getColumn(4).setPreferredWidth(60);
		jtableProductos.getColumnModel().getColumn(5).setPreferredWidth(60);
		jtableProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		

		separator.setBounds(10, 77, 518, 2);
		panel.add(separator);
		jButtonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		
		
		jButtonAceptar.setBounds(518, 352, 115, 35);
		panel.add(jButtonAceptar);
		
		jButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//clearTable();
				String busca=jtextFieldClave.getText();
				productos=control.dameProductos(busca);
				actualiza(productos);
				/*for(int i=0;i<mostrar.length;i++){
					String precio=""+mostrar[i].getCostoUnitario()*1.15;
					BigDecimal dosDecimales=new BigDecimal(precio);
					dosDecimales=dosDecimales.setScale(2, BigDecimal.ROUND_HALF_UP);
					System.out.println(mostrar[i].getNombre());
					jtableProductos.setValueAt(mostrar[i].getIdProducto(), i, 0);
					jtableProductos.setValueAt(mostrar[i].getNombre(), i, 1);
					jtableProductos.setValueAt(mostrar[i].getDescripcion(), i, 2);
					jtableProductos.setValueAt(mostrar[i].getFechaCaducidad(), i, 3);
					jtableProductos.setValueAt(mostrar[i].getCantidad(), i, 4);
					jtableProductos.setValueAt("$ "+dosDecimales, i, 5);
				}*/
			}
		});
		
		jButtonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//clearTable();
				productos=control.dameProductos();
				actualiza(productos);
				/*for(int i=0;i<mostrar.length;i++){
					String precio=""+mostrar[i].getCostoUnitario()*1.15;
					BigDecimal dosDecimales=new BigDecimal(precio);
					dosDecimales=dosDecimales.setScale(2, BigDecimal.ROUND_HALF_UP);
					System.out.println(mostrar[i].getNombre());
					jtableProductos.setValueAt(mostrar[i].getIdProducto(), i, 0);
					jtableProductos.setValueAt(mostrar[i].getNombre(), i, 1);
					jtableProductos.setValueAt(mostrar[i].getDescripcion(), i, 2);
					jtableProductos.setValueAt(mostrar[i].getFechaCaducidad(), i, 3);
					jtableProductos.setValueAt(mostrar[i].getCantidad(), i, 4);
					jtableProductos.setValueAt("$ "+dosDecimales, i, 5);
				}*/
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) jtableProductos.getModel();
				if(jtableProductos.getSelectedRow()==-1)
					JOptionPane.showMessageDialog(null, "Debes seleccionar un campo");
				else{
				     if(control.borrarProducto(control.dameProducto((Integer)jtableProductos.getValueAt(jtableProductos.getSelectedRow(), 0))))
						//JOptionPane.showMessageDialog(null, "Se elimino el Producto");
				    	JOptionPane.showMessageDialog(lblAdmin, "  Se elimino el producto exitosamente", "EXITO", JOptionPane.DEFAULT_OPTION);
				    else
				    	//JOptionPane.showMessageDialog(null, "Error: No se elimino el producto");
				    	JOptionPane.showMessageDialog(lblAdmin, "  No se pudo eliminar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
				     
					model.removeRow(jtableProductos.getSelectedRow());
				}
			}
		});
		
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEliminar.setBounds(34, 352, 115, 35);
		panel.add(btnEliminar);
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	public void actualiza(Producto[] mostrar){
		int cont=0;
		clearTable();
		//mostrar=control.dameProductos();
		for(int i=0;i<mostrar.length;i++){
			if(productos[i].getActivo()==0){
				String precio=""+mostrar[i].getCostoUnitario()*1.15;
				BigDecimal dosDecimales=new BigDecimal(precio);
				dosDecimales=dosDecimales.setScale(2, BigDecimal.ROUND_HALF_UP);
				System.out.println(mostrar[i].getNombre());
				jtableProductos.setValueAt(mostrar[i].getIdProducto(), cont, 0);
				jtableProductos.setValueAt(mostrar[i].getNombre(), cont, 1);
				jtableProductos.setValueAt(mostrar[i].getDescripcion(), cont, 2);
				jtableProductos.setValueAt(mostrar[i].getFechaCaducidad(), cont, 3);
				jtableProductos.setValueAt(mostrar[i].getCantidad(), cont, 4);
				jtableProductos.setValueAt("$ "+dosDecimales, cont, 5);
				cont++;
			}
		}
		
	}
	public void clearTable() {
		   for (int i = 0; i < jtableProductos.getRowCount(); i++)
		      for(int j = 0; j < jtableProductos.getColumnCount(); j++)
		    	  jtableProductos.setValueAt("", i, j);
	}
		
}