package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import org.apache.derby.tools.sysinfo;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.modelo.Proveedor;
import com.tlamatini.negocio.ControlAdministrarProveedor;
import com.tlamatini.negocio.ControlModificaProveedor;
import com.tlamatini.persistencia.DAOProveedor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;



public class VentanaAdministrarProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldNombre;
	private JTable jtableProvedores;
	private DAOProveedor daoprovedor;
	private JButton jButtonAceptar = new JButton("Aceptar");
	private JButton jButtonAgregar = new JButton("Agregar");
	private JButton jButtonBorrar = new JButton("Eliminar");
	private JLabel lblProvedores = new JLabel("Provedores:");
	private JSeparator separator = new JSeparator();
	private JButton jButtonBuscar = new JButton("Buscar");
	private JButton jButtonMuestraTodos = new JButton("Muestra Todos");
	private JLabel lblClave = new JLabel("Empresa:");
	private JLabel jlabelUsuario = new JLabel("Admin");
	private JLabel lblUsuario = new JLabel("Usuario:");
	private JPanel panel = new JPanel();
	private DefaultTableModel modelo;
	private Vector titulo = new Vector();

	private ControlAdministrarProveedor control;
	private ControlModificaProveedor controModifica;
	ConexionDB conexion;

	/**
	 * Create the frame.
	 * @param controlAdministrarProveedor 
	 */
	public VentanaAdministrarProveedor(final ControlAdministrarProveedor control,ConexionDB con) {
		conexion=con;
		daoprovedor=new DAOProveedor(conexion);
		this.control = control;
		setTitle("Tlamatini");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Administrar Provedores", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		


		panel.setBounds(10, 22, 414, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		

		lblUsuario.setIcon(new ImageIcon("C:\\Users\\Azhala\\Documents\\EclipseProyectos\\Proyecto\\iconos\\user.png"));
		lblUsuario.setBounds(230, 11, 99, 14);
		panel.add(lblUsuario);
		

		jlabelUsuario.setBounds(320, 11, 84, 14);
		panel.add(jlabelUsuario);
		
		lblClave.setBounds(45, 41, 66, 14);
		panel.add(lblClave);
		
		jtextFieldNombre = new JTextField();
		jtextFieldNombre.setBounds(101, 38, 132, 20);
		panel.add(jtextFieldNombre);
		jtextFieldNombre.setColumns(10);

		jButtonBuscar.setBounds(244, 36, 143, 23);
		panel.add(jButtonBuscar);
		
		jButtonMuestraTodos.setBounds(244,65,143,23);
		panel.add(jButtonMuestraTodos);

		separator.setBounds(10, 92, 394, 2);
		panel.add(separator);
		

		lblProvedores.setBounds(10, 93, 91, 14);
		panel.add(lblProvedores);
		
		titulo.add("Empresa");
		titulo.add("Dirección");
		titulo.add("Teléfono");
		modelo = new DefaultTableModel(new Vector(),titulo){
			public boolean isCellEditable(int fila, int cols){
				return false;
				}
		};
		jtableProvedores = new JTable(modelo);
		jtableProvedores.getTableHeader().setReorderingAllowed(false);
		//Actualiza();
		
		
		jtableProvedores.setBounds(10, 114, 394, 205);
		panel.add(jtableProvedores);
		
		

		jButtonBorrar.setBounds(10, 338, 89, 35);
		panel.add(jButtonBorrar);		
		
		
		jButtonAgregar.setBounds(155, 338, 89, 35);
		panel.add(jButtonAgregar);
		
		
		jButtonAceptar.setBounds(290, 338, 89, 35);
		panel.add(jButtonAceptar);
		
		jButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Proveedor aux=null;
				String direccion = jtextFieldNombre.getText();
				Vector datos = new Vector();
				if(jtextFieldNombre.getText().compareTo(" ")==0){
					JOptionPane.showMessageDialog(null, "Debes llenar el campo");
				}else{
					aux=control.buscaProvedor(direccion);
										
					if(aux!=null){
						jtableProvedores.setModel(new DefaultTableModel(
								new Object[][] {
									{aux.getEmpresa(), aux.getDireccion(), aux.getTelefono()},
								},
								new String[] {
									"Empresa", "Direcci\u00F3n", "Telefono"
								}
							));
					
						System.out.println(" "+aux.getEmpresa()+" "+aux.getDireccion()+" "+aux.getTelefono());
					}else
						JOptionPane.showMessageDialog(null, "No existe el provedor");
				}
			}
		});
		
		jButtonMuestraTodos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Actualiza();
			}
		});
		
		jButtonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.nuevoProveedor();
			}
		});
		/*jButtonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controModifica = new ControlModificaProveedor(daoprovedor);
				controModifica.inicia();
				
			}
		});*/
		
		jButtonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtableProvedores.getSelectedRow()==-1)
					JOptionPane.showMessageDialog(null, "Debes seleccionar un campo");
				else{
				     if(control.elminaProveedor(control.buscaProvedor((String)jtableProvedores.getValueAt(jtableProvedores.getSelectedRow(), 0))))
						JOptionPane.showMessageDialog(null, "Se elimino el Proveedor");
				    else
				    	JOptionPane.showMessageDialog(null, "Error: No se elimino el proveedor");
					modelo.removeRow(jtableProvedores.getSelectedRow());
				}
			}
		});
	
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	
	}


	private void Actualiza() {
		// TODO Auto-generated method stub
		int i;
		int k = control.dameTodosProveedores().size();
		System.out.println("*******"+k);
		i=0;
		do{
			Vector datos = new Vector();
			String Empresa = control.dameTodosProveedores().get(i).getEmpresa();
			String Direccion= control.dameTodosProveedores().get(i).getDireccion();
			String Telefono = ""+(control.dameTodosProveedores().get(i).getTelefono());
			datos.add(Empresa);
			datos.add(Direccion);
			datos.add(Telefono);
			modelo.addRow(datos);
			i++;
		}while(i<k);
		
		
	}
}
