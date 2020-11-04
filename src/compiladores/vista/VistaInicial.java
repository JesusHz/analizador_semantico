package compiladores.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JList;
import java.awt.ScrollPane;
import javax.swing.DropMode;
import java.awt.TextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.logica.GestionArchivo;
import compilador.com.TAB;

import compilador.com.AnalizadorLexico;
import compilador.com.Imprimir;
import compilador.com.ParseException;
import compilador.com.TokenMgrError;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;


public class VistaInicial extends JFrame  {

	public JPanel contentPane;
	public  AnalizadorLexico parser;  
	public JButton btnNewButton_2;
	//private final JScrollPane scrollPane_2 = new JScrollPane();
	//JTextArea contarLinea;
	JTextArea textoInicio ;
    JTextArea textConsola;
    JTextArea linea;
    TablasS frame;
    DefaultTableModel modelo;
    String [][] data = {};
    String [] cabeza = {"Nombre", "Tipo", "Ambito"};
    
    DefaultTableModel modeloMetodo;
    String [][] dataMetodo = {};
    String [] cabezaMetodo = {"Nombre", "tipo de retorno", "Tipo parametro", "Ambito"};
    
    //****************************************************
    public static Imprimir imprimir = new Imprimir();
    public static AbrirArchivo archivo = new AbrirArchivo(null);
    public static GestionArchivo gestionArchivo = new GestionArchivo();
    public static String contenido;
    
    
    
    //****************************************************
    
 	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicial frame = new VistaInicial();
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

	public VistaInicial() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
	    this.setResizable(false);
	   
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 849, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBorder(new LineBorder(Color.BLUE, 2));
		panel_1.setBounds(10, 47, 99, 320);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
			
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setIcon(new ImageIcon("src\\img\\table.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new TablasS();
				frame.setVisible(true);
				btnNewButton_2.setEnabled(false);
				
			
				modelo = new DefaultTableModel(data , cabeza);
				frame.getTable().setModel(modelo);
				TAB temp;
				String[] fila = new String[4];
				for (int i = 0; i < parser.tablaSimbolos.size(); i++) {
					
					fila[0] = parser.tablaSimbolos.get(i).getNombreVariable();
					fila[1] = parser.tablaSimbolos.get(i).getTipo();
					fila[2] = parser.tablaSimbolos.get(i).getAmbito();
					fila[3] = parser.tablaSimbolos.get(i).getModificable();
					modelo.addRow(fila);
				}
					
				    
			modeloMetodo = new DefaultTableModel(dataMetodo , cabezaMetodo);
			frame.getTable_1().setModel(modeloMetodo);
			
			
			TAB temp1;
			String[] fila1 = new String[4];
			for (int i = 0; i < parser.tablaMetodos.size(); i++) {
				fila1[0] = parser.tablaMetodos.get(i).getNombreVariable();
				fila1[1] = parser.tablaMetodos.get(i).getAmbito();
				fila1[2] = parser.tablaMetodos.get(i).getInterno();
				fila1[3] = "Global";
				modeloMetodo.addRow(fila1);
			}
			
			
			
			}
		});
		btnNewButton_2.setBounds(10, 233, 79, 54);
		panel_1.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setFocusCycleRoot(true);
		scrollPane.setDoubleBuffered(true);
		scrollPane.setBounds(157, 37, 668, 209);
		panel.add(scrollPane);
		
	     textoInicio = new JTextArea();
	     textoInicio.addKeyListener(new KeyAdapter() {
	     	@Override
	     	public void keyPressed(KeyEvent e) {
	     		contadorFilas();
	     	}
	     	@Override
	     	public void keyReleased(KeyEvent arg0) {
	     		contadorFilas();
	     	}
	     });
	     
	  
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFocusCycleRoot(true);
		scrollPane_1.setDoubleBuffered(true);
		scrollPane_1.setBounds(157, 293, 668, 141);
		panel.add(scrollPane_1);
		
		textConsola = new JTextArea();
		scrollPane_1.setViewportView(textConsola);
		
		  linea = new JTextArea("1");
		  linea.setBackground(SystemColor.info);
			scrollPane.setViewportView(textoInicio);
			linea.setEditable(false);
			linea.setColumns(3);
			scrollPane.setRowHeaderView(linea);
			
		
		
		JLabel lblNewLabel = new JLabel("Consola");
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(157, 257, 66, 14);
		panel.add(lblNewLabel);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon("src\\img\\open.png"));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirArchivo frame = new AbrirArchivo(textoInicio);
				frame.setVisible(true);
			    
			}
		});
		btnAbrir.setBounds(10, 48, 79, 54);
		panel_1.add(btnAbrir);
		
		
		JButton btnEjecutar = new JButton("");
		btnEjecutar.setIcon(new ImageIcon("src\\img\\descarga.jpg"));
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                parser.setBien(true);
				parser.tablaSimbolos.clear();
				parser.tablaMetodos.clear();
				textConsola.setText("");
				btnNewButton_2.setEnabled(true);
				archivo.guardar(textoInicio.getText(), "src/archivo.txt");
				
				try {
				 contenido = muestraContenido("src/archivo.txt");
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			     
				
				 
				boolean ok;
			   if (parser == null) {
					
					parser = new AnalizadorLexico(
							 new ByteArrayInputStream(textoInicio.getText().getBytes(StandardCharsets.US_ASCII)));
					
				} else {
					parser.ReInit(new ByteArrayInputStream(textoInicio.getText().getBytes(StandardCharsets.US_ASCII)));
				}
				
			 			   
		       	try {
		            parser.setTexto("");
		       		parser.Programa();	
		       		
		       		
				
		       	}catch(TokenMgrError te)
		    	{
		       		parser.setBien(false);
		       		//textConsola.setText(parser.getTexto());	
		    	}  
				   catch (ParseException el) {
				
					  //textConsola.setText(parser.getTexto());
				}
		        textConsola.setText(parser.getTexto());
		       	ok  = parser.isBien();
		       
		       	if(ok)
		       	{
		       		textConsola.setText( "Analisis terminado: \n no se han hallado errores lexicos");
		 
		       	}
		       
				 
			}
			
		});
		btnEjecutar.setBounds(10, 144, 79, 54);
		panel_1.add(btnEjecutar);
		/*scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(153, 37, 43, 174);
		panel.add(scrollPane_2);
		
		contarLinea = new JTextArea("1");
		contarLinea.setEditable(false);
		scrollPane_2.setViewportView(contarLinea);
		*/
		
		

		
	}
	
	public JTextArea getTextConsola() {
		return textConsola;
	}

	public void setTextConsola(JTextArea textConsola) {
	this.textConsola = textConsola;
	}

	/**
	 * Metodo que Permite actualizar el textEdicion donde se muestra la cantidad
	 * de filas
	 */
	private void contadorFilas() {		
		 linea.setText("1\n");
		for (int i = 1; i <= textoInicio.getLineCount(); i++) {
			linea.setText(linea.getText() + (i+1) + "\n");
		}
	}
	
      public String muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        
        String contenido= "";
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
               contenido += cadena;
          contadorFilas();
        }
        b.close();
        
        return contenido;
    }	
	
	
}
