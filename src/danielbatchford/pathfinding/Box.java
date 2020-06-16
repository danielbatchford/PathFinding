package danielbatchford.pathfinding;

import java.util.Arrays;

class Box {

    private final int[] cord;
    private boolean walkable;

    private Box parent;

    private float f;
    private float g;
    private final float h = 0; //make heuristic

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


    float getF() {
        return f;
    }

    void setF(float f) {
        this.f = f;
    }

    float getG() {
        return g;
    }

    void setG(float g) {
        this.g = g;
    }

    Box getParent() {
        return parent;
    }

    void setParent(Box parent) {
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
