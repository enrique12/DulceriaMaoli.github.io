package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window.Type;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.negocio.ControlCompra;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VentanaCompra extends JFrame {

	
	private VentanaPrincipal vPrincipal;
	private Usuario usuario;
	private File miDir=new File(".");
	
	private ControlCompra cCompra;
	
	private JPanel contentPane;
	private JButton jButtonEliminarProductos = new JButton("Eliminar Productos");
	private JButton jButtonConfirmarCompra = new JButton("Confirmar compra");
	private JLabel lblCantidad = new JLabel("Cantidad:");
	private JSeparator separator = new JSeparator();
	private JLabel lblNewLabel_1 = new JLabel("Total: $");
	private JLabel jLabelTotal = new JLabel("0.0");
	private JButton jButtonCancelar = new JButton("Cancelar");
	private JLabel lblResultados = new JLabel("Resultados:");
	private JButton jButtonAgregar = new JButton("Agregar");		
	private JLabel lblIdProducto = new JLabel("ID Producto: ");		
	private JPanel panel = new JPanel();
	private JTextField textFieldIdProducto;
	private JTextField textFieldCantidad;
	
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public VentanaCompra(ControlCompra control) {
		
		cCompra=control;
		cCompra.setVentana(this);
		
		this.vPrincipal = vPrincipal;
		usuario=control.getUsuario();
		cCompra.iniciaVenta();
		
		setType(Type.UTILITY);
		setTitle("Tlamatini");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 748, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Realizar Venta", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel.setBounds(10, 24, 730, 346);
		contentPane.add(panel);
		panel.setLayout(null);
		try {
			lblIdProducto.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/basket_add.png"));
		} catch (IOException e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
		}


		lblIdProducto.setBounds(10, 41, 98, 14);
		panel.add(lblIdProducto);
		jButtonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(valida(textFieldIdProducto.getText(),textFieldCantidad.getText())){
					//busca si existe el producto
					
					Producto producto = cCompra.agregaProductoACompra(Integer.parseInt(textFieldIdProducto.getText()),Integer.parseInt(textFieldCantidad.getText()));
					int nuevaCantidad = Integer.parseInt(textFieldCantidad.getText());
					
					existe:{
					if(producto != null){
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						//verifica si el producto ya esta en la lista
						for(int i = 0;i<model.getRowCount();i++){
							//si ya esta en la lista solo actualiza el numero de productos, el subtotal y el total
							if((Integer)model.getValueAt(i, 0)==producto.getIdProducto()){
								//en la tabla
								model.setValueAt(nuevaCantidad+(Integer)model.getValueAt(i,4 ), i, 4);
								//en la venta
								cCompra.actualizaCantidad(producto.getIdProducto(), nuevaCantidad);
								
								//calcula precio por unidad
								producto.setCantidad((Integer)model.getValueAt(i,4 ));						
								double precioUnidad =  cCompra.calculaPrecioUnidad(producto);
								model.setValueAt(precioUnidad, i, 3);
								model.setValueAt(precioUnidad*producto.getCantidad(), i, 5);
								
								//calcula total
								ArrayList<Double> subTotales = new ArrayList<Double>();
								for(int j = 0;j<model.getRowCount();j++){
									subTotales.add((Double)model.getValueAt(j, 5));
								}
								//muestra total
								jLabelTotal.setText(""+cCompra.calculaTotal(subTotales));
								
								
								break existe;
							}
							
						}
						producto = cCompra.agregaProductoACompra(Integer.parseInt(textFieldIdProducto.getText()),Integer.parseInt(textFieldCantidad.getText()));
						int siguienteFila =model.getRowCount();
						//calcula precio por unidad
						double precioUnidad =  cCompra.calculaPrecioUnidad(producto);
						
						model.insertRow(siguienteFila, new Object[]{producto.getIdProducto(),producto.getNombre(),producto.getTopeMayoreo(),precioUnidad,producto.getCantidad(),precioUnidad*producto.getCantidad()});
						
						//calcula total
						ArrayList<Double> subTotales = new ArrayList<Double>();
						for(int j = 0;j<model.getRowCount();j++){
							subTotales.add((Double)model.getValueAt(j, 5));
						}
						//muestra total
						jLabelTotal.setText(""+cCompra.calculaTotal(subTotales));
					}else{
						JOptionPane.showMessageDialog(null, "La clave de producto es incorrecta");
					}
						}
					
					
				}else{
					JOptionPane.showMessageDialog(null, "llenar todos los campos");
				}
				
			}
		});
		try {
			jButtonAgregar.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/cart_go.png"));
		} catch (IOException e7) {
			// TODO Auto-generated catch block
			e7.printStackTrace();
		}


		jButtonAgregar.setBounds(381, 37, 339, 50);
		panel.add(jButtonAgregar);
		try {
			lblResultados.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/basket.png"));
		} catch (IOException e6) {
			// TODO Auto-generated catch block
			e6.printStackTrace();
		}
		

		lblResultados.setBounds(10, 98, 120, 14);
		panel.add(lblResultados);
		jButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		jButtonCancelar.setBounds(592, 294, 127, 42);
		panel.add(jButtonCancelar);
		


		jLabelTotal.setBounds(653, 254, 46, 14);
		panel.add(jLabelTotal);
		try {
			lblNewLabel_1.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/money.png"));
		} catch (IOException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
	
		
		
		lblNewLabel_1.setBounds(565, 254, 78, 14);
		panel.add(lblNewLabel_1);
		
		
		separator.setBounds(10, 280, 710, 2);
		panel.add(separator);
		try {
			lblCantidad.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/cart_add.png"));
		} catch (IOException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
		
		
		lblCantidad.setBounds(10, 73, 88, 14);
		panel.add(lblCantidad);
		try {
			jButtonConfirmarCompra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(cCompra.agregaCompra()){
						JOptionPane.showMessageDialog(null, "compra realizada con exito");
						dispose();
						
					}else{
						JOptionPane.showMessageDialog(null, "error!! imposible realizar compra");
					}
					
					
				}
			});
			jButtonConfirmarCompra.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/basket_put.png"));
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		
		jButtonConfirmarCompra.setBounds(199, 293, 381, 42);
		panel.add(jButtonConfirmarCompra);
		try {
			jButtonEliminarProductos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int filaSeleccionada = table.getSelectedRow();
					if(filaSeleccionada!=-1){
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						//elimina producto de la venta
						cCompra.eliminaProducto((int)model.getValueAt(filaSeleccionada, 0));
						//elimina producto de la tabla
						model.removeRow(filaSeleccionada);
						
						//recalcula total
						
						ArrayList<Double> subTotales = new ArrayList<Double>();
						for(int j = 0;j<model.getRowCount();j++){
							subTotales.add((Double)model.getValueAt(j, 5));
						}
						//muestra total
						jLabelTotal.setText(""+cCompra.calculaTotal(subTotales));
					}else{
						JOptionPane.showMessageDialog(null, "selecciona un producto");
					}
					
				}
			});
			jButtonEliminarProductos.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/basket_remove.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		jButtonEliminarProductos.setBounds(10, 293, 179, 42);
		panel.add(jButtonEliminarProductos);
		
		textFieldIdProducto = new JTextField();
		textFieldIdProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(!("1234567890".contains(e.getKeyChar()+""))){
					e.consume();
				}
			}
		});
		textFieldIdProducto.setBounds(118, 38, 253, 20);
		panel.add(textFieldIdProducto);
		textFieldIdProducto.setColumns(10);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!("1234567890".contains(e.getKeyChar()+""))){
					e.consume();
				}
			}
		});
		textFieldCantidad.setBounds(108, 67, 263, 20);
		panel.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		try {
			lblUsuario.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/user.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblUsuario.setBounds(565, 12, 71, 14);
		panel.add(lblUsuario);
		
		JLabel jLabelUsuario = new JLabel(usuario.getNick());
		jLabelUsuario.setBounds(646, 12, 101, 14);
		panel.add(jLabelUsuario);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 117, 710, 125);
		
		
		
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idProducto", "nombre", "cantidad mayoreo", "costo", "cantidad", "subtotal"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Float.class, Integer.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(195);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(119);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(116);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(126);
		scrollPane.setViewportView(table);
		
	}
	
	private boolean valida(String text, String text2) {
		if(text.equals("") || text2.equals(""))
			return false;
		
		return true;
	}	
}
