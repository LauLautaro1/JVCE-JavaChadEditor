package app.snippets;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//Clase para cargar snippets desde archivos JSON situados en la carpeta recursos.
public class SnippetsLoader {
	
	
	/**
	 * Carga un archivo JSON desde la carpeta de recursos.
	 *
	 * @param ruta Ruta del archivo JSON dentro de la carpeta de recursos.
	 * @return Contenido del archivo JSON como una cadena.
	 * @throws RuntimeException Si no se encuentra el archivo.
	 */
	public static String cargarJsonDesdeRecursos(String ruta) {
		//Validamos la ruta del archivo
		if (ruta == null || ruta.isEmpty()) {
			throw new IllegalArgumentException("La ruta del archivo no puede ser nula o vacía.");}
		
		
		InputStream is = SnippetsLoader.class.getClassLoader().getResourceAsStream(ruta);
		
		if (is == null) {throw new RuntimeException("No se encontró el archivo: " + ruta);}
		
		//Leemos el contenido del archivo usando Scanner, y lo convertimos a String
		try (Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name())) {
			return scanner.useDelimiter("\\A").next();
		}
	}
}
