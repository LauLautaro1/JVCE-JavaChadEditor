package app.snippets;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * SnippetsManager gestiona snippets de código mediante claves de tipo String.
 * Es flexible y permite agregar, obtener y cargar snippets desde un JSON,
 * facilitando la escalabilidad del proyecto.
 */
public class SnippetsManager {

    //---------- Variables ----------
    private final Map<String, Snippets> snippets = new HashMap<>();
    private LinkedList<String> keys = new LinkedList<>();

    //---------- Métodos ----------

    /**
     * Agrega un snippet con una clave específica.
     *
     * @param key     la clave única del snippet (por ejemplo: "IF", "FOR")
     * @param snippet el objeto Snippets con los datos del snippet
     */
    public void addSnippet(String key, Snippets snippet) {
        if (key == null || snippet == null) {
            throw new IllegalArgumentException("La clave o el snippet no pueden ser nulos.");
        }
        snippets.put(key, snippet);
    }

    /**
     * Obtiene el snippet asociado a una clave.
     *
     * @param key la clave del snippet
     * @return el snippet asociado o null si no existe
     */
    public Snippets getSnippet(String key) {
        return snippets.get(key);
    }

    /**
     * Verifica si existe un snippet para la clave dada.
     *
     * @param key la clave a verificar
     * @return true si existe, false si no
     */
    public boolean hasSnippet(String key) {
        return snippets.containsKey(key);
    }

    /**
     * Carga múltiples snippets desde un JSON.
     * Cada objeto del JSON debe tener al menos un campo 'key' válido.
     *
     * @param json el JSON como String que contiene un array de snippets
     */
    public void loadFromJson(String json) {
        if (json == null || json.isEmpty()) {
            throw new IllegalArgumentException("El JSON no puede ser nulo o vacío.");
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            // Carga una lista de snippets desde el JSON
            var snippetList = mapper.readValue(json, new TypeReference<java.util.List<Snippets>>() {});

            for (Snippets snippet : snippetList) {
                if (snippet.getKey() != null) {
                	keys.add(snippet.getKey());
                    snippets.put(snippet.getKey(), snippet);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar los snippets desde JSON: " + e.getMessage(), e);
        }
    }
    
    /**
     * retornar todas las keys
     */
    public LinkedList<String> getKeys() {
        return keys;
    }
    
    /**
     * Retornar todos los snippets
     */
    public List<Snippets> getSnippets() {
		return new LinkedList<>(snippets.values());
	}
}