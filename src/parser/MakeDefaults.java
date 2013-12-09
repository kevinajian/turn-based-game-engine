package parser;

import gameObject.GameObject;
import gameObject.Stat;
import gameObject.Stats;
import gameObject.action.Action;
import gameObject.action.CombatAction;
import gameObject.action.Outcome;
import gameObject.action.Outcomes;
import gameObject.action.StatOutcome;
import gameObject.item.Item;
import grid.GridConstants;
import java.util.ArrayList;
import java.util.List;
import controllers.WorldManager;
import stage.UnitCountCondition;
import stage.WinCondition;
import team.Team;


public class MakeDefaults {

    private JSONParser p;
    private Item defaultItem;
    private CombatAction defaultCombatAction;
    private Stats defaultStats;

    public MakeDefaults () {
        p = new JSONParser();

        defaultStats = new Stats();
        for (String s : GridConstants.DEFAULTSTATARRAY) {
            defaultStats.addStat(new Stat(s));
        }

        defaultCombatAction = new CombatAction();
        defaultCombatAction.setName("Slash");
        defaultCombatAction.setImagePath("resources/weapon.png");
        defaultCombatAction.setActionRange(1);
        defaultCombatAction.setInitiatorOutcomes(new Outcomes());

        Outcome r1 = new StatOutcome();
        r1.setAffectee(new Stat("health"));
        r1.setAmount(-10);
        r1.setIsFixed(true);
        Outcomes recvOutcomes = new Outcomes();
        recvOutcomes.addOutcome(r1);

        defaultCombatAction.setReceiverOutcomes(recvOutcomes);
        defaultCombatAction.setInitiatorStatWeights(new Stats());
        defaultCombatAction.setReceiverStatWeights(new Stats());

        defaultItem = new Item();
        List<String> actionList = new ArrayList<>();
        actionList.add("Slash");
        defaultItem.setActions(actionList);
        defaultItem.setName("Item");
        defaultItem.setStats(defaultStats);
        defaultItem.setImagePath("resources/potion.png");
    }

    public void makeTiles () throws Exception {
        java.util.ArrayList<grid.Tile> list = new java.util.ArrayList<>();
        List<String> passableList = new ArrayList<>();

        passableList.add(GridConstants.DEFAULT_PASS_EVERYTHING);

        grid.Tile Black = new grid.Tile();
        Black.setName("Black");
        Black.setImagePath("resources/black.png");
        Black.setStats(defaultStats);
        Black.setActive(false);
        Black.setMoveCost(1);
        Black.setPassableList(passableList);
        
        grid.Tile Grass = new grid.Tile();
        Grass.setName("Long Grass");
        Grass.setImagePath("resources/grass1.png");
        Grass.setStats(defaultStats);
        Grass.setActive(false);
        Grass.setMoveCost(1);
        Grass.setPassableList(passableList);        
        
        list.add(Black);
        list.add(Grass);        

        p.createJSON("defaults/" + GridConstants.TILE, list);
    }

