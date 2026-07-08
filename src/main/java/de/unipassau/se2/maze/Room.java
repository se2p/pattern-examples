package de.unipassau.se2.maze;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class Room {
    private final String name;
    private final String description;
    private final Position position;
    private final Map<Direction, Room> exits = new EnumMap<>(Direction.class);

    public Room(String name, String description) {
        this(name, description, new Position(0, 0));
    }

    public Room(String name, String description, Position position) {
        this.name = name;
        this.description = description;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Position getPosition() {
        return position;
    }

    public void connect(Direction direction, Room room) {
        exits.put(direction, room);
    }

    public Room exit(Direction direction) {
        return exits.get(direction);
    }

    public Set<Direction> exits() {
        return exits.keySet();
    }

    public String enter(Player player) {
        return "You enter " + name + ". " + description;
    }

    public String look() {
        return name + ": " + description + "\nExits: " + exits.keySet();
    }
}
