package danielbatchford.pathfinding;

public class Grid {

    Box[][] boxes;

    public Grid(int[] dimensions) {
        boxes = new Box[dimensions[0]][dimensions[1]];

        for (int x = 0; x < dimensions[0]; x++) {
            for (int y = 0; y < dimensions[1]; y++) {
                boxes[x][y] = new Box(new int[]{x, y});
            }
        }
    }

    public void setWalkable(int[] cord, boolean walkable) {
        boxes[cord[0]][cord[1]].setWalkable(walkable);
    }
}
