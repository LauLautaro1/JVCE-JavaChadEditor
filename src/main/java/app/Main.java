package app;

import app.files.ArchivosManager;
import app.ui.VentanaPrincipal;

//---------- MAIN ----------

public class Main {

	public static void main(String[] args) {
		
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		
		//Creando Prueba de ArchivosManager
		ArchivosManager fileManager = new ArchivosManager(ventana.getCodeArea());
		fileManager.abrirArchivo("src/main/java/app/ui/CodeArea.java");
		
	}

}
