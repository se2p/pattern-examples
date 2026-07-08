package de.unipassau.se2;

import de.unipassau.se2.maze.Direction;
import de.unipassau.se2.maze.Maze;
import de.unipassau.se2.maze.Player;
import de.unipassau.se2.maze.Room;

public class FacadeExample {

    class MazeBuilder {
        public Maze build() {
            Room hall = new Room("Hall", "A quiet entrance hall.");
            Room armory = new Room("Armory", "Old swords hang on the wall.");
            Room exit = new Room("Exit", "Sunlight shines through the gate.");

            hall.connect(Direction.EAST, armory);
            armory.connect(Direction.WEST, hall);
            armory.connect(Direction.SOUTH, exit);
            exit.connect(Direction.NORTH, armory);

            Maze maze = new Maze();
            maze.setStartRoom(hall);
            maze.add(armory);
            maze.setExitRoom(exit);
            return maze;
        }
    }

    class MovementSystem {
        public String move(Player player, Direction direction) {
            Room nextRoom = player.getCurrentRoom().exit(direction);
            if (nextRoom == null) {
                return "There is no exit to the " + direction + ".";
            }

            player.moveTo(nextRoom);
            return nextRoom.enter(player);
        }
    }

    class TextRenderer {
        public String render(Player player) {
            return player.getCurrentRoom().look()
                + "\nHealth: " + player.getHealth()
                + " Score: " + player.getScore();
        }
    }

    class MazeGameFacade {
        private final Maze maze;
        private final Player player;
        private final MovementSystem movement = new MovementSystem();
        private final TextRenderer renderer = new TextRenderer();

        MazeGameFacade() {
            maze = new MazeBuilder().build();
            player = new Player(maze.getStartRoom());
        }

        public String look() {
            return renderer.render(player);
        }

        public String move(Direction direction) {
            return movement.move(player, direction);
        }

        public boolean isFinished() {
            return player.getCurrentRoom() == maze.getExitRoom();
        }
    }

    public void demo() {
        MazeGameFacade game = new MazeGameFacade();

        System.out.println(game.look());
        System.out.println(game.move(Direction.EAST));
        System.out.println(game.move(Direction.SOUTH));
        System.out.println("Finished: " + game.isFinished());
    }

    public static void main(String[] args) {
        new FacadeExample().demo();
    }
}
