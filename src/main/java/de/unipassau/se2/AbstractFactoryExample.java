package de.unipassau.se2;

public class AbstractFactoryExample {

    interface ThemedRoom {
        String describe();
    }

    interface Door {
        String describe();
    }

    interface MazeThemeFactory {
        ThemedRoom createRoom();

        Door createDoor();
    }

    class DungeonFactory implements MazeThemeFactory {
        @Override
        public ThemedRoom createRoom() {
            return () -> "a damp stone room";
        }

        @Override
        public Door createDoor() {
            return () -> "an iron door";
        }
    }

    class MagicFactory implements MazeThemeFactory {
        @Override
        public ThemedRoom createRoom() {
            return () -> "a glowing crystal room";
        }

        @Override
        public Door createDoor() {
            return () -> "a shimmering portal";
        }
    }

    public void printMaze(MazeThemeFactory factory) {
        System.out.println("This maze has " + factory.createRoom().describe()
            + " behind " + factory.createDoor().describe() + ".");
    }

    public void demo() {
        printMaze(new DungeonFactory());
        printMaze(new MagicFactory());
    }

    public static void main(String[] args) {
        new AbstractFactoryExample().demo();
    }
}
