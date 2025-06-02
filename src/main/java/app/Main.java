package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import app.files.ArchivosManager;
import app.ui.VentanaPrincipal;

//---------- MAIN ----------

public class Main {

	public static void main(String[] args) {
		// Aplicar FlatLaf antes de construir componentes
		//esto es para usar la libreria flat para poner el JFrame en oscuro
		try {UIManager.setLookAndFeel(new FlatMacDarkLaf()); // Cambiá por otro si querés
		} catch (UnsupportedLookAndFeelException e) {e.printStackTrace();}
		
		
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		
		//Creando Prueba de ArchivosManager
		ArchivosManager fileManager = new ArchivosManager();
		ventana.crearCodeArea("a");
		fileManager.abrirArchivo("src/main/java/app/ui/CodeArea.java", ventana.getCodeArea("a"));

		
		
	}

}