    public void makeObjects () {
        java.util.ArrayList<gameObject.GameObject> list =
                new java.util.ArrayList<gameObject.GameObject>();

        gameObject.GameObject bigPellet = new gameObject.GameObject();
        bigPellet.setName("Big Pellet");
        bigPellet.setImagePath("resources/bigpellet.png");
        
        gameObject.GameObject pellet = new gameObject.GameObject();
        pellet.setName("pellet");
        pellet.setImagePath("resources/pellet.png");
        
        gameObject.GameObject hr = new gameObject.GameObject();
        hr.setName("Horizontal Right Wall");
        hr.setImagePath("resources/hr.png");
        
        gameObject.GameObject hl = new gameObject.GameObject();
        hl.setName("Horizontal Left Wall");
        hl.setImagePath("resources/hl.png");
        
        gameObject.GameObject h2 = new gameObject.GameObject();
        h2.setName("Horizontal Double Wall");
        h2.setImagePath("resources/h2.png");
        
        gameObject.GameObject vt = new gameObject.GameObject();
        vt.setName("Vertical Top Wall");
        vt.setImagePath("resources/vt.png");
        
        gameObject.GameObject vb = new gameObject.GameObject();
        vb.setName("Vertical Bottom Wall");
        vb.setImagePath("resources/vb.png");
        
        gameObject.GameObject v2 = new gameObject.GameObject();
        v2.setName("Vertical Double Wall");
        v2.setImagePath("resources/v2.png");
        
        gameObject.GameObject tl = new gameObject.GameObject();
        tl.setName("Top Left Corner Wall");
        tl.setImagePath("resources/tl.png");
        
        gameObject.GameObject tli = new gameObject.GameObject();
        tli.setName("Top Left Inner Corner Wall");
        tli.setImagePath("resources/tl.png");
        
        gameObject.GameObject tl2 = new gameObject.GameObject();
        tl2.setName("Top Left Double Corner Wall");
        tl2.setImagePath("resources/tl2.png");
        
        gameObject.GameObject tr = new gameObject.GameObject();
        tr.setName("Top Right Corner Wall");
        tr.setImagePath("resources/tr.png");
        
        gameObject.GameObject tri = new gameObject.GameObject();
        tri.setName("Top Right Inner Corner Wall");
        tri.setImagePath("resources/tr.png");
        
        gameObject.GameObject tr2 = new gameObject.GameObject();
        tr2.setName("Top Right Double Corner Wall");
        tr2.setImagePath("resources/tr2.png");
        
        gameObject.GameObject bl = new gameObject.GameObject();
        bl.setName("Bottom Left Corner Wall");
        bl.setImagePath("resources/bl.png");
        
        gameObject.GameObject bli = new gameObject.GameObject();
        bli.setName("Bottom Left Inner Corner Wall");
        bli.setImagePath("resources/bl.png");
        
        gameObject.GameObject bl2 = new gameObject.GameObject();
        bl2.setName("Bottom Left Double Corner Wall");
        bl2.setImagePath("resources/bl2.png");
        
        gameObject.GameObject br = new gameObject.GameObject();
        br.setName("Bottom Right Corner Wall");
        br.setImagePath("resources/br.png");
        
        gameObject.GameObject bri = new gameObject.GameObject();
        bri.setName("Bottom Right Inner Corner Wall");
        bri.setImagePath("resources/br.png");
        
        gameObject.GameObject br2 = new gameObject.GameObject();
        br2.setName("Bottom Right Double Corner Wall");
        br2.setImagePath("resources/br2.png");
        
        gameObject.GameObject le = new gameObject.GameObject();
        le.setName("Left End Wall");
        le.setImagePath("resources/le.png");
        
        gameObject.GameObject re = new gameObject.GameObject();
        re.setName("Right End Wall");
        re.setImagePath("resources/re.png");
        
        gameObject.Chest chest = new gameObject.Chest();
        chest.setName("Chest");
        chest.setImagePath("resources/chest.png");

        gameObject.Shop shop = new gameObject.Shop();
        shop.setName("Shop");
        shop.setImagePath("resources/shop.png");

        list.add(bigPellet);
        list.add(pellet);
        list.add(hr);
        list.add(hl);
        list.add(h2);
        list.add(vt);
        list.add(vb);
        list.add(v2);
        list.add(tl);
        list.add(tli);
        list.add(tl2);
        list.add(tr);
        list.add(tri);
        list.add(tr2);
        list.add(bl);
        list.add(bli);
        list.add(bl2);
        list.add(br);
        list.add(bri);
        list.add(br2);
        list.add(le);
        list.add(re);
        list.add(chest);
        list.add(shop);

        p.createJSON("defaults/" + GridConstants.GAMEOBJECT, list);
    }

