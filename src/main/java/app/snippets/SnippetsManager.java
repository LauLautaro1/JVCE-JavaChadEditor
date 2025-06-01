package app.snippets;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * SnippetsManager es una clase genérica que permite gestionar snippets de
 * código asociados a claves de tipo enumeración. Proporciona métodos para
 * agregar, obtener y verificar la existencia de snippets, así como para cargar
 * snippets desde un JSON.
 *
 * @param <T> el tipo de enumeración que define las claves de los snippets, en este caso usaremos el enum SnippetsKey
 */
public class SnippetsManager<T extends Enum<T>> {

	//---------- Variables ----------
	
	private final Map<T, String> snippets;
	private final Class<T> enumType;
	

	//---------- Constructor ----------
	
	public SnippetsManager(Map<T, String> snippets , Class<T> enumType) {
		if (snippets == null || enumType == null) {
			throw new IllegalArgumentException("los snippets o el tipo de enumeración no pueden ser nulos");
		}
		
		this.snippets = snippets;
		this.enumType = enumType;
		
	}
	
	//---------- Metodos ----------

	/**
	 * Agrega un nuevo snippet asociado a la clave proporcionada.
	 *
	 * @param key     la clave del snippet
	 * @param snippet el contenido del snippet
	 */
	public void addSnippet(T key, String snippet) {
		if (key == null || snippet == null) {
			throw new IllegalArgumentException("la clave o el snippet no pueden ser nulos");
		}
		snippets.put(key, snippet);
	}
	
	/**
	 * Obtiene el snippet asociado a la clave proporcionada.
	 *
	 * @param key la clave del snippet
	 * @return el snippet asociado a la clave, o null si no existe
	 */
	public String getSnippet(T key) {
		if (key == null) {
			throw new IllegalArgumentException("la clave no puede ser nula");
		}
		return snippets.get(key);
	}

	/**
	 * Verifica si un snippet existe para la clave proporcionada.
	 *
	 * @param key la clave del snippet
	 * @return true si el snippet existe, false en caso contrario
	 */
	public boolean hasSnippet(T key) {
		if (key == null) {
			throw new IllegalArgumentException("la clave no puede ser nula");
		}
		return snippets.containsKey(key);
	}
	
	/**
	 * cargar snippets con JSON
	 * @param json el JSON que contiene los snippets
	 * el parametro de json lo podemos cargar con la funcion de la clase SnippetsLoader.loadJsonFromFile()
	 */
	public void loadFromJson(String json) {
		//Validamos.
		if (json == null || json.isEmpty()) {throw new IllegalArgumentException("el JSON no puede ser nulo o vacío");}
		
		
		//Creamos un Gson para deserializar el JSON.
		Gson gson = new Gson();
		
		//Cargamos el JSON en un mapa de claves y valores.
		Type mapType = new TypeToken<Map<String, String>>() {}.getType();
		Map<String, String> rawSnippets = gson.fromJson(json, mapType);

		//Validamos que se hayan cargado los snippets.
		if (rawSnippets == null) {throw new IllegalArgumentException("No se pudieron cargar los snippets desde el JSON");}

		
		for (Map.Entry<String, String> entry : rawSnippets.entrySet()) {
			try {
				T key = Enum.valueOf(enumType, entry.getKey());
				snippets.put(key, entry.getValue());
			} catch (IllegalArgumentException e) {
				System.err.println("Clave de snippet inválida (ignorada): " + entry.getKey());
			}
		}
	}
	
}
