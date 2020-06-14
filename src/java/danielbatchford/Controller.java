package java.danielbatchford;

import processing.core.PApplet;

class Controller {

    private PApplet p;

    Grid grid;


    Controller(PApplet p){
        this.p = p;
        grid = new Grid(p);
    }

}
