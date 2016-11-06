package cosc211.project1.dungeon;

import cosc211.project1.monster.*;

import java.util.Random;

public class MonsterRoom extends DungeonRoom {

    private String monster;
    private int monsterType;
    private int points;

    Random random = new Random();

    /**
     * constructor for the child of DungeonRoom
     *
     * sets the monster equal to the randomly
     * generated contents of the room
     */
    public MonsterRoom() {
        String monster = getContents();
    }

    /**
     * gets the type of the room, 1 means
     * monster room
     *
     * @return the integer 1 indicating the
     * room type
     */
    @Override
    public int getType() {
        return 1;
    }

    /**
     * gets the name of the room, allows
     * the type of room to be printed to the user
     *
     * @return String name of the room
     */
    @Override
    public String getName() {
        return "monster room";
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
     * many gained from the specific type of monster
     *
     * uses the monster types extended from MonsterFactory
     * to generate the type of monster
     *
     * @return the type of monster
     */
    public String getContents() {
        MonsterFactory newMonster;
        monsterType = random.nextInt(7);
        switch (monsterType) {
            case 0:
                newMonster = new dragon();
                monster = newMonster.getMonsterType();
                this.setPoints(15);
                break;
            case 1:
                newMonster = new basilisk();
                monster = newMonster.getMonsterType();
                this.setPoints(25);
                break;
            case 2:
                newMonster = new troll();
                monster = newMonster.getMonsterType();
                this.setPoints(10);
                break;
            case 3:
                newMonster = new goblin();
                monster = newMonster.getMonsterType();
                this.setPoints(10);
                break;
            case 4:
                newMonster = new banshee();
                monster = newMonster.getMonsterType();
                this.setPoints(5);
                break;
            case 5:
                newMonster = new werewolf();
                monster = newMonster.getMonsterType();
                this.setPoints(15);
                break;
            case 6:
                newMonster = new genie();
                monster = newMonster.getMonsterType();
                this.setPoints(20);
                break;
            default:
                break;
        }
        return monster;
    }

}