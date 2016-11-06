package cosc211.project1;

import cosc211.project1.dungeon.DungeonRoom;
import cosc211.project1.dungeon.LootRoom;
import cosc211.project1.dungeon.MonsterRoom;

import java.util.Random;

public class Dungeon {

    private static final int MAX_ROOMS = 5;
    Random random = new Random();
    private int roomType;
    private DungeonRoom dungeonRooms[] = new DungeonRoom[MAX_ROOMS];

    /**
     * Dungeon constructor creates an array of dungeon rooms
     *
     * for each room in the array, the type of room is
     * randomly generated
     */
    public Dungeon() {
        for (int i = 0; i < MAX_ROOMS; i++) {

            roomType = random.nextInt(2);
            switch (roomType) {
                case 0:
                    dungeonRooms[i] = new LootRoom();
                    break;
                case 1:
                    dungeonRooms[i] = new MonsterRoom();
                    break;
            }
        }
    }

    /**
     * from the room number that is passed in,
     * the method returns the dungeon room at
     * that index
     *
     * @param room index of the array
     *
     * @return the dungeon room at that index
     */
    public DungeonRoom getRoom(int room){
        return dungeonRooms[room];
    }

    /**
     * using the index of the array and they type of room,
     * create a new room based on that index
     *
     * used if new array of rooms must be created
     * (i.e. previous game lost or no existing game)
     *
     * @param room index in the array
     *
     * @param roomType 0 for loot, 1 for monster
     */
    public void setRoom(int room, int roomType){
        switch (roomType) {
            case 0:
                dungeonRooms[room] = new LootRoom();
                break;
            case 1:
                dungeonRooms[room] = new MonsterRoom();
                break;
        }
    }
}
