package de.unipassau.se2;

import de.unipassau.se2.maze.Room;

public class FactoryMethodExample {

    abstract class MazeGame {
        protected abstract Room createRoom(String name);

        public void playIntro() {
            Room entrance = createRoom("Entrance");
            Room exit = createRoom("Exit");

            System.out.println(entrance.look());
            System.out.println(exit.look());
        }
    }

    class DungeonGame extends MazeGame {
        @Override
        protected Room createRoom(String name) {
            return new Room(name, "Stone walls and cold air.");
        }
    }

    class GardenGame extends MazeGame {
        @Override
        protected Room createRoom(String name) {
            return new Room(name, "Moss, vines, and birdsong.");
        }
    }

    public void demo() {
        MazeGame game = new DungeonGame();
        game.playIntro();
    }

    public static void main(String[] args) {
        new FactoryMethodExample().demo();
    }
}
