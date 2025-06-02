package app.ui.areaCode.recreando;

import javax.swing.JFrame;

public class PruebaMain {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Prueba Recreando");
		EditorCodigo textArea = new EditorCodigo();
		ScrollComponente scrollPane = new ScrollComponente(textArea);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.add(scrollPane);
		frame.setVisible(true);
		
		
	}

}
