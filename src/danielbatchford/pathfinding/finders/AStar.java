package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.PathFindingException;

import java.util.ArrayList;
import java.util.List;

public class AStar extends PathFinder {

    public AStar(Grid grid) throws PathFindingException {
        super(grid);
    }

    @Override
    public List<int[]> findPath(int[] start, int[] end) {
        return new ArrayList<int[]>();
    }


}
