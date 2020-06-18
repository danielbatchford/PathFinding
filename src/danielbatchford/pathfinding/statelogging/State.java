package danielbatchford.pathfinding.statelogging;

import danielbatchford.pathfinding.Box;

import java.util.*;

public class State {

    private Set<Box> visited = new HashSet<>();
    private List<Box> queue = new LinkedList<>();

    public State(Set<Box> visited, Collection<Box> queue) {
        this.visited = new HashSet<Box>(visited);
        this.queue = new ArrayList<Box>(queue);
    }

    public Set<Box> getVisited() {
        return this.visited;
    }

    public Collection<Box> getQueue() {
        return this.queue;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(".\nVisited: ");
        for (Box b: visited) sb.append(b.toString()).append(" ");
        sb.append("\nQueue: ");
        for (Box b: queue) sb.append(b.toString()).append(" ");
        return sb.toString();
    }
}
