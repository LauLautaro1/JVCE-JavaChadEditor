package app.ui.areaCode;

import java.awt.Font;
import java.util.Map;
import javax.swing.JTabbedPane;

public class Pestanias extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	
	private Font fuenteOriginal;//Fuente original que se usara para los CodeAreas, por que nosotros en la pestania vamos a cambiarle el tamano.
	
	
	//---------- Constructor ----------
	
	public Pestanias(Font fuente) {
		super();
		
		this.fuenteOriginal = fuente;
		Font font = new Font(fuente.getName(), Font.BOLD, 9);;
		setFont(font);	
	}
	
	//---------- Metodos ----------
	
	
	/**
	 * Agrega una nueva pestaña con un CodeArea y un Scroll asociado.
	 * 
	 * @param nombreArchivo El nombre del archivo (pestaña) a agregar.
	 */
	public void agregarPestania(String nombreArchivo) {
		CodeArea codeArea = new CodeArea(fuenteOriginal);
		Scroll scroll = new Scroll(codeArea, fuenteOriginal);
		addTab(nombreArchivo, scroll);
		setSelectedComponent(getComponentAt(getTabCount() - 1));
		add(nombreArchivo,scroll);
	}

	
	/**
	 * Obtiene el CodeArea asociado a una pestaña por su nombre.
	 * 
	 * @param nombreArchivo El nombre del archivo (pestaña) para buscar.
	 * @return El CodeArea asociado a la pestaña, o null si no se encuentra.
	 */
	public CodeArea getCodeArea(String nombreArchivo) {
		for (int i = 0; i < getTabCount(); i++) {
	        String titulo = getTitleAt(i);
	        if (titulo.equals(nombreArchivo)) {
	            Scroll scroll = (Scroll) getComponentAt(i);
	            return scroll.getCodeArea();
	        }
	    }
	    return null; // No encontrado
	}

}
