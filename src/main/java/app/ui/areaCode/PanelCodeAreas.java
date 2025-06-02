package app.ui.areaCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import app.enums.ColoresPlantillas;

/**
 * BarraModerna es una clase que representa una barra de título personalizada
 * para una ventana. Permite cerrar la ventana y moverla arrastrando la barra.
 */
public class PanelCodeAreas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	
	private Pestanias pestanias;

	//---------- Constructor ----------
	
	//por ahora le pasamos el JFrame como parametro quizas despues lo quito.
	public PanelCodeAreas(JFrame frame , Font fuenteDeTexto) {
		
		setLayout(new BorderLayout());
        
        this.pestanias = new Pestanias(fuenteDeTexto);
        
        add(pestanias , BorderLayout.CENTER);
        
	}
	
	//---------- Metodos ----------
	
	public void agregarPestania(String nombre) {
		this.pestanias.agregarPestania(nombre);
	}
	// Devuelve el CodeArea actual, para saber donde estamos situados
    public CodeArea getCodeAreaActual() {
        JScrollPane scroll = (JScrollPane) pestanias.getSelectedComponent();
        return (CodeArea) scroll.getViewport().getView();
    }
	

	public JTabbedPane getTabbedPane() {
		return this.pestanias;
	}

	public CodeArea getCodeArea(String nombreArchivo) {
		return this.pestanias.getCodeArea(nombreArchivo);
	}
	
}
