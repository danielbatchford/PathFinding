package danielbatchford.pathfinding;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int[] dim;
    private final Box[][] boxes;


    public Grid(int[] dimensions) throws PathFindingException {


        if (dimensions[0] <= 0) {
            throw new PathFindingException("X dimension was <= 0, cannot create grid");
        }
        if (dimensions[1] <= 0) {
            throw new PathFindingException("Y dimension was <= 0, cannot create grid");
        }
        boxes = new Box[dimensions[0]][dimensions[1]];

        for (int x = 0; x < dimensions[0]; x++) {
            for (int y = 0; y < dimensions[1]; y++) {
                boxes[x][y] = new Box(new int[]{x, y});
            }
        }

        this.dim = getDimensions();

    }

    public void setWalkable(int[] cord, boolean walkable) {
        boxes[cord[0]][cord[1]].setWalkable(walkable);

    }

    int[] getDimensions() throws PathFindingException {
        return new int[]{boxes.length, boxes[0].length};

    }

    List<Box> getNeighbors(Box box, boolean allowDiagonal) {

        List<Box> neighbors = new ArrayList<Box>();

        int[] boxCord = box.getCord();

        if (boxCord[0] > 0) {
            neighbors.add(boxes[boxCord[0] - 1][boxCord[1]]);
        }
        if (boxCord[0] < dim[0] - 1) {
            neighbors.add(boxes[boxCord[0] + 1][boxCord[1]]);
        }
        if (boxCord[1] > 0) {
            neighbors.add(boxes[boxCord[0]][boxCord[1] - 1]);
        }
        if (boxCord[1] < dim[1] - 1) {
            neighbors.add(boxes[boxCord[0]][boxCord[1] + 1]);
        }

        neighbors.remove(box.getParent()); //may not be needed

        if (!allowDiagonal) {
            return neighbors;
        }

        if (boxCord[0] > 0 || boxCord[1] > 0) {
            neighbors.add(boxes[boxCord[0] - 1][boxCord[1] - 1]);
        }
        if (boxCord[0] < dim[0] - 1 || boxCord[1] < dim[1] - 1) {
            neighbors.add(boxes[boxCord[0] + 1][boxCord[1] + 1]);
        }
        if (boxCord[0] > 0 || boxCord[1] < dim[1] - 1) {
            neighbors.add(boxes[boxCord[0] - 1][boxCord[1] + 1]);
        }
        if (boxCord[0] < dim[0] || boxCord[1] > 0) {
            neighbors.add(boxes[boxCord[0] + 1][boxCord[1] - 1]);
        }
        return neighbors;
    }

    public String toString(List<int[]> path) throws PathFindingException {

        String[][] stringArr = new String[dim[0]][dim[1]];
        for (int x = 0; x < dim[0]; x++) {
            for (int y = 0; y < dim[1]; y++) {
                Box b = boxes[x][y];

                stringArr[x][y] = (b.isWalkable()) ? "-" : "X";
            }
        }

        for (int[] p : path) {
            stringArr[p[0]][p[1]] = "O";
        }

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < dim[0]; x++) {
            for (int y = 0; y < dim[1]; y++) {
                sb.append(stringArr[x][y]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();

    }

     int[] getDim() {
        return dim;
    }

    public Box[][] getBoxes() {
        return boxes;
    }

}
