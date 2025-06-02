package app.ui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelParaNavegar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ---------- Constructor ----------

	public PanelParaNavegar() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(new JButton("Boton 1"));
		add(new JButton("Boton 2"));
		add(new JButton("Boton 3"));
		add(new JButton("Boton 4"));
		
	}

}
