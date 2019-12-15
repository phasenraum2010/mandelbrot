package org.woehlke.simulation.mandelbrot.model;

public class TuringPhase {

    private volatile Phase turingPhase;

    public TuringPhase() {
        this.turingPhase = Phase.GO_TO_SET;
    }

    public void start(){
        this.turingPhase = Phase.GO_TO_SET;
    }

    public void finishGoToSet(){
        turingPhase=Phase.WALK_AROUND;
    }

    public Phase getTuringPhase() {
        return turingPhase;
    }

    public void finishWalkAround() {
        turingPhase = Phase.FILL_THE_INSIDE;
        //System.out.println("####");
    }

    public void finishFillTheInside(){
        turingPhase=Phase.COLOR_THE_OUTSIDE;
        //System.out.println("*****");
    }

    public void finishFillTheOutsideWithColors() {
        turingPhase=Phase.ALL_DONE;
        //System.out.println("------");
    }
}