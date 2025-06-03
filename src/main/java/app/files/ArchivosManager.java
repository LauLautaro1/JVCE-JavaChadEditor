package app.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import app.snippets.SnippetsLoader;

/**
 * ArchivosManager es una clase que maneja la apertura y guardado de archivos en
 * un editor de texto basado en RSyntaxTextArea.
 */
public class ArchivosManager {
	
	//---------- Variables ----------

	//---------- Constructor ----------
	
    public ArchivosManager() {
    }
    
	//---------- Metodos ----------

    public void abrirArchivo(String ruta , RSyntaxTextArea editor) {
        try {
            String contenido = Files.readString(Paths.get(ruta));
            editor.setText(contenido);
            editor.setCaretPosition(0); // Para ir al principio del texto
        } catch (IOException e) {
            e.printStackTrace();
            editor.setText("// Error al abrir el archivo: " + e.getMessage());
        }
    }
    
	public void guardaArchivo(String ruta , RSyntaxTextArea editor) {
		try {
			Files.writeString(Paths.get(ruta), editor.getText());
		} catch (IOException e) {
			e.printStackTrace();
			editor.setText("// Error al guardar el archivo: " + e.getMessage());
		}
	}
	
	//Json loader, mediante una ruta indicada devuelve un String.
	public static String cargarJsonDesdeRecursos(String ruta) {
		if (ruta == null || ruta.isEmpty()) {
            throw new IllegalArgumentException("La ruta del archivo no puede ser nula o vacía.");
        }

        // Intenta cargar el recurso desde el classpath
        InputStream inputStream = ArchivosManager.class.getClassLoader().getResourceAsStream(ruta);
        if (inputStream == null) {
            throw new IllegalArgumentException("No se pudo encontrar el archivo en la ruta: " + ruta);
        }

        // Leer el contenido como String
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            scanner.useDelimiter("\\A"); // Lee todo el contenido
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}
