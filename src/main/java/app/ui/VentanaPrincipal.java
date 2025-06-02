package app.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;

import app.enums.ColoresPlantillas;
import app.files.FontLoader;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	
	private PanelCodeAreas panelCode;
	
	private static Font fuenteDeTexto = FontLoader.cargarFuenteNerd(14);

	//---------- Constructor ----------
	
	public VentanaPrincipal() {
		
		//Setteando la ventana
		setTitle("JVCE-JavaChadEditor");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		//Setteando la barra moderna
		crearPanelCodeAreas();
		
		PanelParaNavegar p = new PanelParaNavegar();
		
		getContentPane().add(p, BorderLayout.NORTH);
		
		
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