    public void makeUnits () {
        java.util.ArrayList<gameObject.GameUnit> list =
                new java.util.ArrayList<gameObject.GameUnit>();

        Stats unitStats = new Stats(defaultStats);
        unitStats.modExisting("movement", 4);
        unitStats.modExisting("strength", 2);
        unitStats.modExisting("health", 15);
        unitStats.modExisting("attack", 2);
        unitStats.modExisting("maxhealth", unitStats.getStatValue("health"));

        gameObject.GameUnit hero = new gameObject.GameUnit();
        gameObject.GameUnit ghostorange = new gameObject.GameUnit();
        gameObject.GameUnit ghostpink = new gameObject.GameUnit();
        gameObject.GameUnit ghostblue = new gameObject.GameUnit();
        gameObject.GameUnit pacman = new gameObject.GameUnit();

        ghostorange.setName("Orange Ghost");
        ghostorange.setImagePath("resources/ghostorange.png");
        ghostorange.setStats(unitStats);
        ghostorange.setAffiliation("enemy");
        
        ghostpink.setName("Pink Ghost");
        ghostpink.setImagePath("resources/ghostpink.png");
        ghostpink.setStats(unitStats);
        ghostpink.setAffiliation("enemy");
        
        ghostblue.setName("Blue Ghost");
        ghostblue.setImagePath("resources/ghostblue.png");
        ghostblue.setStats(unitStats);
        ghostblue.setAffiliation("enemy");
        
        pacman.setName("Pacman");
        pacman.setImagePath("resources/pacman.png");
        pacman.setStats(unitStats);
        pacman.setAffiliation("player");
        
        hero.setName("hero");
        hero.setImagePath("resources/hero.png");
        hero.setStats(unitStats);
        hero.setAffiliation("player");

        list.add(ghostorange);
        list.add(ghostblue);
        list.add(ghostpink);
        list.add(pacman);
        list.add(hero);     

        p.createJSON("defaults/" + GridConstants.GAMEUNIT, list);
    }

    public void saveAndLoadGame () {
        controllers.WorldManager wm = new controllers.WorldManager();
        wm.setGameName("test");
        wm.addStage(10, 10, 1, "stageOne", 0);
        wm.saveGame("saves");

        p.createObjectFromFile("saves/test", WorldManager.class);
    }

    public void makeTeams () {
        List<Team> list = new ArrayList<Team>();
        Team defaultTeam = new Team();
        defaultTeam.setName("player");
        defaultTeam.setGold(0);
        defaultTeam.setImagePath("resources/grass.png");
        defaultTeam.setIsHuman(true);
        WinCondition wc = new WinCondition();
        wc.addCondition(new UnitCountCondition());
        defaultTeam.setWinCondition(wc);

        Team enemyTeam = new Team();
        enemyTeam.setName("enemy");
        enemyTeam.setGold(0);
        enemyTeam.setImagePath("resources/grass.png");
        enemyTeam.setIsHuman(false);

        WinCondition wcEnemy = new WinCondition();
        UnitCountCondition c = new UnitCountCondition();
        c.setAffiliation("player");
        wcEnemy.addCondition(c);

        enemyTeam.setWinCondition(wcEnemy);

        list.add(defaultTeam);
        list.add(enemyTeam);

        p.createJSON("defaults/" + GridConstants.TEAM, list);
    }

    public void makeActions () {
        List<Action> list = new ArrayList<Action>();
        list.add(defaultCombatAction);

        p.createJSON("defaults/" + GridConstants.ACTION, list);
    }

    public void makeStats () {
        List<Stat> list = new ArrayList<Stat>();
        for (String s : GridConstants.DEFAULTSTATARRAY) {
            list.add(new Stat(s));
        }

        p.createJSON("defaults/" + GridConstants.MASTERSTATS, list);
    }

    public void makeItems () {
        List<Item> list = new ArrayList<Item>();

        Item milk = new Item();
        milk.setName("Milk");
        milk.setImagePath("resources/milk.png");
        milk.setStats(defaultStats);

        Item potion = new Item();
        potion.setName("Potion");
        potion.setImagePath("resources/potion.png");
        potion.setStats(defaultStats);

        Item armor = new Item();
        armor.setName("Armor");
        armor.setImagePath("resources/armor.png");
        armor.setStats(defaultStats);

        Item weapon = new Item();
        weapon.setName("Weapon");
        weapon.setImagePath("resources/weapon.png");
        weapon.addAction(defaultCombatAction.getName());
        weapon.setStats(defaultStats);

        Item helmet = new Item();
        helmet.setName("Helmet");
        helmet.setImagePath("resources/helmet.png");
        helmet.setStats(defaultStats);

        list.add(milk);
        list.add(potion);
        list.add(armor);
        list.add(weapon);
        list.add(helmet);

        p.createJSON("defaults/" + GridConstants.ITEM, list);
    }

    /**
     * Just run this to refresh the default JSONs
     * 
     * @param args
     * @throws Exception
     */
    public static void main (String[] args) throws Exception {
        MakeDefaults maker = new MakeDefaults();
        maker.makeTiles();
        maker.makeObjects();
        maker.makeUnits();
        maker.makeItems();
        maker.makeStats();
        maker.makeTeams();
        maker.makeActions();

        maker.saveAndLoadGame();
    }

}
