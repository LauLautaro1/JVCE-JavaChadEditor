package app.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.enums.ColoresPlantillas;

/**
 * BarraModerna es una clase que representa una barra de título personalizada
 * para una ventana. Permite cerrar la ventana y moverla arrastrando la barra.
 */
public class BarraModerna extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	
	private JFrame padre;

	//---------- Constructor ----------
	
	public BarraModerna(JFrame frame) {
		
		this.padre = frame;
		
		Color[] colores = ColoresPlantillas.getColoresBarra();
		
        setBackground(colores[0]);
        
        setPreferredSize(new java.awt.Dimension(800, 20));
        setLayout(new java.awt.BorderLayout());
        
        //Botón cerrar
        JButton botonCerrar = new JButton("X");
        botonCerrar.setFont(new Font("Consolas", Font.PLAIN, 14));
        botonCerrar.setForeground(Color.WHITE);
        botonCerrar.setBackground(colores[1]);
        botonCerrar.setBorderPainted(false);
        botonCerrar.setFocusPainted(false);
        botonCerrar.setPreferredSize(new Dimension(45, 30));
        botonCerrar.addActionListener(e -> System.exit(0));
        add(botonCerrar, java.awt.BorderLayout.EAST);
        
        
        
        //Permitir mover la ventana
        Point mouseInicial = new Point();
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseInicial.setLocation(e.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = padre.getLocation();
                padre.setLocation(p.x + e.getX() - mouseInicial.x, p.y + e.getY() - mouseInicial.y);
            }
        });
    }
	
}
