package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
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
		ventana.crearCodeArea("prueba.java");
		ventana.crearCodeArea("prueba2.java");
		ventana.crearCodeArea("prueba3.java");
		ventana.crearCodeArea("prueba4.java");
		ventana.crearCodeArea("prueba5.java");
		ventana.crearCodeArea("prueba6.java");
		
		ventana.setVisible(true);
		
		//Creando Prueba de ArchivosManager
//		ArchivosManager fileManager = new ArchivosManager();
		
//		fileManager.abrirArchivo("src/main/java/app/ui/CodeArea.java", ventana.getCodeArea("a"));

		
		
	}

}
