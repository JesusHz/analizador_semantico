package compiladores.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.logica.GestionArchivo;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AbrirArchivo extends JFrame {

	 public JPanel contentPane;
	  JFileChooser seleccionado = new JFileChooser();
	  File archivo;
      GestionArchivo gestionArchivo= new GestionArchivo();

     
      
	/**
	 * Launch the application.
	 */
	/**
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbrirArchivo frame = new AbrirArchivo();
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
	public AbrirArchivo(final JTextArea testo) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 307, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
	    this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 295, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon("src\\img\\nuevo.jpg"));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			testo.setText("");
			}
		});
		btnNuevo.setBounds(10, 11, 64, 43);
		panel.add(btnNuevo);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setIcon(new ImageIcon("src\\img\\archivo.jpg"));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(seleccionado.showDialog(null, "ABRIR") == JFileChooser.APPROVE_OPTION){
					 archivo = seleccionado.getSelectedFile();
			            if(archivo.canRead()){
			                if(archivo.getName().endsWith("txt")){
			                    String contenido = gestionArchivo.AbrirATexto(archivo);
			                    	testo.setText(contenido);		               
			                      dispose();
		           
		          }
			    }
			  }
				
			}
		});
		btnAbrir.setBounds(10, 60, 64, 43);
		panel.add(btnAbrir);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon("src\\img\\guardar.png"));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String ruta = "src/archivo.txt";
				 
			     guardar(testo.getText() ,ruta );
		            
				 
			}
		});
		btnGuardar.setBounds(10, 114, 64, 36);
		panel.add(btnGuardar);
		
		JButton guardarComo = new JButton("");
		guardarComo.setIcon(new ImageIcon("src\\img\\guardarComo.jpg"));
		guardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if(seleccionado.showDialog(null, "GuardarComo") == JFileChooser.APPROVE_OPTION){
			            archivo = seleccionado.getSelectedFile();
			            if(archivo.getName().endsWith("txt")){
			                String contenido = testo.getText();
			                String respuesta = gestionArchivo.GuardarATexto(archivo, contenido);
			                if(respuesta!=null){
			                    JOptionPane.showMessageDialog(null, respuesta);
			                }else{
			                    JOptionPane.showMessageDialog(null, "Error al guardar texto.");
			                }
			            }else{
			                JOptionPane.showMessageDialog(null, "El texto se debe guardar en un formato de texto.");
			            }
			        }
				
				
			}
		});
		guardarComo.setBounds(10, 161, 64, 41);
		panel.add(guardarComo);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon("src\\img\\salir.jpg"));
		btnSalir.setBounds(10, 213, 64, 37);
		panel.add(btnSalir);
		
		JLabel lblAbrir = new JLabel("Nuevo");
		lblAbrir.setForeground(new Color(255, 165, 0));
		lblAbrir.setBackground(new Color(0, 0, 0));
		lblAbrir.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAbrir.setBounds(120, 15, 64, 14);
		panel.add(lblAbrir);
		
		JLabel lblAbrir_1 = new JLabel("Abrir");
		lblAbrir_1.setForeground(new Color(255, 165, 0));
		lblAbrir_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAbrir_1.setBounds(120, 69, 74, 14);
		panel.add(lblAbrir_1);
		
		JLabel lblGuardar = new JLabel("Guardar");
		lblGuardar.setForeground(new Color(255, 165, 0));
		lblGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGuardar.setBounds(120, 118, 74, 14);
		panel.add(lblGuardar);
		
		JLabel lblGuardarComo = new JLabel("Guardar como");
		lblGuardarComo.setForeground(new Color(255, 165, 0));
		lblGuardarComo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGuardarComo.setBounds(120, 165, 101, 14);
		panel.add(lblGuardarComo);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setForeground(new Color(255, 165, 0));
		lblSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalir.setBounds(120, 217, 55, 14);
		panel.add(lblSalir);
	}

     public void guardar(String Archivo, String donde)
     {
           FileWriter fw;
           try
           {
                 fw= new FileWriter(donde);
           }
           catch(IOException io)
           {
        	   JOptionPane.showMessageDialog(null ,"Error al abrir el fichero");
                 return;
           }

           //Escribimos
           try
           {
                 fw.write(Archivo);
               //  JOptionPane.showMessageDialog(null ,"Fichero guardado");
           }

           catch(IOException io)
           {
        	   JOptionPane.showMessageDialog(null ,"Error al escribir");
           }

           //cerramos el fichero
           try
           {
                 fw.close();
           }

           catch(IOException io)
           {
                 JOptionPane.showMessageDialog(null ,"Error al cerrar el archivo");
           }             
     }
   
	

}
