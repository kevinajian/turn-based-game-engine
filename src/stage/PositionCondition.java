package stage;

import gameObject.GameUnit;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
public class PositionCondition extends Condition {

    // temp dummy variables
    @JsonProperty
    private int playersPositionX;

    // You can specify the name of the JSON key like so:
    @JsonProperty("playersPositionY")
    private int playersPositionY;

    // All JSON serializable classes either need to have an empty constructor

    public PositionCondition () {
        super();
        myNeededData.add("x");
        myNeededData.add("y");
        myNeededData.add("affiliation");
    }

    /**
     * Returns true if GameUnit of the correct affiliation is at x, y
     */
    @Override
    boolean isFulfilled (Stage stage) {
        Object object =
                stage.getGrid().getObject(Integer.parseInt(myData.get("x")), Integer.parseInt(myData.get("y")));

        if (object instanceof GameUnit) {
            GameUnit gu = (GameUnit) object;
            return gu.getAffiliation() == Integer.parseInt(myData.get("affiliation"));
        }

        return false;
    }
}
