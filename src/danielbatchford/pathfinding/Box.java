package danielbatchford.pathfinding;

import java.util.Arrays;

public class Box {

    private final int[] cord;
    private final float h = 0; //make heuristic
    private boolean walkable;
    private Box parent;
    private float f;
    private float g;

    Box(int[] cord, boolean walkable) {
        this.cord = cord;
        this.walkable = walkable;
    }

    Box(int[] cord) {
        this.cord = cord;
        walkable = true;
    }


    public boolean isWalkable() {
        return walkable;
    }

    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    public int[] getCord() {
        return cord;
    }


    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public Box getParent() {
        return parent;
    }

    public void setParent(Box parent) {
        this.parent = parent;
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
