package cosc211.project1;

import java.io.*;
import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) throws IOException {

        final int MAX_ROOMS = 5;
        int roomNumber = 0;
        int totalPoints = 30;
        String name;
        String dbFile = "saved_game.txt";
        int health = 20;
        int order = 0;

        /**
         * Create array of rooms to be used if a new
         * user is playing
         */
        Dungeon dungeon = new Dungeon();

        Scanner keyboard = new Scanner(System.in);
        PrintWriter writeToFile;
        Scanner infile;

        // rules
        System.out.println("Rules: You will enter different rooms. They may either be loot\n" +
                "rooms or monster rooms. You will use the loot to fight the monsters. If you\n" +
                "fight the monsters, you will gain points but lose health. You will also gain \n" +
                "points when you get more loot. If you enter a loot room, you will have a chance\n" +
                "for your health to recover. You will enter a maximum of 5 rooms. If you get\n" +
                "through all 5 rooms with health remaining, you win. Your health starts at 20\n" +
                "and points starts at 30. You lose 10 health if you have to fight a monster.\n" +
                "You gain 5 health if you enter a loot room.\n");

        /**
         * username is associated with file name for the player
         *
         * if the player does not exist, a new file is created
         */
        System.out.println("Please enter your username to begin the game.");
        name = keyboard.nextLine();

        /**
         * opens file for the user and continues game or creates new game
         * if the player lost
         *
         * if player does not exist, a new file is created
         */
        try {
            infile = new Scanner(new FileInputStream(name + "_" + dbFile));
            name = infile.next();
            totalPoints = infile.nextInt();
            health = infile.nextInt();
            for (int i = 0; i < MAX_ROOMS; i++) {
                dungeon.setRoom(i, infile.nextInt());
            }
            order = infile.nextInt();
            infile.close();
            if (totalPoints <= 0 || health <= 0) {
                System.out.println("You lost the last game. Creating new game.\n");
                totalPoints = 30;
                dungeon = new Dungeon();
                order = 0;
            }
        } catch (Exception e) {
            System.out.println("No previous game found. Using default values.");
            totalPoints = 30;
        }

        Player player = new Player(name);

        /**
         * while the player chooses to keep playing and does not lose
         */
        for (roomNumber = order; roomNumber < MAX_ROOMS; roomNumber++) {

            System.out.println(player.exploreRoom(dungeon.getRoom(roomNumber)));
            System.out.println("You found " + dungeon.getRoom(roomNumber).getContents() + "!");
            totalPoints += dungeon.getRoom(roomNumber).getPoints();

            System.out.println("You have " + totalPoints + " total points.");

            /**
             * if the player is in a loot room, they recover health
             * otherwise the player loses health
             */
            if (dungeon.getRoom(roomNumber).getType() == 0) {
                player.recoverHealth();
                System.out.println("Your health is: " + player.getHealth());
            } else if (dungeon.getRoom(roomNumber).getType() == 1) {
                player.fightMonster();
                System.out.println("Your health is: " + player.getHealth());
            }


            /**
             * if the player's health or amount of points reaches 0,
             * the game ends and all data is written to the file
             *
             * otherwise the player has the option to save and quit
             * or keep playing
             */
            if (player.getHealth() <= 0 || totalPoints <= 0) {
                System.out.println("\nGame over.");
                System.out.println("Scores and health will be written to username_saved_game.txt");
                try {
                    writeToFile = new PrintWriter(new FileOutputStream(name + "_" + dbFile));

                    System.out.println(totalPoints);

                    writeToFile.print(player.getName() + " " + player.getPoints() + " " + player.getHealth() + " ");
                    for (int i = 0; i < MAX_ROOMS; i++) {
                        writeToFile.print(dungeon.getRoom(i).getType() + " ");
                    }
                    writeToFile.print(roomNumber);
                    writeToFile.close();
                    System.exit(0);
                } catch (FileNotFoundException e) {
                    System.out.println("Input file not found. Quitting.");
                }
            } else {
                System.out.println("Press enter to advance to the next room or 0 to save and quit.");
                String command = keyboard.nextLine();

                // allows player to save and quit
                if (command.equals("0")) {
                    try {
                        writeToFile = new PrintWriter(new FileOutputStream(name + "_" + dbFile));
                        writeToFile.print(player.getName() + " " + totalPoints + " " + player.getHealth() + " ");
                        for (int i = 0; i < MAX_ROOMS; i++) {
                            writeToFile.print(dungeon.getRoom(i).getType() + " ");
                        }
                        writeToFile.print(roomNumber);
                        writeToFile.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Input file not found. Quitting.");
                    }

                    System.exit(0);
                }

            }

        }

    }

}

