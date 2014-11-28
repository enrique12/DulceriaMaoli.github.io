package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

import javax.swing.ImageIcon;

import com.tlamatini.modelo.Producto;
import com.tlamatini.negocio.ControlAgregarProducto;
public class VentanaAgregarProducto extends JFrame {
	Producto pExistente;
	private ControlAgregarProducto control;
	private JPanel contentPane;
	private JTextField jtextFieldClave;
	private JTextField jtextFieldNombre;
	private JTextField jtextFieldCosto;
	private JTextField jtextFieldAnio;
	private JTextField jtextFieldCantidad;
	private JTextField jtextFieldClavePexistente;
	private JTextField jtextFieldCantidadPexistente;
	private JTextField jtextFieldAnioPexistente;
	private JTextField jtextFieldCostoPexistente;
	private JLabel lblCostoUnitario_1 = new JLabel("Costo unitario: $");
	private JLabel label_6 = new JLabel("Cantidad:");
	private JLabel label_4 = new JLabel("Fecha de Caducidad:");

	private JComboBox jcomboBoxMesPexistente = new JComboBox();
	private JComboBox jcomboBoxDiaPexistente = new JComboBox();
	private JComboBox jcomboBoxProvedor = new JComboBox();
	
	
	private JButton jbuttonCancelarPexistente = new JButton("Cancelar");
	private JButton jbuttonAgregarProductoPexistente = new JButton("Agregar Producto");
	private JSeparator separator_1 = new JSeparator();
	private JLabel jlabelCantidadPexistente = new JLabel("");
	private JLabel jlabelCostoUnitarioPexistente = new JLabel("");
	private JLabel jlabelNombrePexistente = new JLabel("");
	private JLabel label_5 = new JLabel("Cantidad:");
	private JLabel label_3 = new JLabel("Costo unitario: $");
	private JLabel label_1 = new JLabel("Nombre:");
	private JSeparator separator = new JSeparator();
	private JButton jButtonBuscarPexitente = new JButton("Buscar");
	
	private JLabel lblClaveDeProducto = new JLabel("Clave de producto:");
	private JPanel panel_1 = new JPanel();
	private JComboBox jcomboBoxMes = new JComboBox();
	private JLayeredPane layeredPane_2 = new JLayeredPane();
	private JComboBox jcomboBoxDia = new JComboBox();
	private JButton jButtonCancelar = new JButton("Cancelar");
	private JButton jButtonAgregarProductoSolo = new JButton("Agregar Producto");
	private JTextArea jtextAreaDescripcion = new JTextArea();
	private JLabel lblNewLabel_1 = new JLabel("Cantidad:");
	private JLabel lblFechaDeCaducidad = new JLabel("Fecha de Caducidad:");
	private JLabel lblCostoUnitario = new JLabel("Costo unitario: $");
	private JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");		
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblNewLabel = new JLabel("Clave: ");
	private JPanel panel = new JPanel();
	private JLayeredPane layeredPane_1 = new JLayeredPane();
	private JLayeredPane layeredPane = new JLayeredPane();
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	
	LinkedList listaProvedor=new LinkedList();
	
