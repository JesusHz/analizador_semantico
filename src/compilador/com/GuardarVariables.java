package compilador.com;

public class GuardarVariables {

	private String nombre;
	private String tipo;
	private String valor;

	public GuardarVariables(String nombre, String tipo, String valor) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "nombre " + nombre + ", tipo " + tipo + ", valor " + valor;
	}
	
	
	

}
