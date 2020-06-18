package danielbatchford.pathfinding.statelogging;

import danielbatchford.pathfinding.Box;

import java.util.*;

public class State {

    private final Set<Box> closedList;
    private final List<Box> openList;

    public State(Set<Box> visited, Collection<Box> queue) {
        this.closedList = new HashSet<Box>(visited);
        this.openList = new ArrayList<Box>(queue);
    }

    public Set<Box> getClosedList() {
        return this.closedList;
    }

    public Collection<Box> getOpenList() {
        return this.openList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(".\nVisited: ");
        for (Box b : closedList) sb.append(b.toString()).append(" ");
        sb.append("\nQueue: ");
        for (Box b : openList) sb.append(b.toString()).append(" ");
        return sb.toString();
    }
}
