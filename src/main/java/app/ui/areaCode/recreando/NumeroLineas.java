package app.ui.areaCode.recreando;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;


/*
 * Clase dedicada a mostrar los números de línea en el Editor De codigo.
 */
public class NumeroLineas extends JPanel{
	
	//---------- Variables ----------

	private static final long serialVersionUID = 1L;
	
	private final EditorCodigo textPane;
	private int lineCountAnterior;
	
	private Color lineNumberColor = new Color(0x505050); // Color de los números de línea
	private Color backgroundColor = new Color(0x0d1117); // Color de fondo del panel de números de línea

	//---------- Constructor ----------
	
    public NumeroLineas(EditorCodigo textPane) {
		if (textPane == null) {
			throw new IllegalArgumentException("El textPane no puede ser nulo");
		}
		
        this.textPane = textPane;
        setPreferredSize(new Dimension(40, Integer.MAX_VALUE));
        setBackground(backgroundColor);
        
        
        lineCountAnterior = getNumeroLineas();
        
        //Detecta si hubo cambios en el documento (texto) para actualizar los números de línea.
        textPane.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                verificarCambioLineas();
            }

            public void removeUpdate(DocumentEvent e) {
                verificarCambioLineas();
            }

            public void changedUpdate(DocumentEvent e) {
                verificarCambioLineas();
            }
        });

        // Por si se mueve el caret (teclado)
        textPane.addCaretListener(e -> repaint());
    }
    
    //---------- Metodos ----------
    
    private int getNumeroLineas() {
        Element root = textPane.getDocument().getDefaultRootElement();
        return root.getElementCount();
    }

    private void verificarCambioLineas() {
        int nuevasLineas = getNumeroLineas();
        if (nuevasLineas != lineCountAnterior) {
            lineCountAnterior = nuevasLineas;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Rectangle clip = g.getClipBounds();
        FontMetrics fm = g.getFontMetrics();

        try {
            
            // Calculamos los offsets de inicio y fin visibles
            
            @SuppressWarnings("deprecation")
			int startOffset = textPane.viewToModel(new Point(0, clip.y));
            @SuppressWarnings("deprecation")
			int endOffset = textPane.viewToModel(new Point(0, clip.y + clip.height));


            // Obtenemos los elementos de línea del documento
            
            Element root = textPane.getDocument().getDefaultRootElement();
            int startLine = root.getElementIndex(startOffset);
            int endLine = root.getElementIndex(endOffset);
            
            // Dibujamos los números de línea

            for (int i = startLine; i <= endLine; i++) {
                @SuppressWarnings("deprecation")
				Rectangle rect = textPane.modelToView(root.getElement(i).getStartOffset());
                if (rect != null) {
                    int y = rect.y + fm.getAscent();
                    g.setColor(lineNumberColor);
                    g.drawString(String.valueOf(i + 1), 5, y);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //---------- Getters y Setters ----------
    
    public void setFontNumeroLinea(Font font) {
    	if (font == null) {
    		throw new IllegalArgumentException("La fuente no puede ser nula");
    	}
    	this.setFont(font);
    }
    
	public void setLineNumberColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("El color no puede ser nulo");
		}
		this.lineNumberColor = color;
		repaint();
	}

	public Color getLineNumberColor() {
		return lineNumberColor;
	}

	public void setBackgroundColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("El color no puede ser nulo");
		}
		this.backgroundColor = color;
		setBackground(backgroundColor);
		repaint();
	}

	public Color getBackgroundColor() {
		return backgroundColor;

	}
	

}
