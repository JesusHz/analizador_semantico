package compiladores.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import compilador.com.AnalizadorLexico;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TablasS extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTable table;
	private JTable table_1;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private JLabel lblTablaDeVariables;
	private JLabel lblTablaMetodos;
	public  AnalizadorLexico parser; 
    public List <String> variable= new ArrayList<String>(); 
    public VistaInicial vista= new VistaInicial();
   
	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablasS frame = new TablasS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the frame.
	 */
	public TablasS() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 626, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 600, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		scrollPane.setBounds(30, 39, 444, 147);
		panel.add(scrollPane);
		this.setLocationRelativeTo(null);
	    this.setResizable(false);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Nombre", "Tipo", "Ambito"
			}
		));
		scrollPane.setViewportView(table);
		scrollPane_1.setBounds(30, 212, 544, 135);
		panel.add(scrollPane_1);
		
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "tipo de retorno", "Tipo parametro", "Ambito"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(84);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(81);
		scrollPane_1.setViewportView(table_1);
		
		lblTablaDeVariables = new JLabel("Tabla de variables");
		lblTablaDeVariables.setForeground(new Color(255, 165, 0));
		lblTablaDeVariables.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTablaDeVariables.setBounds(30, 25, 128, 14);
		panel.add(lblTablaDeVariables);
		
		lblTablaMetodos = new JLabel("Tabla Metodos");
		lblTablaMetodos.setForeground(new Color(255, 165, 0));
		lblTablaMetodos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTablaMetodos.setBounds(30, 198, 99, 14);
		panel.add(lblTablaMetodos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				dispose();
				parser.tablaSimbolos.clear();
				parser.tablaMetodos.clear();
			}
		});
		btnSalir.setBounds(236, 380, 89, 23);
		panel.add(btnSalir);
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JTable getTable_1() {
		return table_1;
	}
	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	
}
