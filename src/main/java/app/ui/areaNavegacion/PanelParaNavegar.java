package app.ui.areaNavegacion;


import app.ui.areaNavegacion.*;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class PanelParaNavegar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	// ---------- Variables ----------
	private JMenuBar menuBar;
	
	// ---------- Constructor ----------

	public PanelParaNavegar(Font fuente) {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		inicializarMenus(fuente);
	}
	
	private void inicializarMenus(Font fuente) {
		menuBar = new JMenuBar();
		MenuArchivo menuArchivo = new MenuArchivo(fuente);
		MenuEditar menuEditar = new MenuEditar(fuente);
		
		menuBar.add(menuArchivo);
		menuBar.add(menuEditar);
		
		add(menuBar);
		
	
	}

}
