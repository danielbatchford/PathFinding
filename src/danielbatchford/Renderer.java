package danielbatchford;


import processing.core.PApplet;

public class Renderer extends PApplet {


    Controller controller = new Controller(this);

    public static void main(String[] args) {
        PApplet.main("danielbatchford.Renderer");
    }

    @Override
    public void mousePressed(){
        controller.inputHandler();
    }

    @Override
    public void keyPressed(){
        controller.inputHandler();
    }
    @Override
    public void draw() {
        controller.draw();
        controller.update();
    }

    @Override
    public void settings() {
        size(Cfg.WIDTH, Cfg.HEIGHT);
        noSmooth();

    }

    @Override
    public void setup() {

        noStroke();
        frameRate(Cfg.FRAMERATE);
    }
}
