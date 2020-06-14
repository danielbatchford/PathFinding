package java.danielbatchford;

import org.w3c.dom.css.Rect;
import processing.core.PApplet;

public class Box{

    private int[] cord;
    private boolean walkable;

    Box(int[] cord){
        this.cord = cord;
        walkable = true;
    }

    void setWalkable(boolean walkable){
        this.walkable = walkable;
    }

    boolean isWalkable(){
        return walkable;
    }

    int[] getCord(){
        return cord;
    }

    void walk(int[] dir){
        if(dir.length != 2){
            System.out.println("Bad Direction Dimension");
        }
        if(dir[0] > 1 || dir[1] > 1 || dir[0] < -1 || dir[1] < -1) {
            System.out.println("Bad Direction Magnitude");
        }
        this.cord = new int[]{cord[0]+dir[0],cord[1]+dir[1]};
    }

    void draw(PApplet p, int[] color){
        int[] colorArray = (walkable) ? Cfg.WalkableColor: Cfg.UnwalkableColor;
        p.color(colorArray[0],colorArray[1],colorArray[2]);
        p.rect(cord[0],cord[1],Cfg.DIVWIDTH,Cfg.DIVWIDTH);
    }


}
