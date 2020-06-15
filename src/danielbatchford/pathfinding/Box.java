package danielbatchford.pathfinding;

import java.util.Arrays;

public class Box {

    private final int[] cord;
    private boolean walkable;

    Box(int[] cord, boolean walkable) {
        this.cord = cord;
        this.walkable = walkable;
    }

    Box(int[] cord) {
        this.cord = cord;
        walkable = true;
    }


    boolean isWalkable() {
        return walkable;
    }

    void setWalkable(boolean walkable) {
        this.walkable = walkable;
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
