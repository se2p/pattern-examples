package de.unipassau.se2.maze;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction opposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            default:
                throw new IllegalStateException("Unknown direction: " + this);
        }
    }

    public static Direction fromInput(String input) {
        String normalized = input.trim().toLowerCase();

        if ("n".equals(normalized) || "north".equals(normalized)) {
            return NORTH;
        }
        if ("e".equals(normalized) || "east".equals(normalized)) {
            return EAST;
        }
        if ("s".equals(normalized) || "south".equals(normalized)) {
            return SOUTH;
        }
        if ("w".equals(normalized) || "west".equals(normalized)) {
            return WEST;
        }

        throw new IllegalArgumentException("Unknown direction: " + input);
    }
}
