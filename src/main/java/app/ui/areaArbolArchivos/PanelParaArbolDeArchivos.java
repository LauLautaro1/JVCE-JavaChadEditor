package app.ui.areaArbolArchivos;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelParaArbolDeArchivos extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public PanelParaArbolDeArchivos() {
		
		//Por ahora esto es prueba, luego se cambiara por un arbol de archivos
		JButton boton = new JButton("Arbol");
		boton.setSize(100, 50);
		add(boton);
	}
	

}
