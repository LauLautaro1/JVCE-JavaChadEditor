package app.ui.areaCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;

import app.enums.ColoresPlantillas;
import app.snippets.Snippets;
import app.snippets.SnippetsLoader;
import app.snippets.SnippetsManager;




/**
 * CodeArea es una clase que extiende RSyntaxTextArea para proporcionar un área de código
 * con características de resaltado de sintaxis y estilo personalizado.
 * Esta clase configura el área de código para Java,
 * incluyendo características como el plegado de código,
 */
public class CodeArea extends RSyntaxTextArea{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	
	private SnippetsManager snippetsManager;
	
	private Font fuenteDeTexto;
	
	//---------- Constructor ----------
	
	public CodeArea(Font fuenteDeTexto){
		
		this.fuenteDeTexto = fuenteDeTexto;
		
		//LLamamos a los métodos de configuración
		configuracionDeSyntax();
		configuracionDeEstilo();
		configurarSnippets();
		configurarColores();
		
		
		//Configuración adicional

		setTabSize(4);
		setLineWrap(true);
		setWrapStyleWord(true);
		setCaretPosition(0);
		setLineWrap(true);
		
	}
	
	//---------- Métodos de configuración ----------
	
	private void configuracionDeSyntax() {
		setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		setCodeFoldingEnabled(true);
		setAntiAliasingEnabled(true);
		setHighlightCurrentLine(true);
		setAutoIndentEnabled(true);
		setBracketMatchingEnabled(true);
		setCloseCurlyBraces(true);
		setCloseMarkupTags(true);
		setAnimateBracketMatching(true);
		
	}
	
	private void configuracionDeEstilo() {
		setCurrentLineHighlightColor(new Color(0 , 0, 0));
		
		setMargin(new Insets(5, 5, 5, 5));

	}
	
	public void configurarColores() {
		
		
		
		Color[] c = ColoresPlantillas.getColoresAreaDeCodigo();
		
		// Aplicar fondo, texto, selección, cursor
	    setBackground(c[0]);
	    setForeground(c[2]);
	    setCaretColor(c[13]);
	    setSelectionColor(c[12]);

	    // Crear esquema de sintaxis
	    SyntaxScheme scheme = new SyntaxScheme(true);

	    // Asignar colores específicos a estilos de tokens
	    scheme.getStyle(Token.RESERVED_WORD).foreground = c[3];
	    scheme.getStyle(Token.RESERVED_WORD_2).foreground = c[3];
	    scheme.getStyle(Token.DATA_TYPE).foreground = c[4];
	    scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = c[5];

	    scheme.getStyle(Token.COMMENT_EOL).foreground = c[6];
	    scheme.getStyle(Token.COMMENT_MULTILINE).foreground = c[6];
	    scheme.getStyle(Token.COMMENT_DOCUMENTATION).foreground = c[6];
	    scheme.getStyle(Token.COMMENT_KEYWORD).foreground = c[6];
	    scheme.getStyle(Token.MARKUP_COMMENT).foreground = c[6];

	    scheme.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = c[7];
	    scheme.getStyle(Token.LITERAL_NUMBER_FLOAT).foreground = c[7];
	    scheme.getStyle(Token.LITERAL_NUMBER_HEXADECIMAL).foreground = c[7];
	    
	    scheme.getStyle(Token.SEPARATOR).foreground = c[3];
	    
	    scheme.getStyle(Token.OPERATOR).foreground = c[8];
	    scheme.getStyle(Token.ERROR_IDENTIFIER).foreground = c[9];
	    scheme.getStyle(Token.FUNCTION).foreground = c[10];
	    scheme.getStyle(Token.IDENTIFIER).foreground = c[11];

	    setSyntaxScheme(scheme);
	    
		setFont(fuenteDeTexto);
	    
	    repaint();	
	}

	
	//---------- Snippets ----------
	
	private void configurarSnippets() {
		
		//Creamos la clase SnippetsManager con un mapa vacío y la clase SnippetsKey
		snippetsManager = new SnippetsManager();
		
		//Aqui agregariamos los snippets, por ejemplo:
		snippetsManager.loadFromJson(SnippetsLoader.cargarJsonDesdeRecursos("json/SnippetsJava.json"));
		
		
		//Creamos la logica de los snippets, el control todo.
		crearListenerDeSnippets();
		
	}
	
	private void crearListenerDeSnippets() {
		
		// Aquí se puede implementar un listener para detectar cuando se invocan
		// snippets
		// y reemplazar el texto en el área de código con el snippet correspondiente.
		// Por ejemplo, al presionar una tecla específica o al escribir un prefijo.

		this.addKeyListener((KeyListener) new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// Aquí podés poner el trigger, por ejemplo Tab o Ctrl+Espacio
				if (e.getKeyCode() == KeyEvent.VK_SPACE && (e.isControlDown())) {
					usarSnippets();
				}
			}
		});
		
	}
	
	//Buscamos los snippets que coincidan con la palabra antes del cursor. esto es por aproximacion o exactitud.
	private void usarSnippets() {
	    // Agarramos la palabra antes del cursor
	    String actualPalabra = obtenerPalabraAntesDelCaret();

	    if (actualPalabra == null || actualPalabra.isEmpty()) return;

	    // Buscamos claves de snippets
	    LinkedList<String> keys = snippetsManager.getKeys();
	    Snippets mejorCoincidencia = null;

	    for (String key : keys) {
	        // Coincidencia exacta (prioritaria)
	        if (key.equalsIgnoreCase(actualPalabra)) {
	            Snippets snippet = snippetsManager.getSnippet(key);
	            if (snippet != null) {
	                reemplazarPalabraPorSnippet(snippet.getValue(), actualPalabra.length());
	                return;
	            }
	        }

	        // Coincidencia parcial: empieza igual
	        if (key.toLowerCase().startsWith(actualPalabra.toLowerCase())) {
	            mejorCoincidencia = snippetsManager.getSnippet(key);
	        }
	    }

	    // Si encontramos una coincidencia parcial
	    if (mejorCoincidencia != null) {
	        reemplazarPalabraPorSnippet(mejorCoincidencia.getValue(), actualPalabra.length());
	    }
	}
		
	
	private String obtenerPalabraAntesDelCaret() {
		//obtenemos la posición del caret (cursor)
		int caret = getCaretPosition();
		try {
			int start = caret - 1;
			while (start >= 0 && Character.isJavaIdentifierPart(getText(start, 1).charAt(0))) {
				start--;
			}
			start++;
			return getText(start, caret - start);
		} catch (Exception ex) {
			return null;
		}
	}

	private void reemplazarPalabraPorSnippet(String valor, int largoPalabra) {
		try {
			int pos = getCaretPosition();
			int start = pos - largoPalabra;
			getDocument().remove(start, largoPalabra);
			getDocument().insertString(start, valor, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
