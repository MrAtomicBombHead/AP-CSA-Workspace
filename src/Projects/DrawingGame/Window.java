package Projects.DrawingGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
class Window extends JFrame implements MouseListener {
 
    Window()
    {
        super("Drawing Game");
 
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.black);
 
        add(canvas);
        setSize(400, 300);
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics)
    {
        graphics.setColor(Color.red);
        graphics.setFont(new Font("Bold", 1, 20));
        graphics.drawString("This is a canvas", 100, 100);
    }

    public void mouseClick(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}