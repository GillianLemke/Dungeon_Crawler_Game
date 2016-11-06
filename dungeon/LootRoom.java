package cosc211.project1.dungeon;

import java.util.Random;

public class LootRoom extends DungeonRoom {

    private String loot;
    private int lootType;
    private int points;

    Random random = new Random();

    /**
     * constructor for the child of DungeonRoom
     *
     * sets the loot equal to the randomly
     * generated contents of the room
     */
    public LootRoom() {
        String loot = getContents();
    }

    /**
     * gets the type of the room, 0 means
     * loot room
     *
     * @return the integer 0 indicating the
     * room type
     */
    @Override
    public int getType() {
        return 0;
    }

    /**
     * gets the name of the room, allows
     * the type of room to be printed to the user
     *
     * @return String name of the room
     */
    @Override
    public String getName() {
        return "loot room";
    }

    /**
     * gets the amount of points for the room
     *
     * @return integer amount of points
     */
    @Override
    public int getPoints() {
        return points;
    }

    /**
     * sets the amount of points to whatever
     * parameter is passed in
     *
     * @param points gained or lost
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * gets the randomly generated contents of the
     * room and sets the amount of points to however
     * many gained from the specific type of loot
     *
     * @return the type of loot
     */
    public String getContents() {
        lootType = random.nextInt(7);
        switch (lootType) {
            case 0:
                loot = "a treasure map";
                this.setPoints(20);
                break;
            case 1:
                loot = "gold";
                this.setPoints(5);
                break;
            case 2:
                loot = "a sword";
                this.setPoints(10);
                break;
            case 3:
                loot = "armour";
                this.setPoints(15);
                break;
            case 4:
                loot = "a crown";
                this.setPoints(5);
                break;
            case 5:
                loot = "a wand";
                this.setPoints(10);
                break;
            case 6:
                loot = "a staff";
                this.setPoints(10);
                break;
            default:
                break;
        }
        return loot;
    }

}
