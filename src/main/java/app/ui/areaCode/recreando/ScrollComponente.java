package app.ui.areaCode.recreando;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

import org.fife.ui.rtextarea.RTextScrollPane;

/*
 * Clase dedicada a crear un JScrollPane personalizado para el editor de código.
 */
public class ScrollComponente extends JScrollPane {

	private static final long serialVersionUID = 1L;

	// ---------- Variables ----------
	private NumeroLineas numerosEditor;
	private final EditorCodigo editor;
	// ---------- Constructor ----------

	public ScrollComponente(EditorCodigo editor) {
		super(editor);
		if (editor == null) {
			throw new IllegalArgumentException("El editor no puede ser nulo");
		}
		this.editor = editor;
		configuracionInicial();
		configurarNumerosLineas();
	}
	
	// ---------- Metodos ----------
	
	private void configuracionInicial() {
		setBorder(BorderFactory.createEmptyBorder());//establece el borde vacio)
		//Quitando las barras vertical y horizontal de desplazamiento
		setVerticalScrollBarPolicy(RTextScrollPane.VERTICAL_SCROLLBAR_NEVER);
		setHorizontalScrollBarPolicy(RTextScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	// ---------- NumerosLineas ----------
	
	private void configurarNumerosLineas() {
		numerosEditor = new NumeroLineas(editor);
		setRowHeaderView(numerosEditor);
	}
	
	public void desactivarNumerosLineas() {
		setRowHeaderView(null);
	}
	
	public void activarNumerosLineas() {
		if (numerosEditor == null) {
			configurarNumerosLineas();
		} else {
			setRowHeaderView(numerosEditor);
		}
	}
	
	//Llamando a funciones de NumerosLineas
	public void setFontNumeroLinea(Font font) {
    	if (font == null) {
    		throw new IllegalArgumentException("La fuente no puede ser nula");
    	}
    	this.numerosEditor.setFont(font);
    }
    
	public void setLineNumberColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("El color no puede ser nulo");
		}
		this.numerosEditor.setLineNumberColor(color);
	}

	public Color getLineNumberColor() {
		return numerosEditor.getLineNumberColor();
	}

	public void setBackgroundColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("El color no puede ser nulo");
		}
		this.numerosEditor.setBackgroundColor(color);
	}

	public Color getBackgroundColor() {
		return numerosEditor.getBackgroundColor();

	}
	
}
