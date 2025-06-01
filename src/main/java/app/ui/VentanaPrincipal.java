package app.ui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;

import app.enums.ColoresPlantillas;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	private CodeArea codeArea;
	
	private static Font fuenteDeTexto = app.files.FontLoader.cargarFuenteNerd(14);

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
		Barra barra = new Barra(this , fuenteDeTexto);
		
		getContentPane().add(barra, BorderLayout.NORTH);

		//Setteando el área de código
		codeArea = new CodeArea(fuenteDeTexto);

		
		Scroll scrollPane = new Scroll(codeArea);
		
		getContentPane().add(scrollPane , BorderLayout.CENTER);
		
	}
	
	//---------- Getters y Setters ----------
	public CodeArea getCodeArea() {
		return codeArea;
	}

}
