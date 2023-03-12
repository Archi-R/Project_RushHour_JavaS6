package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class Vehicle extends JPanel implements MouseListener {
    private int positionX;
    private int positionY;
    private int size;
    private Color color;
    private boolean isSelected;

    public Vehicle(int positionX, int positionY, int size, Color color) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
        this.color = color;
        this.isSelected = false;

        setBounds(positionX, positionY, size, size);
        addMouseListener(this);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
        setBounds(positionX, positionY, size, size);
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
        setBounds(positionX, positionY, size, size);
    }

    public int getLength() {
        return size;
    }

    public Color getColor() {
        return color;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean intersects(Vehicle other) {
        if (this == other) {
            return false;
        }
        if (positionX + size <= other.positionX) {
            return false;
        }
        if (positionX >= other.positionX + other.size) {
            return false;
        }
        if (positionY + size <= other.positionY) {
            return false;
        }
        if (positionY >= other.positionY + other.size) {
            return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, size, size);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        if (!isSelected) {
//            for (Vehicle vehicle : getParent().getVehicles()) {
//                vehicle.setSelected(false);
//            }
//            setSelected(true);
//            getParent().repaint();
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

