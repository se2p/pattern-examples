package de.unipassau.se2.maze;

public class Door {
    private final Room destination;
    private boolean locked;

    public Door(Room destination) {
        this.destination = destination;
    }

    public void lock() {
        locked = true;
    }

    public String enter(Player player) {
        if (locked && !player.hasKey()) {
            return "The door is locked.";
        }

        player.moveTo(destination);
        return destination.enter(player);
    }
}
