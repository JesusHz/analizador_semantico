package compilador.com;

import java.util.*;

public class TAB {

	/**
	 * Esta es la variable Tipo
	 */
		private String tipo;
		/**
		 * Esta es la variable ambito
		 */
		private String ambito;
		/**
		 * Esta es la variable modificable
		 */
		private String modificable;
		/**
		 * 
		 */
		private String interno ; 
				
		private String nombreVariable;
        /**
         * 
         * @param tipo
         * @param ambito
         * @param modificable
         * @param interno
         */
		public TAB(String tipo, String ambito, String modificable,String interno,String nombreVariable ) {
			super();
			this.tipo = tipo;
			this.ambito = ambito;
			this.modificable = modificable;
			this.interno = interno;
			this.nombreVariable= nombreVariable;
		}




		/**
		 * @return the tipo
		 */
		public String getTipo() {
			return tipo;
		}

		/**
		 * @return the ambito
		 */
		public String getAmbito() {
			return ambito;
		}

		/**
		 * @return the modificable
		 */
		public String getModificable() {
			return modificable;
		}


        /**
         *  @return the interno
         */

		public String getInterno() {
			return interno;
		}



        /**
         * 
         * @return nombre Variable
         */
		public String getNombreVariable() {
			return nombreVariable;
		}




		@Override
		public String toString() {
			return "TAB [tipo=" + tipo + ", ambito=" + ambito + ", modificable=" + modificable + ", interno=" + interno
					+ ", nombreVariable=" + nombreVariable + "]";
		}
		
		
	
	
	
}
