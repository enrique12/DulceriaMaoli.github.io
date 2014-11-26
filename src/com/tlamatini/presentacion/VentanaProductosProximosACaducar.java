package com.tlamatini.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.tlamatini.modelo.Producto;
import com.tlamatini.modelo.Usuario;
import com.tlamatini.negocio.ControlProductosProximosACaducar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaProductosProximosACaducar extends JFrame {

	private File miDir=new File(".");
	
	private JPanel contentPane;
	private JTextField jtextFieldAnio;
	private JLabel jlabelUsuario = new JLabel("");
	private JLabel lblUsuario = new JLabel("Usuario:");
	private JButton jButtonAceptar = new JButton("Aceptar");
	private JSeparator separator = new JSeparator();
	private JButton jButtonBuscar = new JButton("Buscar");
	private JComboBox jcomboBoxMes = new JComboBox();
	private JComboBox jcomboBoxDia = new JComboBox();
	private JLabel lblNewLabel = new JLabel("Caducidad:");
	private JPanel panel = new JPanel();
	private JTable table;

	/**
	 * Create the frame.
	 * @param controlProductosProximosACaducar 
	 */
	public VentanaProductosProximosACaducar(final ControlProductosProximosACaducar controlProductosProximosACaducar,Usuario user) {
		lblUsuario.setText(user.getNick());
		
		setType(Type.UTILITY);
		setTitle("Tlamatini");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setAlwaysOnTop(false);
		setBounds(100, 100, 620, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Productos Proximos a caducar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		


		panel.setBounds(10, 22, 584, 458);
		contentPane.add(panel);
		panel.setLayout(null);
		
		

		try {
			lblNewLabel.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/calendar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewLabel.setBounds(48, 42, 120, 32);
		panel.add(lblNewLabel);
		
		jtextFieldAnio = new JTextField();
		jtextFieldAnio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!"1234567890".contains(""+e.getKeyChar())){
					e.consume();
				}
			}
		});
		jtextFieldAnio.setBounds(294, 48, 70, 20);
		panel.add(jtextFieldAnio);
		jtextFieldAnio.setColumns(10);
		
		

		jcomboBoxDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jcomboBoxDia.setBounds(147, 48, 59, 20);
		panel.add(jcomboBoxDia);
		
		

		jcomboBoxMes.setModel(new DefaultComboBoxModel(new String[] {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"}));
		jcomboBoxMes.setBounds(216, 48, 64, 20);
		panel.add(jcomboBoxMes);
		jButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtextFieldAnio.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ingrese el anio");
				}
				
				//obtiene la fecha
				
				
				int year = Integer.parseInt(jtextFieldAnio.getText());
				int month = jcomboBoxMes.getSelectedIndex();
				int day = jcomboBoxDia.getSelectedIndex()+1;
				
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR,year);
				calendar.set(Calendar.MONTH,month);
				int numeroDias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);;
				
				//valida si es un fecha correcta
				if(numeroDias< day){
					JOptionPane.showMessageDialog(null, "fecha invalida");
				}else{
					Date fecha = new Date(year-1900,month,day);
					Producto[] productos = controlProductosProximosACaducar.buscaProductosProximosACaducar(fecha);
					
					//muestra productos el la tabla
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					//limpia tabla
					for(int i= model.getRowCount()-1; i>-1;i--){
						model.removeRow(i);
					}
					
					//llena tabla
					for(int i=0;i<productos.length;i++){
						System.out.println(productos[i].getNombre());
						model.insertRow(i,new Object[]{productos[i].getIdProducto(),productos[i].getNombre(),productos[i].getDescripcion(),productos[i].getCantidad(),productos[i].getFechaCaducidad(),productos[i].getNombreProveedor() } );
					
					}
					
				}
				
				
				
			}
		});
		
		

		jButtonBuscar.setBounds(374, 38, 200, 40);
		panel.add(jButtonBuscar);
		

		separator.setBounds(10, 99, 564, 2);
		panel.add(separator);
		
		

		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		jButtonAceptar.setBounds(421, 401, 151, 33);
		panel.add(jButtonAceptar);
		
		try {
			lblUsuario.setIcon(new ImageIcon(miDir.getCanonicalPath()+"/iconos/user.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblUsuario.setBounds(485, 12, 82, 14);
		panel.add(lblUsuario);
		
		
		jlabelUsuario.setBounds(578, 12, 108, 14);
		panel.add(jlabelUsuario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 562, 276);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Clave", "nombre", "Descripcion", "Cantidad", "Caduca el:", "Proveedor"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		scrollPane.setViewportView(table);
	}
}

