package gameObject.action;

import java.util.ArrayList;
import java.util.List;
import gameObject.GameObject;
import gameObject.GameUnit;
import gameObject.item.Chest;
import gameObject.item.Item;
import grid.GridConstants;

public class ChestAction extends Action {

    public ChestAction() {
        super.setName(GridConstants.CHEST);
    }
    
    @Override
    public void doAction (GameUnit initiator, GameObject receiver) {
        Chest chest = (Chest) receiver;
        
        List<Item> chestItems = chest.getItemList();
        
        for(Item i : chestItems) {
            initiator.addItem(i);
        }
        
        chest.setItems(new ArrayList<Item>());
    }

    @Override
    public boolean isValidAction (GameUnit gameUnit, GameObject gameObject) {
        if(gameObject instanceof Chest) {
            return !((Chest) gameObject).isEmpty();
        }
        return true;
    }

}
