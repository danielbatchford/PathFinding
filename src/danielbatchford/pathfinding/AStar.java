package danielbatchford.pathfinding;

import java.util.*;

public class AStar extends PathFinder implements PathFindingIF {


    public AStar(Grid grid) throws PathFindingException {
        super.assignVariables(grid);
    }

    public AStar(Grid grid, Options options) throws PathFindingException {
        super.assignVariables(grid, options);
    }

    @Override
    public List<int[]> findPath(int[] start, int[] end) throws PathFindingException {
        super.findPath(start, end);

        PriorityQueue<Box> queue = new PriorityQueue<Box>((o1, o2) -> {
            if (o1.getF() == o2.getF()) return 0;
            return (o1.getF() > o2.getF()) ? 1 : -1;
        });

        Set<Box> explored = new HashSet<Box>();

        Box box = grid.getBoxes()[start[0]][start[1]];

        box.setParent(null);
        box.setG(0);

        queue.add(box);

        boolean found = false;


        while (!(queue.isEmpty()) && !found) {


            Box workingBox = queue.poll();
            explored.add(workingBox);

            if (workingBox.equals(end)) found = true;

            List<Box> neighbors = grid.getNeighbors(box, options.allowDiagonal);

            for (Box n : neighbors) {
                if (explored.contains(n) || !n.isWalkable()) continue;

                if (workingBox.getG() + 1 < n.getG() || !queue.contains(n)) {
                    n.setF(workingBox.getG() + getDistance(workingBox,n));
                    n.setParent(workingBox);

                    if (!queue.contains(n)) {
                        queue.add(n);
                    }
                }
            }
        }

        return backTrace(box);
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
