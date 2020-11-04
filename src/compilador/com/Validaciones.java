package compilador.com;

import java.time.temporal.Temporal;
import java.util.ArrayList;

public class Validaciones {
	static String tipo;
	static String variableM;
	static String tipo2;
	static String variable;
	static String tipoCadena;
	static String tipoCaracter;
	static String guardarEntero;

	public static ArrayList<Guardar> tablaDePruebas = new ArrayList<Guardar>();

	/*
	 * Metodo encargado de verificar si en la tabla de variables si encuentran
	 * variables repetidas o si ya han sido asignadas a con un mismo tipo de dato o
	 * en el mismo ambito
	 * 
	 * }
	 */
	public static boolean verificarVariable(TAB a) {

		for (int i = 0; i < AnalizadorLexico.getTablaSimbolos().size(); i++) {
			if (AnalizadorLexico.getTablaSimbolos().get(i).getNombreVariable().equals(a.getNombreVariable())
					&& AnalizadorLexico.getTablaSimbolos().get(i).getTipo().equals(a.getTipo())
					&& AnalizadorLexico.getTablaSimbolos().get(i).getAmbito().equals(a.getAmbito())) {

				return true;
			}
		}

		return false;
	}

	/*
	 * Metodo en cargado de confirmar si un metodo ya a sido creado un metodo con el
	 * mismo nombre o el mismo tipo de dato
	 */
	public static boolean verificarVariableMetodos(TAB m) {

		for (int i = 0; i < AnalizadorLexico.getTablaMetodos().size(); i++) {
			if (AnalizadorLexico.getTablaMetodos().get(i).getAmbito().equals(m.getAmbito())
					&& AnalizadorLexico.getTablaMetodos().get(i).getTipo().equals(m.getTipo())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Metodo encargado de verificar si la variable que se va a asignar se encuentra
	 * ya creada
	 */
	public static boolean validarAsignacion(String variable) {

		for (int i = 0; i < AnalizadorLexico.getTablaSimbolos().size(); i++) {
			if (AnalizadorLexico.getTablaSimbolos().get(i).getNombreVariable().equals(variable)) {
               
				tipo = AnalizadorLexico.getTablaSimbolos().get(i).getTipo();
				
				return true;
			}
		}
		return false;
	}

	public static boolean validarCrearMetodo(String variable) {

		for (int i = 0; i < AnalizadorLexico.getTablaMetodos().size(); i++) {
			if (AnalizadorLexico.getTablaMetodos().get(i).getNombreVariable().equals(variable)) {

				tipo2 = AnalizadorLexico.getTablaMetodos().get(i).getAmbito();

				return true;
			}
		}
		return false;
	}

	public static boolean validarTipoDeDatos() {
		
		if (tipo2 != null && tipo != null) {
			if (tipo2.equals(tipo)) {
               tipo2 = null;
               tipo = null;
				return true;
			}
		}else 
		
			if(tipo != null && tipoCaracter!=null) {
				if(tipo.equals(tipoCaracter)) {
				tipoCaracter = null;
				return true;
			}
		}else
		
		if(tipo!= null && tipoCadena != null) {
			for (int j = 0; j < AnalizadorLexico.getTablaSimbolos().size(); j++) {
				if (AnalizadorLexico.getTablaSimbolos().get(j).getNombreVariable().equals(tipoCadena)) {
					if (AnalizadorLexico.getTablaSimbolos().get(j).getTipo()
									.equals(tipo)) {
						
					    tipoCadena = null;
				
						return true;						
					}
				}
				
			}
		}else
			
			if(tipo!= null && guardarEntero != null) {
			if(tipo.equals(guardarEntero)) {
				
				guardarEntero = null;
				tipo = null;
				return true;
			}
		}

		return false;

	}

	public static void guardarIdentificadores(String entrada) {
        //donde se resive el valor del identificador. para buscarlo en la tabla de variables
		tipoCadena = entrada;

	}

	public static void guardarEntero() {
	
		guardarEntero = "Entero";
	
	}

	public static void guardarCadena(String entrada) {
		tipoCadena = entrada;
		
		
	}

	public static void guardarTipoRetorno(String tipoEntrante) {
 		 System.out.println(tipoEntrante);
		if(tipoEntrante.charAt(0) =='"' && tipoEntrante.charAt(tipoEntrante.length()-1)=='"'){
			tipoCaracter = "Cadena";
		 }
		
	}

	public static boolean validarRetorno(String nombreAmbito) {

		for (int i = 0; i < AnalizadorLexico.getTablaMetodos().size(); i++) {

			if (AnalizadorLexico.getTablaMetodos().get(i).getTipo().equals(nombreAmbito)) {
				for (int j = 0; j < AnalizadorLexico.getTablaSimbolos().size(); j++) {
					if (AnalizadorLexico.getTablaSimbolos().get(j).getNombreVariable().equals(tipoCadena)) {
						if (AnalizadorLexico.getTablaSimbolos().get(j).getAmbito()
								.equals(AnalizadorLexico.getTablaMetodos().get(i).getTipo())
								&& AnalizadorLexico.getTablaSimbolos().get(j).getTipo()
										.equals(AnalizadorLexico.getTablaMetodos().get(i).getAmbito())) {
						
							tipoCadena = null;
							return true;						
						}
					}
					
				}
				if(AnalizadorLexico.getTablaMetodos().get(i).getAmbito().equals(tipoCaracter)) {
					tipoCaracter = null;
					return true;
				}

				return false;
			}
		}

		return false;
	}

}
