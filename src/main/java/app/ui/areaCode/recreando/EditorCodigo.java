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

    // Definición de las reglas de estilo.
    private AttributeSet normalStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, Color.WHITE);
    private AttributeSet keywordStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0x569CD6));
    private AttributeSet commentStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0x6A9955));
    private AttributeSet stringStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0xCE9178));
    private AttributeSet numberStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0xB5CEA8));
    private AttributeSet functionStyle = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, new Color(0xDCDCAA));
	
    private List<ReglaEstilo> reglasEstilo = new ArrayList<>();
    
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
        agregarEstilosResaltado(EstilosEnum.normalStyle, ".*", Color.WHITE);
        agregarEstilosResaltado(EstilosEnum.keywordStyle, "\\b(if|else|while|for|return|function)\\b", new Color(0x569CD6));
        agregarEstilosResaltado(EstilosEnum.commentStyle, "//.*|/\\*.*?\\*/", new Color(0x6A9955));
        agregarEstilosResaltado(EstilosEnum.stringStyle, "\".*?\"", new Color(0xCE9178));
        agregarEstilosResaltado(EstilosEnum.numberStyle, "\\b\\d+(\\.\\d+)?\\b", new Color(0xB5CEA8));
        agregarEstilosResaltado(EstilosEnum.functionStyle, "\\b\\w+\\s*\\(.*?\\)", new Color(0xDCDCAA));
        // Agregar los estilos al mapa
        mapaEstilos.put(EstilosEnum.normalStyle, normalStyle);
        mapaEstilos.put(EstilosEnum.keywordStyle, keywordStyle);
        mapaEstilos.put(EstilosEnum.commentStyle, commentStyle);
        mapaEstilos.put(EstilosEnum.stringStyle, stringStyle);
        mapaEstilos.put(EstilosEnum.numberStyle, numberStyle);
        mapaEstilos.put(EstilosEnum.functionStyle, functionStyle);
	}
	
	
    
    //Funcion para agregar los estilos.
	private void agregarEstilosResaltado(EstilosEnum estilo, String regex , Color color) {
		// Validamos datos:
		if (regex == null || regex.isEmpty() || color == null) {
			throw new IllegalArgumentException("El regex y el color no pueden ser nulos o vacíos.");
		}
		
		AttributeSet estiloAplicado = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
		
		// Crear una regla de estilo y agregarla a la lista de reglas.
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
	
	// Resaltado en tiempo real
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
