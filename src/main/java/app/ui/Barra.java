package app.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.enums.ColoresPlantillas;

/**
 * BarraModerna es una clase que representa una barra de título personalizada
 * para una ventana. Permite cerrar la ventana y moverla arrastrando la barra.
 */
public class Barra extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	
	private JFrame padre;
	
	private Font fuenteDetexto;

	//---------- Constructor ----------
	
	public Barra(JFrame frame , Font fuenteDeTexto) {
		
		this.fuenteDetexto = fuenteDeTexto;
		
		this.padre = frame;
		
		Color[] colores = ColoresPlantillas.getColoresBarra();
        
        setPreferredSize(new java.awt.Dimension(800, 20));
        setLayout(new java.awt.BorderLayout());
        
	}
	
}
