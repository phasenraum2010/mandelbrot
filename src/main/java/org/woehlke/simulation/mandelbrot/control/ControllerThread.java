package org.woehlke.simulation.mandelbrot.control;

import org.woehlke.simulation.mandelbrot.model.ApplicationModel;
import org.woehlke.simulation.mandelbrot.view.ComplexNumberPlaneCanvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Mandelbrot Set drawn by a Turing Machine.
 *
 * (C) 2006 - 2015 Thomas Woehlke.
 * https://thomas-woehlke.blogspot.com/2016/01/mandelbrot-set-drawn-by-turing-machine.html
 * @author Thomas Woehlke
 *
 * Date: 05.02.2006
 * Time: 00:36:20
 */
public class ControllerThread extends Thread
        implements Runnable, MouseListener {

    private ApplicationModel applicationModel;
    private ComplexNumberPlaneCanvas canvas;

    private volatile int THREAD_SLEEP_TIME = 10;
    private Boolean goOn;

    public ControllerThread(
            ComplexNumberPlaneCanvas canvas,
            ApplicationModel applicationModel) {
        goOn = Boolean.TRUE;
        this.canvas=canvas;
        this.applicationModel = applicationModel;
        this.canvas.addMouseListener(this);
    }

    public void run() {
        boolean doIt;
        do {
            synchronized (goOn) {
                doIt = goOn.booleanValue();
            }
            this.applicationModel.step();
            canvas.repaint();
            try { sleep(THREAD_SLEEP_TIME); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        while (doIt);
    }

    public void exit() {
        synchronized (goOn) {
            goOn = Boolean.FALSE;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        synchronized (goOn) {
            //THREAD_SLEEP_TIME = 0;
            //System.out.println(e.getX() + "," + e.getY());
            this.applicationModel.click(e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
