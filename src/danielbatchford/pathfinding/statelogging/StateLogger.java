package danielbatchford.pathfinding.statelogging;

import danielbatchford.pathfinding.Box;

import java.util.*;

public class StateLogger {

    public List<State> states;

    public StateLogger() {
        states = new LinkedList<>();
    }

    public void add(State state) {
        states.add(state);
    }

    @Override
    public String toString(){ //fix this

        StringBuilder sb = new StringBuilder();


        for (int i = 0, max = states.size(); i < max; i++){
            State state = states.get(i);

            sb.append("\n\nState ").append(i).append(state.toString());
        }
        return sb.toString();
    }

}
