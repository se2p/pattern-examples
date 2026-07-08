package de.unipassau.se2.maze;

public class MazeGame {
    private final Maze maze;
    private final Player player;

    public MazeGame(Maze maze) {
        this.maze = maze;
        this.player = new Player(maze.getStartRoom());
    }

    public String look() {
        return player.getCurrentRoom().look() + "\nHealth: " + player.getHealth()
            + " Score: " + player.getScore();
    }

    public String move(Direction direction) {
        Room nextRoom = player.getCurrentRoom().exit(direction);

        if (nextRoom == null) {
            return "There is no exit to the " + direction + ".";
        }

        player.moveTo(nextRoom);
        return nextRoom.enter(player);
    }

    public String map() {
        StringBuilder builder = new StringBuilder();
        for (Room room : maze.getRooms()) {
            if (room == player.getCurrentRoom()) {
                builder.append("* ");
            } else {
                builder.append("  ");
            }
            builder.append(room.getName()).append(" -> ").append(room.exits()).append('\n');
        }
        return builder.toString();
    }

    public boolean isFinished() {
        return player.getCurrentRoom() == maze.getExitRoom();
    }

    public Player getPlayer() {
        return player;
    }

    public static MazeGame demoGame() {
        Room hall = new Room("Hall", "A cold entrance hall.", new Position(0, 0));
        Room armory = new Room("Armory", "Old swords hang on the wall.", new Position(1, 0));
        Room library = new Room("Library", "Dusty books line the shelves.", new Position(0, 1));
        Room exit = new Room("Exit", "Sunlight shines through the gate.", new Position(1, 1));

        hall.connect(Direction.EAST, armory);
        armory.connect(Direction.WEST, hall);
        hall.connect(Direction.SOUTH, library);
        library.connect(Direction.NORTH, hall);
        library.connect(Direction.EAST, exit);
        exit.connect(Direction.WEST, library);

        Maze maze = new Maze();
        maze.setStartRoom(hall);
        maze.add(armory);
        maze.add(library);
        maze.setExitRoom(exit);

        return new MazeGame(maze);
    }
}
