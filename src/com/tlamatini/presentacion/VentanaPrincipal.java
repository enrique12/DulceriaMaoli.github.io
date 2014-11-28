package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import com.tlamatini.datos.ConexionDB;
import com.tlamatini.negocio.ControlAdministrarInventario;
import com.tlamatini.negocio.ControlAdministrarProveedor;
import com.tlamatini.negocio.ControlAdministrarUsuario;
import com.tlamatini.negocio.ControlAgregarProducto;
import com.tlamatini.negocio.ControlCompra;
import com.tlamatini.negocio.ControlConsultaInventario;
import com.tlamatini.negocio.ControlEstadoFinanciero;
import com.tlamatini.negocio.ControlMiCuenta;
import com.tlamatini.negocio.ControlProductomasVendido;
import com.tlamatini.negocio.ControlProductosProximosACaducar;
import com.tlamatini.negocio.ControlVenta;
import com.tlamatini.negocio.ControlVentanaLogin;
import com.tlamatini.negocio.ControlVentanaPrincipal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.AbstractAction;
import javax.swing.Action;

	
public class VentanaPrincipal extends JFrame {
	
	private VentanaPrincipal yo;
	private ControlVentanaPrincipal control;
	private static boolean esAdministrador;
	private Calendar fecha = Calendar.getInstance();
	private JPanel contentPane;
	private JButton jbuttonRealizarVentaAdmin = new JButton("Realizar Venta");
	private JButton jButtonSalir;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnArchivo = new JMenu("Archivo");
	private JMenuItem mntmCerrarCuenta = new JMenuItem("Cerrar cuenta");
	private JMenuItem mntmVender = new JMenuItem("Salir");
	private JMenu mnVista = new JMenu("Vista");
	private JMenuItem mntmAvanzada = new JMenuItem("Avanzada");
	private JMenuItem mntmBsica = new JMenuItem("B\u00E1sica");
	private JMenu mnAyuda = new JMenu("Ayuda");
	private JMenuItem mntmAcercaDeTlamatini = new JMenuItem("Acerca de Tlamatini");
	private JPanel panel = new JPanel();
	private JButton jButtonSalirAdmin = new JButton("Salir");
	private JButton jbuttonConsultarInventarioAdmin = new JButton("Inventario");
	private JButton jbuttonAgregarProductoAdmin = new JButton("Agregar Producto");
	private JLabel label = new JLabel("Usuario:");
	private JLabel jLabelUsuario;
	private JSeparator separator = new JSeparator();
	private JLabel lblHoyEs = new JLabel("Hoy es:");
	private JLabel jLabelFecha;
	private JButton jButtonMiCuenta = new JButton("Mi cuenta");
	private JButton jButtonAdmistrarUsuariosAdmin = new JButton("Usuarios");
	private JButton jButtonAdministrarInventarioAdmin = new JButton("Más vendido");
	private JButton jButtonAdministrarProveedoresAdmin = new JButton(" Proveedores");
	private JButton jButtonFinanzasAdmin = new JButton("Finanzas");
	private JButton jButtonRealizarVenta = new JButton("Realizar Venta");
	private JButton jButtonProductosProximosAcaducar = new JButton("Pr\u00F3ximos a Caducar");
	private JButton jButtonAgregarProducto = new JButton("Agregar Producto");
	private JButton jButtonConsultarInventario = new JButton("Consultar Inventario");
	private final Action action = new SwingAction();
	ConexionDB conexion;
	private JButton jbuttonRealizarCompraAdmin = new JButton("Realizar Compra");
	private JButton jButtonRealizarCompra = new JButton("Realizar Venta");
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(final ControlVentanaPrincipal control,ConexionDB con) {
		conexion=con;
		yo=this;
		this.control=control;
		File miDir=new File(".");
		try {
			setIconImage(Toolkit.getDefaultToolkit().getImage(miDir.getCanonicalPath()+"\\iconos\\basket.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		esAdministrador=control.getUser().isEsAdministrador();
		fecha = Calendar.getInstance();
		setResizable(false);
		setTitle("Tlamatini");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 341);
		
		
		setJMenuBar(menuBar);
		
		
		menuBar.add(mnArchivo);
		
	
		try {
			mntmCerrarCuenta.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\user_go.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		mntmCerrarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlVentanaLogin login=new ControlVentanaLogin(conexion);
				dispose();
			}
		});
		mnArchivo.add(mntmCerrarCuenta);

		
		
		try {
			mntmVender.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\door_out.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ax = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(ax == JOptionPane.YES_OPTION)
		        	System.exit(0);
				}
		});
		mnArchivo.add(mntmVender);
		
		
		if(!esAdministrador)
			mnVista.setVisible(false);
		menuBar.add(mnVista);
		
		
		try {
			mntmBsica.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\application_form_delete.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mnVista.add(mntmBsica);
		
		
		try {
			mntmAvanzada.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\application_form_add.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mnVista.add(mntmAvanzada);
		
		
		
		menuBar.add(mnAyuda);
		
		try {
			mntmAcercaDeTlamatini.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaAcercaDe acercade=new VentanaAcercaDe();
					acercade.setVisible(true);
					acercade.setAlwaysOnTop(true);
				}
			});
			mntmAcercaDeTlamatini.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\help.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mnAyuda.add(mntmAcercaDeTlamatini);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Ventana Principal", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		panel.setBounds(10, 21, 411, 263);
		panel.setLayout(null);
		
		
		
		jButtonSalirAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ax = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		        if(ax == JOptionPane.YES_OPTION)
		        	System.exit(0);
		        }
		});
		jButtonSalirAdmin.setBounds(273, 183, 125, 43);
		jButtonSalirAdmin.setVisible(false);
		panel.add(jButtonSalirAdmin);
		jbuttonConsultarInventarioAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlConsultaInventario consulta=new ControlConsultaInventario(control.getUser(),conexion);
			}
		});
		
		
		//jbuttonConsultarInventarioAdmin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jbuttonConsultarInventarioAdmin.setBounds(273, 74, 125, 43);
		jbuttonConsultarInventarioAdmin.setVisible(false);
		
		
		
		panel.add(jbuttonConsultarInventarioAdmin);
		
		jbuttonAgregarProductoAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControlAgregarProducto producto=new ControlAgregarProducto(control.getUser(),conexion);
			}
		});
		
		
		
		//jbuttonAgregarProductoAdmin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		jbuttonAgregarProductoAdmin.setBounds(139, 74, 124, 43);
		jbuttonAgregarProductoAdmin.setVisible(false);
		panel.add(jbuttonAgregarProductoAdmin);
		jbuttonRealizarVentaAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControlVenta venta=new ControlVenta(control.getUser(),conexion);
			}
		});
		jbuttonRealizarVentaAdmin.setBounds(5, 74, 124, 43);
		jbuttonRealizarVentaAdmin.setVisible(false);
		panel.add(jbuttonRealizarVentaAdmin);
		
		
		jbuttonRealizarCompraAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControlCompra compra=new ControlCompra(control.getUser(),conexion);
			}
		});
		jbuttonRealizarCompraAdmin.setBounds(5, 184, 124, 43);
		jbuttonRealizarCompraAdmin.setVisible(false);
		panel.add(jbuttonRealizarCompraAdmin);
		
		
		try {
			label.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\user.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		label.setBounds(239, 11, 73, 14);
		panel.add(label);
		
		
		
		jLabelUsuario= new JLabel(control.getUser().getNick());
		jLabelUsuario.setBounds(311, 11, 87, 14);
		panel.add(jLabelUsuario);
		
		
		separator.setBounds(10, 49, 388, 14);
		panel.add(separator);
		
		
		
		
		try {
			lblHoyEs.setIcon(new ImageIcon(miDir.getCanonicalPath()+"\\iconos\\calendar.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblHoyEs.setBounds(5, 11, 61, 14);
		panel.add(lblHoyEs);
		
		
		jLabelFecha = new JLabel(""+fecha.getTime().getDate()+"/"+fecha.getTime().getMonth()+"/"+fecha.getWeekYear());
		jLabelFecha.setBounds(66, 11, 194, 14);
		panel.add(jLabelFecha);
		
		
		
		jButtonMiCuenta.setBounds(259, 24, 140, 14);
		panel.add(jButtonMiCuenta);
		jButtonMiCuenta.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ControlMiCuenta miCuenta=new ControlMiCuenta(control.getUser(),conexion);
			}
		});
		jButtonAdmistrarUsuariosAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlAdministrarUsuario usuarios=new ControlAdministrarUsuario(control.getUser(),conexion);
				usuarios.inicia();
			}
		});
		
		
		jButtonAdmistrarUsuariosAdmin.setBounds(10, 129, 119, 43);
		jButtonAdmistrarUsuariosAdmin.setVisible(false);
		panel.add(jButtonAdmistrarUsuariosAdmin);
		jButtonAdministrarInventarioAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ControlAdministrarInventario inventario=new ControlAdministrarInventario(control.getUser());
				ControlProductomasVendido venta=new ControlProductomasVendido(control.getUser(),conexion);
			}
		});
		
		
		jButtonAdministrarInventarioAdmin.setBounds(139, 128, 124, 44);
		jButtonAdministrarInventarioAdmin.setVisible(false);
		panel.add(jButtonAdministrarInventarioAdmin);
		
		jButtonAdministrarProveedoresAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlAdministrarProveedor proveedor=new ControlAdministrarProveedor(conexion);
			}
		});
		
		
		jButtonAdministrarProveedoresAdmin.setBounds(273, 128, 125, 44);
		jButtonAdministrarProveedoresAdmin.setVisible(false);
		panel.add(jButtonAdministrarProveedoresAdmin);
		jButtonFinanzasAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlEstadoFinanciero estado=new ControlEstadoFinanciero(conexion);
			}
		});
		
		
		
		jButtonFinanzasAdmin.setBounds(139, 183, 124, 43);
		jButtonFinanzasAdmin.setVisible(false);
		panel.add(jButtonFinanzasAdmin);
		jButtonRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlVenta venta2=new ControlVenta(control.getUser(),conexion);
			}
		});
		
		
		
		jButtonRealizarVenta.setBounds(5, 62, 194, 56);
		panel.add(jButtonRealizarVenta);
		jButtonProductosProximosAcaducar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlProductosProximosACaducar caducan=new ControlProductosProximosACaducar(control.getUser(),conexion);
			}
		});
		
		
		
		jButtonProductosProximosAcaducar.setBounds(204, 129, 194, 56);
		panel.add(jButtonProductosProximosAcaducar);
		
		
		jButtonAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlAgregarProducto agrega=new ControlAgregarProducto(control.getUser(),conexion);
			}
		});
		jButtonAgregarProducto.setBounds(204, 61, 194, 56);
		panel.add(jButtonAgregarProducto);
		jButtonConsultarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlConsultaInventario consulta2=new ControlConsultaInventario(control.getUser(),conexion);
			}
		});
		
		
		
		jButtonConsultarInventario.setBounds(5, 129, 194, 56);
		panel.add(jButtonConsultarInventario);
		
		jButtonSalir = new JButton("Salir");
		jButtonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ax = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);				
		        if(ax == JOptionPane.YES_OPTION)
		        	System.exit(0);
		       	}
		});
		contentPane.setLayout(null);
		jButtonSalir.setBounds(5, 196, 393, 56);
		panel.add(jButtonSalir);
		contentPane.add(panel);
		
		mntmAvanzada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonAgregarProducto.setVisible(false);
				jButtonConsultarInventario.setVisible(false);
				jButtonRealizarVenta.setVisible(false);
				jButtonProductosProximosAcaducar.setVisible(false);
				jButtonSalir.setVisible(false);	
				jButtonRealizarCompra.setVisible(false);
				
				jbuttonRealizarCompraAdmin.setVisible(true);
				jbuttonConsultarInventarioAdmin.setVisible(true);
				jButtonAdministrarInventarioAdmin.setVisible(true);
				jbuttonAgregarProductoAdmin.setVisible(true);
				jButtonAdministrarProveedoresAdmin.setVisible(true);
				jButtonAdmistrarUsuariosAdmin.setVisible(true);
				jbuttonRealizarVentaAdmin.setVisible(true);
				jButtonSalirAdmin.setVisible(true);
				jButtonFinanzasAdmin.setVisible(true);
				}
		});
		
		mntmBsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonAgregarProducto.setVisible(true);
				jButtonConsultarInventario.setVisible(true);
				jButtonRealizarVenta.setVisible(true);
				jButtonProductosProximosAcaducar.setVisible(true);
				jButtonSalir.setVisible(true);			
				
				jbuttonRealizarCompraAdmin.setVisible(false);
				jbuttonConsultarInventarioAdmin.setVisible(false);
				jButtonAdministrarInventarioAdmin.setVisible(false);
				jbuttonAgregarProductoAdmin.setVisible(false);
				jButtonAdministrarProveedoresAdmin.setVisible(false);
				jButtonAdmistrarUsuariosAdmin.setVisible(false);
				jbuttonRealizarVentaAdmin.setVisible(false);
				jButtonSalirAdmin.setVisible(false);
				jButtonFinanzasAdmin.setVisible(false);
				
			}
		});
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}