package app.files;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;


/**
 * FontLoader es una clase que se encarga de cargar fuentes personalizadas. En
 * este caso, carga una fuente llamada "nerdFont.ttf" desde el classpath. Si la
 * fuente no se encuentra, utiliza una fuente por defecto (Consolas).
 */
public class FontLoader {
	
	public static Font cargarFuenteNerd(int tamaño) {
        try {
            InputStream is = FontLoader.class.getClassLoader().getResourceAsStream("font/JetBrainsMonoNLNerdFont-Regular.ttf");
            if (is == null) {
                throw new RuntimeException("No se encontró el archivo de fuente");
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont((float) tamaño);

            // Registrar la fuente en el sistema gráfico
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            return font;

        } catch (Exception e) {
            e.printStackTrace();
            // Fallback a Consolas
            return new Font("Consolas", Font.PLAIN, tamaño);
        }
    }

}
