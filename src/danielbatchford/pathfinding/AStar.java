package danielbatchford.pathfinding;

import danielbatchford.pathfinding.exceptions.NoPathFoundException;
import danielbatchford.pathfinding.exceptions.PathFindingException;
import static danielbatchford.pathfinding.AStarHeuristic.calculate;

import java.util.*;

public class AStar extends PathFinder implements PathFindingIF {


    public AStar() {
    }

    @Override
    public List<int[]> findPath(int[] startCord, int[] endCord, Grid grid) throws PathFindingException {
        super.findPath(startCord, endCord, grid);

        PriorityQueue<Box> queue = new PriorityQueue<Box>((o1, o2) -> {
            if (o1.getF() == o2.getF()) return 0;
            return (o1.getF() > o2.getF()) ? 1 : -1;
        });

        Set<Box> explored = new HashSet<Box>();

        Box start = grid.getBoxes()[startCord[0]][startCord[1]];
        Box end = grid.getBoxes()[endCord[0]][endCord[1]];

        start.setParent(null);
        start.setG(0);

        queue.add(start);

        while (!(queue.isEmpty())) {

            Box workingBox = queue.poll();
            explored.add(workingBox);

            if (workingBox.equals(end)) {
                return backTrace(workingBox);
            }

            List<Box> neighbors = grid.getNeighbors(workingBox, Options.allowDiagonal);

            for (Box neighbor : neighbors) {

                if (explored.contains(neighbor) || !neighbor.isWalkable()) {
                    continue;
                }
                if ((workingBox.getG() + getDistance(workingBox, neighbor)) < neighbor.getG() || !queue.contains(neighbor)) {

                    neighbor.setG(workingBox.getG() + getDistance(workingBox, neighbor));
                    neighbor.setF(neighbor.getG() + calculate(workingBox,neighbor)); //heuristic here

                    neighbor.setParent(workingBox);

                    if (!queue.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        throw new NoPathFoundException("No path was found from (" + startCord[0] + "," + startCord[1] + ") to (" + endCord[0] + "," + endCord[1] + ")");
    }


    private List<int[]> backTrace(Box box) {

        if (box == null) return null;


        List<int[]> route = new ArrayList<int[]>();

        route.add(box.getCord());
        while (box.getParent() != null) {
            box = box.getParent();
            route.add(box.getCord());
        }

        return route;
    }


}
