package de.unipassau.se2;

import de.unipassau.se2.maze.Direction;
import de.unipassau.se2.maze.Maze;
import de.unipassau.se2.maze.MazeGame;
import de.unipassau.se2.maze.Room;
import java.util.HashMap;
import java.util.Map;

public class BuilderExample {

    class MazeBuilder {
        private final Maze maze = new Maze();
        private final Map<String, Room> rooms = new HashMap<>();

        public MazeBuilder room(String name, String description) {
            Room room = new Room(name, description);
            rooms.put(name, room);
            maze.add(room);
            return this;
        }

        public MazeBuilder connect(String from, Direction direction, String to) {
            Room first = rooms.get(from);
            Room second = rooms.get(to);
            first.connect(direction, second);
            second.connect(direction.opposite(), first);
            return this;
        }

        public MazeBuilder exit(String name) {
            maze.setExitRoom(rooms.get(name));
            return this;
        }

        public Maze build() {
            return maze;
        }
    }

    public void demo() {
        Maze maze = new MazeBuilder()
            .room("Hall", "A quiet entrance hall.")
            .room("Armory", "Old swords hang on the wall.")
            .room("Exit", "Fresh air is close.")
            .connect("Hall", Direction.EAST, "Armory")
            .connect("Armory", Direction.SOUTH, "Exit")
            .exit("Exit")
            .build();

        MazeGame game = new MazeGame(maze);
        System.out.println(game.look());
        System.out.println(game.move(Direction.EAST));
        System.out.println(game.move(Direction.SOUTH));
    }

    public static void main(String[] args) {
        new BuilderExample().demo();
    }
}
