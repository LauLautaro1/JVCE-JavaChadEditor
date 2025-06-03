package app.ui.areaCode.recreando;

import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Matcher;

import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import app.sintaxis.EstilosEnum;
import app.sintaxis.ReglaEstilo;

public class EditorCodigo extends JTextPane {

	private static final long serialVersionUID = 1L;

	//---------- Variables ----------
	
	private final StyledDocument doc;
    
    private StyleContext styleContext = StyleContext.getDefaultStyleContext();

    // Definición de las reglas de estilo, los predeterminados son los siguientes:
    private AttributeSet normalStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);
    private AttributeSet keywordStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0x569CD6));
    private AttributeSet commentStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0x6A9955));
    private AttributeSet stringStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0xCE9178));
    private AttributeSet numberStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0xB5CEA8));
    private AttributeSet functionStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0xDCDCAA));
	
    //lista de todos los estilo, el cual vamos a utilizar para resaltar el texto.
    private List<ReglaEstilo> reglasEstilo = new ArrayList<>();
    
    private String[] regexEstilos;
    
    // Mapa para almacenar los estilos con sus correspondientes Enum, tiene tamaño fijo el cual son la cantidad de reglas de estilo.
    private final EnumMap<EstilosEnum, AttributeSet> mapaEstilos = new EnumMap<>(EstilosEnum.class);
    
	//---------- Constructor ----------
	
	public EditorCodigo() {
		super();
		doc = getStyledDocument();
        configurarListener();
        configuracionInicial();
        configuracionInicialDeEstilo();
        
        setBackground(Color.BLACK);
	}
	
	//---------- Metodos ----------
	
	private void configuracionInicial() {
		setMargin(new Insets(5, 5, 5, 5));
	}

	//---------- Seccion de Estilos
	
	//Configuracion inicial de estilo.
	private void configuracionInicialDeEstilo() {
		// Agregar estilos predeterminados
        
	}
	
	public void definirElRegexDeLosEstilos() {
		if (regexEstilos == null) {
			this.regexEstilos = new String[6];
		}
		
		
		
		
	}
	
	public void agregarColoresATodosLosEstilos(Color color1, Color color2, Color color3, Color color4, Color color5, Color color6) {
		agregarEstilosResaltado(EstilosEnum.normalStyle, ".*", color1);
        agregarEstilosResaltado(EstilosEnum.keywordStyle, "\\b(if|else|while|for|return|function)\\b", color2);
        agregarEstilosResaltado(EstilosEnum.commentStyle, "//.*|/\\*.*?\\*/", color3);
        agregarEstilosResaltado(EstilosEnum.stringStyle, "\".*?\"", color4);
        agregarEstilosResaltado(EstilosEnum.numberStyle, "\\b\\d+(\\.\\d+)?\\b", color5);
        agregarEstilosResaltado(EstilosEnum.functionStyle, "\\b\\w+\\s*\\(.*?\\)", color6);
	}
	
	
    
    //Funcion para agregar los estilos.
	private void agregarEstilosResaltado(EstilosEnum estilo, String regex , Color color) {
		// Validamos datos:
		if (regex == null || regex.isEmpty() || color == null) {
			throw new IllegalArgumentException("El regex y el color no pueden ser nulos o vacíos.");
		}
		AttributeSet estiloAplicado = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
		mapaEstilos.put(estilo, estiloAplicado);
		ReglaEstilo regla = new ReglaEstilo(regex, estiloAplicado );
		reglasEstilo.add(regla);
	}
	
	//metodo para actualizar estilo.
	public void modificarColorDeEstiloExistente(EstilosEnum estilo , Color color) {
		// Validamos datos:
		if (color == null || estilo == null) {
			throw new IllegalArgumentException("El color y el estilo no pueden ser nulos.");
		}
		//Una vez que encuentra el estilo a modificar lo modifica.
		for (ReglaEstilo regla : reglasEstilo) {
			if (regla.estilo.equals(mapaEstilos.get(estilo))) {
				regla.estilo = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
				mapaEstilos.put(estilo, regla.estilo);
				resaltar();
				return; // Salir del bucle una vez que se ha modificado el estilo.
			}
		}
	}
	
	//---------- Resaltar
	
	// Resaltado en tiempo real, esto es para detectar cambios en el editor de texto.
    private void configurarListener() {
        doc.addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { resaltar(); }
            public void removeUpdate(DocumentEvent e) { resaltar(); }
            public void changedUpdate(DocumentEvent e) {}
        });
    }
    
    // Configuración de la fuente, para resaltar palabras clave.
    private void resaltar() {
        SwingUtilities.invokeLater(() -> {
        	try {
        		Document documento = getDocument();
                String contenidoDeTexto = documento.getText(0, documento.getLength());
                doc.setCharacterAttributes(0, contenidoDeTexto.length(), normalStyle, true);
                
                for (ReglaEstilo regla : reglasEstilo) {
                	
                    Matcher matcher = regla.patron.matcher(contenidoDeTexto);
                    
                    // Resaltar las coincidencias encontradas con el estilo correspondiente.
                    while (matcher.find()) {
                        doc.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), regla.estilo, true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
