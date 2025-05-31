package app.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.autocomplete.CompletionProvider;

import app.snippets.Snippets;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	private CodeArea codeArea;

	//---------- Constructor ----------
	
	public VentanaPrincipal() {
		//Setteando la ventana
		setTitle("Ventana Principal");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setUndecorated(true); // sin bordes
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Setteando la barra moderna
		BarraModerna barra = new BarraModerna(this);
		getContentPane().add(barra, BorderLayout.NORTH);

		//Setteando el área de código
		codeArea = new CodeArea();
		CodeArea.configurarColores(codeArea);
		Scroll scrollPane = new Scroll(codeArea);
		getContentPane().add(scrollPane , BorderLayout.CENTER);
		
		//Setteando el autocompletado/Snippets
        CompletionProvider provider = Snippets.createCompletionProvider();
        AutoCompletion ac = new AutoCompletion(provider);
        ac.setAutoActivationEnabled(true); // activa al escribir
        ac.setAutoActivationDelay(300);    // 300 ms de retardo
        ac.setAutoCompleteSingleChoices(true); // autocompletar si hay una sola opción);
        ac.install(codeArea);
	}
	
	//---------- Getters y Setters ----------
	public CodeArea getCodeArea() {
		return codeArea;
	}

}
