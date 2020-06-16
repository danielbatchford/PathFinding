package danielbatchford.pathfinding;

import java.util.List;

interface PathFindingIF {

    List<int[]> findPath(int[] start, int[] end) throws PathFindingException;

    float getDistance(Box a, Box b) throws PathFindingException;
}
