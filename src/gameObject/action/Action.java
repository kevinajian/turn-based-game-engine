package gameObject.action;

import java.util.ArrayList;
import java.util.List;
import gameObject.GameObject;
import gameObject.GameUnit;
import grid.Coordinate;

public abstract class Action {
    private String myName;
    private List<Coordinate> myAOE;
    private boolean isAround;
    
    public Action () {
        List<Coordinate> AOE = new ArrayList<>();
        AOE.add(new Coordinate(0, 1));
        setAround(false);
    }
    
    public abstract void doAction(GameUnit unit1, GameUnit unit2);
    
    public void setName (String name) {
        myName = name;
    }

    public boolean isValidAction (GameUnit gameUnit, GameObject gameObject) {
        // TODO: fill in based on action
        return false;
    }

    public String getName () {
        return myName;
    }

    public boolean isAround () {
        return isAround;
    }

    public void setAround (boolean isAround) {
        this.isAround = isAround;
    }

    public List<Coordinate> getAOE () {
        return myAOE;
    }

    public void setAOE (List<Coordinate> AOE) {
        myAOE = AOE;
    }
}