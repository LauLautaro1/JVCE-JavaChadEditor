package app.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.SyntaxScheme;
import org.fife.ui.rsyntaxtextarea.Token;

import app.enums.ColoresPlantillas;
import app.snippets.SnippetsKey;
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
	
	private SnippetsManager<SnippetsKey> snippetsManager;
	
	
	//---------- Constructor ----------
	
	public CodeArea() {
		//LLamamos a los métodos de configuración
		configuracionDeSyntax();
		configuracionDeEstilo();
		configurarSnippets();
		
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
		setFont(new Font("Consolas", Font.PLAIN, 14));
		setMargin(new Insets(5, 5, 5, 5));
		setBackground(java.awt.Color.black);
		setForeground(java.awt.Color.white);
		setCaretColor(java.awt.Color.red);
	}
	
	public static void configurarColores(RSyntaxTextArea codeArea) {
		
		Color[] c = ColoresPlantillas.getColoresAreaDeCodigo();

	    codeArea.setBackground(c[0]);
	    codeArea.setForeground(c[2]);
	    codeArea.setCaretColor(c[13]);
	    codeArea.setSelectionColor(c[12]);

	    SyntaxScheme scheme = codeArea.getSyntaxScheme();
	    scheme.getStyle(Token.RESERVED_WORD).foreground = c[3];
	    scheme.getStyle(Token.DATA_TYPE).foreground = c[4];
	    scheme.getStyle(Token.LITERAL_STRING_DOUBLE_QUOTE).foreground = c[5];
	    scheme.getStyle(Token.COMMENT_EOL).foreground = c[6];
	    scheme.getStyle(Token.COMMENT_MULTILINE).foreground = c[6];
	    scheme.getStyle(Token.LITERAL_NUMBER_DECIMAL_INT).foreground = c[7];
	    scheme.getStyle(Token.OPERATOR).foreground = c[8];
	    scheme.getStyle(Token.ERROR_IDENTIFIER).foreground = c[9];
	    scheme.getStyle(Token.FUNCTION).foreground = c[10];
	    scheme.getStyle(Token.IDENTIFIER).foreground = c[11];

	    codeArea.repaint();
	}
	
	//---------- Snippets ----------
	
	private void configurarSnippets() {
		
		//Creamos la clase SnippetsManager con un mapa vacío y la clase SnippetsKey
		snippetsManager = new SnippetsManager<>(new HashMap<SnippetsKey, String>(), SnippetsKey.class);
		
		//Aqui agregariamos los snippets, por ejemplo:
		snippetsManager.loadFromJson(SnippetsLoader.cargarJsonDesdeRecursos("json/snippetsPrueba.json"));
		
		
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
	
	private void usarSnippets() {
		//Agarramos la palabra antes del cursor
		String actualPalabra = obtenerPalabraAntesDelCaret();
		
		if (actualPalabra == null || actualPalabra.isEmpty()) return;

		//Buscando snippets por aproximación
		try {
			for (SnippetsKey key : SnippetsKey.values()) {
				if (key.name().toLowerCase().startsWith(actualPalabra.toLowerCase())) {
					String snippet = snippetsManager.getSnippet(key);
					if (snippet != null) {
						reemplazarPalabraPorSnippet(snippet, actualPalabra.length());
					}
					break;		
				}	
			}
			
		} catch (IllegalArgumentException ex) {}
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

	private void reemplazarPalabraPorSnippet(String snippet, int largoPalabra) {
		try {
			int pos = getCaretPosition();
			int start = pos - largoPalabra;
			getDocument().remove(start, largoPalabra);
			getDocument().insertString(start, snippet, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
