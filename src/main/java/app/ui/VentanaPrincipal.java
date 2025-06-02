package app.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;

import app.enums.ColoresPlantillas;
import app.files.FontLoader;
import app.ui.areaArbolArchivos.PanelParaArbolDeArchivos;
import app.ui.areaCode.CodeArea;
import app.ui.areaCode.PanelCodeAreas;
import app.ui.areaNavegacion.PanelParaNavegar;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	
	private PanelCodeAreas panelCode;
	
	private static Font fuenteDeTexto = FontLoader.cargarFuenteNerd(16);
	private static Font fuenteDeTextoChica = FontLoader.cargarFuenteNerd(12);

	//---------- Constructor ----------
	
	public VentanaPrincipal() {
		
		//Setteando la ventana
		setTitle("JavaChadEditor");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		//Setteando la barra moderna
		crearPanelCodeAreas();
		
		PanelParaNavegar p = new PanelParaNavegar(fuenteDeTextoChica);
		
		getContentPane().add(p, BorderLayout.NORTH);
		
//		PanelParaArbolDeArchivos panelArbol = new PanelParaArbolDeArchivos();
//		
//		getContentPane().add(panelArbol, BorderLayout.WEST);
		
		
	}
	
	//---------- Metodos ----------
	
	private void crearPanelCodeAreas() {
		this.panelCode = new PanelCodeAreas(this , fuenteDeTexto);
		getContentPane().add(panelCode, BorderLayout.CENTER);
	}
	
	public void crearCodeArea(String nombreArchivo) {
		panelCode.agregarPestania(nombreArchivo);
	}
	
	public CodeArea getCodeArea(String nombreArchivo) {
		return panelCode.getCodeArea(nombreArchivo);
	}

}
