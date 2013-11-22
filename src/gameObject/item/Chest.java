package gameObject.item;

import java.util.List;
import gameObject.GameObject;
import gameObject.action.Action;

/**
 * Holds a list of items that a unit can retrieve.
 * @author carlosreyes
 *
 */
public class Chest extends GameObject {
    
    private List<Item> myItemList;
    
    public Chest(List<Item> itemList) {
        
        setItemList(itemList);
    }
    
    public List<Item> getItemList () {
        return myItemList;
    }

    public void setItemList (List<Item> myItemList) {
        this.myItemList = myItemList;
    }
    
    // TODO: give objects to person

//    @Override
//    public Action getInteraction(){
//        Outcome getContentsOutcome = new FixedOutcome();
//        Action getContents = new Action
//        return null;
//    };
    @Override
    public Action getInteraction(){
        return null;
    };
}