package app.ui.funcionalidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComponentResizer extends MouseAdapter {

    private final JFrame frame;
    private final JComponent detector;
    private final int borderSize = 5;

    private final boolean resizeTop;
    private final boolean resizeBottom;
    private final boolean resizeLeft;
    private final boolean resizeRight;

    private int cursorType = Cursor.DEFAULT_CURSOR;
    private Point clickPoint;

    public ComponentResizer(JFrame frame,
                            JComponent detector,
                            boolean resizeTop,
                            boolean resizeBottom,
                            boolean resizeLeft,
                            boolean resizeRight) {
        this.frame = frame;
        this.detector = detector;
        this.resizeTop = resizeTop;
        this.resizeBottom = resizeBottom;
        this.resizeLeft = resizeLeft;
        this.resizeRight = resizeRight;

        detector.addMouseListener(this);
        detector.addMouseMotionListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursorType = getCursorType(e.getPoint());
        detector.setCursor(Cursor.getPredefinedCursor(cursorType));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickPoint = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (cursorType == Cursor.DEFAULT_CURSOR) return;

        Rectangle bounds = frame.getBounds();
        Point screenPoint = e.getLocationOnScreen();
        Point start = new Point(bounds.x + clickPoint.x, bounds.y + clickPoint.y);
        int dx = screenPoint.x - start.x;
        int dy = screenPoint.y - start.y;

        switch (cursorType) {
            case Cursor.N_RESIZE_CURSOR:
                bounds.y += dy;
                bounds.height -= dy;
                break;
            case Cursor.S_RESIZE_CURSOR:
                bounds.height += dy;
                break;
            case Cursor.W_RESIZE_CURSOR:
                bounds.x += dx;
                bounds.width -= dx;
                break;
            case Cursor.E_RESIZE_CURSOR:
                bounds.width += dx;
                break;
            case Cursor.NW_RESIZE_CURSOR:
                bounds.x += dx;
                bounds.y += dy;
                bounds.width -= dx;
                bounds.height -= dy;
                break;
            case Cursor.NE_RESIZE_CURSOR:
                bounds.y += dy;
                bounds.width += dx;
                bounds.height -= dy;
                break;
            case Cursor.SW_RESIZE_CURSOR:
                bounds.x += dx;
                bounds.width -= dx;
                bounds.height += dy;
                break;
            case Cursor.SE_RESIZE_CURSOR:
                bounds.width += dx;
                bounds.height += dy;
                break;
        }

        frame.setBounds(bounds);
    }

    private int getCursorType(Point p) {
        int width = detector.getWidth();
        int height = detector.getHeight();

        boolean left = resizeLeft && p.x < borderSize;
        boolean right = resizeRight && p.x > width - borderSize;
        boolean top = resizeTop && p.y < borderSize;
        boolean bottom = resizeBottom && p.y > height - borderSize;

        if (top && left) return Cursor.NW_RESIZE_CURSOR;
        if (top && right) return Cursor.NE_RESIZE_CURSOR;
        if (bottom && left) return Cursor.SW_RESIZE_CURSOR;
        if (bottom && right) return Cursor.SE_RESIZE_CURSOR;
        if (top) return Cursor.N_RESIZE_CURSOR;
        if (bottom) return Cursor.S_RESIZE_CURSOR;
        if (left) return Cursor.W_RESIZE_CURSOR;
        if (right) return Cursor.E_RESIZE_CURSOR;

        return Cursor.DEFAULT_CURSOR;
    }
}
