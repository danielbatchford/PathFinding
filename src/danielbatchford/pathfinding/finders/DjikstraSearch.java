package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.exceptions.PathFindingException;
import danielbatchford.pathfinding.util.Options;

import java.util.List;

public class DjikstraSearch extends PriorityQueueSearch {


    @Override
    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid, Options options) throws PathFindingException {
        return super.findPath(startCord, endCord, grid, options, false);
    }


}

