package grid;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;


public class Tile {
    private boolean isActive;
    private Map<String, Double> myStatMods;
    private String myImagePath;
    private int myMoveCost;
    private String myName;

    public Tile () {
        isActive = false;
        myStatMods = new HashMap<String, Double>();
        myImagePath = "Grass Path"; // TODO: Add in path to grass image
        myMoveCost = 1;
        myName = "Grass";
    }

    public void paint (Graphics g) {
        // TODO
    }

    public boolean isActive () {
        return isActive;
    }

    public void setActive (boolean active) {
        isActive = active;
    }

    public Map<String, Double> getStatMods () {
        return myStatMods;
    }

    public void setStatMods (Map<String, Double> statMods) {
        myStatMods = statMods;
    }

    public String getImagePath () {
        return myImagePath;
    }

    public void setImagePath (String imagePath) {
        myImagePath = imagePath;
    }

    public int getMoveCost () {
        return myMoveCost;
    }

    public void setMoveCost (int moveCost) {
        myMoveCost = moveCost;
    }

    public String getName () {
        return myName;
    }

    public void setName (String name) {
        myName = name;
    }
}