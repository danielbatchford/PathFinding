package danielbatchford.pathfinding;

import org.tinylog.Logger;

import java.util.*;

public class AStar extends PathFinder implements PathFindingIF {


    public AStar(Grid grid) throws PathFindingException {
        super(grid);
    }

    @Override
    public List<int[]> findPath(int[] start, int[] end) throws PathFindingException {
        super.findPath(start, end);

        Logger.debug("Finding path from (" + start[0] + "," + start[1] + ") to (" + end[0] + "," + end[1] + ")");

        PriorityQueue<Box> queue = new PriorityQueue<Box>((o1, o2) -> {
            if (o1.getF() == o2.getF()) return 0;
            return (o1.getF() > o2.getF()) ? 1 : -1;
        });

        Set<Box> explored = new HashSet<Box>();

        Box box = grid.getBoxes()[start[0]][start[1]];
        Box endBox = grid.getBoxes()[end[0]][end[1]];

        box.setParent(null);
        box.setG(0);

        queue.add(box);
        Logger.debug("Start box at (" + box.getCord()[0] + "," + box.getCord()[1] + ") added to queue");

        Logger.debug("Starting Loop");

        while (!(queue.isEmpty())) {

            Box workingBox = queue.poll();
            explored.add(workingBox);
            Logger.debug("Box at (" + box.getCord()[0] + "," + box.getCord()[1] + ") added to set");


            if (workingBox.equals(endBox)) {
                Logger.debug("Box at (" + workingBox.getCord()[0] + "," + workingBox.getCord()[1] + ") equals end, found = true");
                Logger.debug("Returning backtrace of path");
                return backTrace(workingBox);
            }

            List<Box> neighbors = grid.getNeighbors(workingBox, Options.allowDiagonal);

            StringBuilder s = new StringBuilder();
            s.append("Neighbors to (").append(workingBox.getCord()[0]).append(",").append(workingBox.getCord()[1]).append(") : ");
            for (Box b : neighbors) {
                s.append("(").append(b.getCord()[0]).append(",").append(b.getCord()[1]).append(") ");
            }
            Logger.debug(s.toString());

            for (Box n : neighbors) {

                Logger.debug("Current queue size: " + queue.size());
                Logger.debug("Analysing neighbor at (" + n.getCord()[0] + "," + n.getCord()[1] + ")");

                if (explored.contains(n) || !n.isWalkable()) {

                    Logger.debug("    Explored contains neighbor (" + n.getCord()[0] + "," + n.getCord()[1] + "), continuing");
                    continue;
                }
                if (workingBox.getG() + getDistance(workingBox, n) < n.getG() || !queue.contains(n)) {

                    if (workingBox.getG() + getDistance(workingBox, n) < n.getG())
                        Logger.debug("    New distance, " + getDistance(workingBox, n) + " less than old distance " + n.getG());

                    n.setG(workingBox.getG() + getDistance(workingBox, n));
                    n.setF(n.getG()+getDistance(n,endBox));

                    Logger.debug("    Setting neighbor.g to " + (workingBox.getG() + getDistance(workingBox, n)));
                    n.setParent(workingBox);

                    if (!queue.contains(n)) {
                        Logger.debug("    Queue doesn't contain (" + n.getCord()[0] + "," + n.getCord()[1] + "), adding");
                        queue.add(n);
                    }
                }
            }
        }
        Logger.debug("No path found, returning null");
        return null;
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
