package compilador.com;

import java.util.Enumeration;
import java.util.Hashtable;

public class Imprimir {

	public void imprimirVariables(Hashtable gv) {
		Enumeration e = gv.elements();
		Object clave;
		
		while( e.hasMoreElements() ){
		  clave = e.nextElement();
		  
		  System.out.println(clave);
		 
		}
		
	}
	
}