	/**
	 * Create the frame.
	 * @param controlAgregarProducto 
	 */
	public VentanaAgregarProducto(final ControlAgregarProducto con) {
		
		setTitle("Tlamatini");
		this.control=con;
		listaProvedor=control.dameProvedor();
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "A\u00F1adir Producto", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		tabbedPane.setBounds(10, 24, 424, 421);
		contentPane.add(tabbedPane);
		

		tabbedPane.addTab("Producto Nuevo", new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\package_add.png"), layeredPane, null);
		layeredPane.setLayout(null);
		
		layeredPane_1.setBounds(122, 50, 1, 1);
		layeredPane.add(layeredPane_1);



		panel.setBounds(0, 0, 417, 393);
		layeredPane.add(panel);
		panel.setLayout(null);


		lblNewLabel.setBounds(44, 29, 46, 14);
		panel.add(lblNewLabel);

		lblNombre.setBounds(44, 58, 88, 14);
		panel.add(lblNombre);

		lblDescripcin.setBounds(44, 147, 88, 14);
		panel.add(lblDescripcin);

		
		lblCostoUnitario.setBounds(44, 221, 102, 14);
		panel.add(lblCostoUnitario);

		


		lblFechaDeCaducidad.setBounds(44, 252, 130, 14);
		panel.add(lblFechaDeCaducidad);
		
		
		

		lblNewLabel_1.setBounds(44, 294, 102, 14);
		panel.add(lblNewLabel_1);
		
		jtextFieldClave = new JTextField();
		jtextFieldClave.setBounds(169, 26, 185, 20);
		panel.add(jtextFieldClave);
		jtextFieldClave.setColumns(10);
		
		
		
		jtextFieldNombre = new JTextField();
		jtextFieldNombre.setBounds(169, 55, 185, 20);
		panel.add(jtextFieldNombre);
		jtextFieldNombre.setColumns(10);
		
		

		jtextAreaDescripcion.setBounds(169, 142, 185, 65);
		panel.add(jtextAreaDescripcion);
		
		jtextFieldCosto = new JTextField();
		jtextFieldCosto.setBounds(169, 218, 185, 20);
		panel.add(jtextFieldCosto);
		jtextFieldCosto.setColumns(10);
		
		jtextFieldAnio = new JTextField();
		jtextFieldAnio.setBounds(293, 249, 61, 20);
		panel.add(jtextFieldAnio);
		jtextFieldAnio.setColumns(10);
		

		jtextFieldCantidad = new JTextField();
		jtextFieldCantidad.setBounds(169, 291, 185, 20);
		panel.add(jtextFieldCantidad);
		jtextFieldCantidad.setColumns(10);
		jButtonAgregarProductoSolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
								
				if( (jtextFieldClave.getText()=="" | jtextFieldNombre.getText()=="" | jtextFieldCosto.getText()=="" | 
					jtextFieldAnio.getText()=="" |  jtextFieldCantidad.getText()=="")){
					

					JOptionPane.showMessageDialog(null, "Llena todos los campos");
				}
				else{

					int year = Integer.parseInt(jtextFieldAnio.getText());
					int month = jcomboBoxMes.getSelectedIndex();
					int day = jcomboBoxDia.getSelectedIndex()+1;
					
					Calendar calendar = Calendar.getInstance();
					calendar.set(Calendar.YEAR,year);
					calendar.set(Calendar.MONTH,month);
					int numeroDias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					
					
					//valida si es un fecha correcta
					if(numeroDias< day){
						JOptionPane.showMessageDialog(null, "fecha invalida");
					}else{
						
						Date fecha = new Date(year-1900,month,day);
						int id_empresa = 0;
						id_empresa=control.dameId_empresa(jcomboBoxProvedor.getSelectedItem());
						System.out.println("Soy el id_empresa: "+id_empresa+" de la empresa: "+jcomboBoxProvedor.getSelectedItem());
						Producto productoAux = new Producto(Integer.parseInt(jtextFieldClave.getText()),id_empresa,jtextFieldNombre.getText(), 
								jtextAreaDescripcion.getText(),Double.parseDouble(jtextFieldCosto.getText()),fecha,
								Integer.parseInt(jtextFieldCantidad.getText()),50,0);
						System.out.println(productoAux.getNombre()+" "+productoAux.getCostoUnitario());
						
						if(control.productoEsNuevo(productoAux.getIdProducto()))
							control.agregaProductoNuevo(productoAux);
						else
							JOptionPane.showMessageDialog(null, "Producto ya existe");
					}
				}
			}
		});
		
		

		jButtonAgregarProductoSolo.setBounds(44, 337, 140, 45);
		panel.add(jButtonAgregarProductoSolo);
		

		jButtonCancelar.setBounds(207, 336, 150, 47);
		panel.add(jButtonCancelar);


		jcomboBoxDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jcomboBoxDia.setBounds(169, 249, 46, 20);
		panel.add(jcomboBoxDia);
		

		jcomboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV ", "DIC"}));
		jcomboBoxMes.setBounds(225, 249, 58, 20);
		panel.add(jcomboBoxMes);
		
		JLabel lblProvedor = new JLabel("Provedor:");
		lblProvedor.setBounds(44, 91, 61, 14);
		panel.add(lblProvedor);
		
		
		//String lista[];
		
		/*String lista[]=control.dameProvedor();*/

		 
		for(int i=0;i<listaProvedor.size();i++){
			jcomboBoxProvedor.addItem(listaProvedor.get(i));
		}
		jcomboBoxProvedor.setBounds(169, 88, 185, 20);
		panel.add(jcomboBoxProvedor);
		
		

		tabbedPane.addTab("Producto Existente", new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\package_go.png"), layeredPane_2, null);
		
		
		

		panel_1.setBounds(0, 0, 419, 393);
		layeredPane_2.add(panel_1);
		panel_1.setLayout(null);
		lblClaveDeProducto.setBounds(10, 23, 105, 14);
		panel_1.add(lblClaveDeProducto);
		
		

		jtextFieldClavePexistente = new JTextField();
		jtextFieldClavePexistente.setBounds(125, 20, 164, 20);
		panel_1.add(jtextFieldClavePexistente);
		jtextFieldClavePexistente.setColumns(10);
		jButtonBuscarPexitente.setBounds(299, 19, 110, 23);
		jButtonBuscarPexitente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pExistente=control.buscaProducto(Integer.parseInt(jtextFieldClavePexistente.getText()));
				if(pExistente==null)
					JOptionPane.showMessageDialog(null, "No existe ese Producto");
				else{

					jlabelCantidadPexistente.setText(""+pExistente.getCantidad());
					jlabelCostoUnitarioPexistente.setText(""+pExistente.getCostoUnitario());
					jlabelNombrePexistente.setText(pExistente.getNombre());
					
					jbuttonAgregarProductoPexistente.setEnabled(true);
					
				}
			}
		});
		panel_1.add(jButtonBuscarPexitente);
		separator.setBounds(20, 56, 389, 2);
		panel_1.add(separator);
		label_1.setBounds(72, 75, 102, 14);
		panel_1.add(label_1);
		label_3.setBounds(72, 110, 102, 14);
		panel_1.add(label_3);
		label_5.setBounds(72, 140, 102, 14);
		panel_1.add(label_5);
		jlabelNombrePexistente.setBounds(184, 75, 105, 14);
		panel_1.add(jlabelNombrePexistente);
		jlabelCostoUnitarioPexistente.setBounds(184, 110, 102, 14);
		panel_1.add(jlabelCostoUnitarioPexistente);
		jlabelCantidadPexistente.setBounds(184, 140, 83, 14);
		panel_1.add(jlabelCantidadPexistente);
		separator_1.setBounds(20, 165, 389, 2);
		panel_1.add(separator_1);
		jbuttonAgregarProductoPexistente.setBounds(51, 337, 140, 45);
		jbuttonAgregarProductoPexistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				if(jtextFieldCantidadPexistente.getText()==""^jtextFieldAnioPexistente.getText()=="" ^
						jtextFieldCostoPexistente.getText()=="")
					JOptionPane.showMessageDialog(null, "Llena los campos");
				else{
					int year = Integer.parseInt(jtextFieldAnioPexistente.getText());
					int month = jcomboBoxMesPexistente.getSelectedIndex();
					int day = jcomboBoxDiaPexistente.getSelectedIndex()+1;
					
					Calendar calendar = Calendar.getInstance();
					calendar.set(Calendar.YEAR,year);
					calendar.set(Calendar.MONTH,month);
					int numeroDias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
					Date fecha = new Date(year-1900,month,day);
					//System.out.println("soy la fecga de caducidad de producto existente modificado "+fecha);
					pExistente.setFechaCaducidad(fecha);
					pExistente.setCostoUnitario(Double.parseDouble(jtextFieldCostoPexistente.getText()));
					pExistente.setCantidad(Integer.parseInt(jtextFieldCantidadPexistente.getText()));
					if(control.agregaProductoExistente(pExistente)){
						JOptionPane.showMessageDialog(null, "éxito");
						
					}else
						JOptionPane.showMessageDialog(null, "falló");
				}
				
				
				
			}
		});
		
		jbuttonAgregarProductoPexistente.setEnabled(false);
		
		panel_1.add(jbuttonAgregarProductoPexistente);
		jbuttonCancelarPexistente.setBounds(211, 336, 150, 47);
		panel_1.add(jbuttonCancelarPexistente);

		
		jtextFieldCantidadPexistente = new JTextField();
		jtextFieldCantidadPexistente.setBounds(176, 282, 185, 20);
		jtextFieldCantidadPexistente.setColumns(10);
		panel_1.add(jtextFieldCantidadPexistente);
		jcomboBoxDiaPexistente.setBounds(176, 231, 46, 20);
		
		

		jcomboBoxDiaPexistente.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		panel_1.add(jcomboBoxDiaPexistente);
		jcomboBoxMesPexistente.setBounds(231, 231, 58, 20);
		
		
		
		jcomboBoxMesPexistente.setModel(new DefaultComboBoxModel(new String[] {"ENE", "FEB", "MAR ", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"}));
		panel_1.add(jcomboBoxMesPexistente);
		

		jtextFieldAnioPexistente = new JTextField();
		jtextFieldAnioPexistente.setBounds(300, 231, 61, 20);
		jtextFieldAnioPexistente.setColumns(10);
		panel_1.add(jtextFieldAnioPexistente);
		label_4.setBounds(51, 234, 130, 14);
		panel_1.add(label_4);
		label_6.setBounds(52, 285, 102, 14);
		panel_1.add(label_6);
		lblCostoUnitario_1.setBounds(51, 192, 123, 14);
		panel_1.add(lblCostoUnitario_1);
		
		jtextFieldCostoPexistente = new JTextField();
		jtextFieldCostoPexistente.setBounds(176, 189, 185, 20);
		panel_1.add(jtextFieldCostoPexistente);
		jtextFieldCostoPexistente.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user.png"));
		lblUsuario.setBounds(284, 11, 75, 14);
		contentPane.add(lblUsuario);
		
		JLabel jlabelUsuario = new JLabel("admin");
		jlabelUsuario.setBounds(359, 11, 75, 14);
		contentPane.add(jlabelUsuario);
		
		
		jbuttonCancelarPexistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		jButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}
