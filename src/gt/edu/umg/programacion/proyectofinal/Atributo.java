package gt.edu.umg.programacion.proyectofinal;

public class Atributo {
	private int indice;
	private String nombre;
	private int valorTipoDato;
	private String nombreTipoDato;
	private int longitud;
	private int bytes;
	private boolean requiereLongitd;
	private byte[] bytesNombre;
	private TipoDato tipoDato;

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		bytesNombre = new byte[30];
		for (int i = 0; i < nombre.length(); i++) {
			bytesNombre[i] = (byte) nombre.charAt(i);
		}
	}

	public int getValorTipoDato() {
		return valorTipoDato;
	}

	public void setValorTipoDato(int valorTipoDato) {
		this.valorTipoDato = valorTipoDato;
		if (valorTipoDato == TipoDato.STRING.getValue()) {
			this.requiereLongitd = true;
		}
	}

	public String getNombreTipoDato() {
		return nombreTipoDato;
	}

	public void setNombreTipoDato(String nombreTipoDato) {
		if (this.valorTipoDato == TipoDato.STRING.getValue()) {
			this.nombreTipoDato = TipoDato.STRING.name();
			this.bytes = this.longitud;
			tipoDato = TipoDato.STRING;
		}

		if (this.valorTipoDato == TipoDato.LONG.getValue()) {
			this.nombreTipoDato = TipoDato.LONG.name();
			this.bytes = 8;
			tipoDato = TipoDato.LONG;
		}

		if (this.valorTipoDato == TipoDato.INT.getValue()) {
			this.nombreTipoDato = TipoDato.INT.name();
			this.bytes = 4;
			tipoDato = TipoDato.INT;
		}
		if (this.valorTipoDato == TipoDato.DOUBLE.getValue()) {
			this.nombreTipoDato = TipoDato.DOUBLE.name();
			this.bytes = 8;
			tipoDato = TipoDato.DOUBLE;
		}
		
		if (this.valorTipoDato == TipoDato.FLOAT.getValue()) {
			this.nombreTipoDato = TipoDato.FLOAT.name();
			this.bytes = 4;
			tipoDato = TipoDato.FLOAT;
		}
		
		if (this.valorTipoDato == TipoDato.DATE.getValue()) {
			this.nombreTipoDato = TipoDato.DATE.name();
			this.bytes = 28;
			tipoDato = TipoDato.DATE;
		}
		if (this.valorTipoDato == TipoDato.CHAR.getValue()) {
			this.nombreTipoDato = TipoDato.CHAR.name();
			this.bytes = 1;
			tipoDato = TipoDato.CHAR;
		}
		

	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int getBytes() {
		return bytes;
	}

	public void setBytes(int bytes) {
		this.bytes = bytes;
	}

	public boolean isRequiereLongitd() {
		return requiereLongitd;
	}

	public void setRequiereLongitd(boolean requiereLongitd) {
		this.requiereLongitd = requiereLongitd;
	}

	public byte[] getBytesNombre() {
		return bytesNombre;
	}

	public void setBytesNombre(byte[] bytesNombre) {
		this.bytesNombre = bytesNombre;
		nombre = new String(bytesNombre);
	}

	public TipoDato getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(TipoDato tipoDato) {
		this.tipoDato = tipoDato;
	}

}
