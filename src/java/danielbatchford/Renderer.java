package java.danielbatchford;

import processing.core.PApplet;

public class Renderer extends PApplet{


    Controller controller = new Controller(this);

    public static void main(String[] args) {
        PApplet.main("Renderer");
    }

    @Override
    public void draw(){

    }

    @Override
    public void settings(){
        size(Cfg.WIDTH, Cfg.HEIGHT);
    }

    @Override
    public void setup(){
    }
}
