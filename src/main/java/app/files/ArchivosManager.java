package app.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

/**
 * ArchivosManager es una clase que maneja la apertura y guardado de archivos en
 * un editor de texto basado en RSyntaxTextArea.
 */
public class ArchivosManager {
	
	//---------- Variables ----------
	
	private RSyntaxTextArea editor;

	//---------- Constructor ----------
	
    public ArchivosManager(RSyntaxTextArea editor) {
        this.editor = editor;
    }
    
	//---------- Metodos ----------

    public void abrirArchivo(String ruta) {
        try {
            String contenido = Files.readString(Paths.get(ruta));
            editor.setText(contenido);
            editor.setCaretPosition(0); // Para ir al principio del texto
        } catch (IOException e) {
            e.printStackTrace();
            editor.setText("// Error al abrir el archivo: " + e.getMessage());
        }
    }
    
	public void guardaArchivo(String ruta) {
		try {
			Files.writeString(Paths.get(ruta), editor.getText());
		} catch (IOException e) {
			e.printStackTrace();
			editor.setText("// Error al guardar el archivo: " + e.getMessage());
		}
	}
}
