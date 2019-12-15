package org.woehlke.simulation.mandelbrot.view;

import org.woehlke.simulation.mandelbrot.view.MandelbrotSetApplet;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;

/**
 * (C) 2006 - 2013 Thomas Woehlke.
 * https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html
 * @author Thomas Woehlke
 * Date: 04.02.2006
 * Time: 18:47:46
 */
public class MandelbrotSetFrame extends JFrame implements ImageObserver,
        MenuContainer,
        Serializable,
        Accessible,
        WindowListener {

    private MandelbrotSetApplet exe;

    public MandelbrotSetFrame() {
        super("Mandelbrot Set");
        exe = new MandelbrotSetApplet();
        exe.init();
        add("Center", exe);
        setBounds(100, 100, exe.getCanvasDimensions().getX(), exe.getCanvasDimensions().getY() + 30);
        pack();
        setVisible(true);
        toFront();
        addWindowListener(this);
    }

    public void windowOpened(WindowEvent e) {
        setBounds(100, 100, exe.getCanvasDimensions().getX(), exe.getCanvasDimensions().getY() + 30);
        setVisible(true);
        toFront();
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {
        setBounds(100, 100, exe.getCanvasDimensions().getX(), exe.getCanvasDimensions().getY() + 30);
        setVisible(true);
        toFront();
    }

    public void windowActivated(WindowEvent e) {
        toFront();
    }

    public void windowDeactivated(WindowEvent e) {
    }
}