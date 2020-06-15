package danielbatchford;

import processing.core.PApplet;

import java.util.Arrays;

public class Box {

    private final int[] cord;
    private boolean walkable;
    private boolean start;
    private boolean end;

    Box(int[] cord, boolean walkable) {
        this.cord = cord;
        this.walkable = walkable;
        this.start = false;
        this.end = false;
    }

    Box(int[] cord) {
        this.cord = cord;
        walkable = true;
        this.start = false;
        this.end = false;
    }

    public boolean isStart() {
        return start;
    }

    void setStart(boolean start) {
        this.start = start;
    }

    void draw(PApplet p) {

        if (this.start) {
            p.fill(Cfg.STARTCOLOR[0], Cfg.STARTCOLOR[1], Cfg.STARTCOLOR[2]);
        } else if (this.end) {
            p.fill(Cfg.ENDCOLOR[0], Cfg.ENDCOLOR[1], Cfg.ENDCOLOR[2]);
        } else if (this.walkable){
            p.fill(Cfg.WALKABLECOLOR[0],Cfg.WALKABLECOLOR[1],Cfg.WALKABLECOLOR[2]);
        }
        else{
            p.fill(Cfg.UNWALKABLECOLOR[0],Cfg.UNWALKABLECOLOR[1],Cfg.UNWALKABLECOLOR[2]);
        }
            p.rect(Cfg.DIVWIDTH * cord[0], Cfg.DIVHEIGHT * cord[1], Cfg.DIVWIDTH, Cfg.DIVHEIGHT);

    }

    boolean isWalkable() {
        return walkable;
    }

    void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    boolean isEnd() {
        return end;
    }

    void setEnd(boolean end) {
        this.end = end;
    }


    int[] getCord() {
        return cord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Arrays.equals(cord, box.cord);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cord);
    }


}
