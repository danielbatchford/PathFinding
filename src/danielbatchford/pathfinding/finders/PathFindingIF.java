package danielbatchford.pathfinding.finders;

import danielbatchford.pathfinding.PathFindingException;

import java.util.List;

public interface PathFindingIF {

    String[] modes = new String[]{"Manhattan", "Euclidean"};

    public List<int[]> findPath(int[] start, int[] end);

    public void setHeuristic();

    public void setDistanceMode(String mode) throws PathFindingException;
}
