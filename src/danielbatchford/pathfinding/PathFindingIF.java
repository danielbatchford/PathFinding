package danielbatchford.pathfinding;

import danielbatchford.pathfinding.exceptions.PathFindingException;

import java.util.List;

interface PathFindingIF {

    List<int[]> findPath(int[] start, int[] end, Grid grid, Options options) throws PathFindingException;

    List<int[]> findPath(int[] start, int[] end, Grid grid) throws PathFindingException;

    float getDistance(Box a, Box b) throws PathFindingException;
}
