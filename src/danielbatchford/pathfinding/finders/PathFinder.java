package danielbatchford.pathfinding.finders;


import danielbatchford.pathfinding.Grid;
import danielbatchford.pathfinding.PathFindingException;

import java.util.List;

public class PathFinder implements PathFindingIF {


    Grid grid;
    String distanceOption;

    public PathFinder(Grid grid) throws PathFindingException {
        throw new PathFindingException("Default constructor should never be called");
    }

    public List<int[]> findPath(int[] start, int[] end) {
        return null;
    }

    @Override
    public void setHeuristic() {

    }

    @Override
    public void setDistanceMode(String mode) throws PathFindingException {
        for (String s : modes) {
            if (s.equals(mode)) distanceOption = mode;
            return;
        }
        throw new PathFindingException("Mode \"" + mode + "\" was not valid");
    }
}
