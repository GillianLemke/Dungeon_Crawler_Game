package cosc211.project1;

import cosc211.project1.dungeon.DungeonRoom;

public class Player {

    private static final int MAX_ROOMS = 10;
    private String name;
    private int health;
    private int totalPoints;
    private static final int STARTING_HEALTH = 20;

    private Dungeon[] newDungeon;

    /**
     * Player constructor sets name, health, and the dungeon
     * equal to default values
     */
    public Player() {
        this.name = "nameless";
        this.health = STARTING_HEALTH;
        this.newDungeon = new Dungeon[MAX_ROOMS];
    }

    /**
     * Overloaded Player constructor that sets player name to name
     *
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.health = STARTING_HEALTH;
        this.newDungeon = new Dungeon[MAX_ROOMS];
    }

    /**
     * gets the amount of points the player
     * currently has
     *
     * @return total points of the player
     */
    public int getPoints() {
        return totalPoints;
    }

    /**
     * sets the total amount of points to
     * the current points plus any new points
     *
     * @param points to be added
     */
    public void setPoints(int points) {
        this.totalPoints += points;
    }

    /**
     * Gets the name of the player
     *
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Sets health points to the points of the player
     *
     * @param health integer value of the health of the player
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Get method that gets the amount of health for the player
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * determines what type of room the player has entered
     *
     * @param room of the DungeonRoom class
     *
     * @return name of the type of room
     */
    public String exploreRoom(DungeonRoom room) {
        String toReturn = "You have entered a " + room.getName() + ".";
        return toReturn;
    }

    /**
     * adds health to the player if they enter a loot room
     * (allows them time to recover)
     *
     * @return health
     */
    public int recoverHealth() {
        health += 5;
        return health;
    }

    /**
     * removes health from the player if they enter a
     * monster room (must fight the monster)
     *
     * @return health
     */
    public int fightMonster() {
        health -= 10;
        return health;
    }

}
