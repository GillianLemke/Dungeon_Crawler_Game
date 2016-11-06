package cosc211.project1.dungeon;

public abstract class DungeonRoom {

    /**
     * Gets the type of room, either 0 for loot room
     * or 1 for monster room
     *
     * will be overwritten by children classes
     *
     * @return the integer associated with the type of room
     */
    public abstract int getType();

    /**
     * Gets the name of the room, either loot or monster
     *
     * will be overwritten by children classes
     *
     * @return the name of the room
     */
    public abstract String getName();

    /**
     * gets the amount of points gained or lost for
     * each room depending on the contents
     *
     * will be overwritten by children classes
     *
     * @return the amount of points for the room
     */
    public abstract int getPoints();

    /**
     * gets the contents of the room, either loot or
     * a monster
     *
     * will be overwritten by children classes
     *
     * @return the contents of the room
     */
    public abstract String getContents();

}
