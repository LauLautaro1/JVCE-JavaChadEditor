package app.ui.areaCode.recreando;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JTextArea;

public class EditorCodigo extends JTextArea {

	private static final long serialVersionUID = 1L;

	//---------- Variables ----------
	
	//---------- Constructor ----------
	
	public EditorCodigo() {
		super();
		configuracionInicial();
	}
	
	//---------- Metodos ----------
	
	private void configuracionInicial() {
		setLineWrap(true);
		setWrapStyleWord(true);
		setMargin(new Insets(5, 5, 5, 5));
		setBackground(Color.black);
		setForeground(Color.white);
		setCaretColor(Color.white);
		
	}

	@Override
	public void setText(String t) {
		super.setText(t.replaceAll("\n", "\n\n"));
	}
	
	

}
