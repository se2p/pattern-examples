package de.unipassau.se2;

import de.unipassau.se2.maze.Direction;

public class AdapterExample {

    class LegacyKeyboard {
        String readKey() {
            return "n";
        }
    }

    interface DirectionInput {
        Direction nextDirection();
    }

    class KeyboardAdapter implements DirectionInput {
        private final LegacyKeyboard keyboard;

        KeyboardAdapter(LegacyKeyboard keyboard) {
            this.keyboard = keyboard;
        }

        @Override
        public Direction nextDirection() {
            return Direction.fromInput(keyboard.readKey());
        }
    }

    public void demo() {
        DirectionInput input = new KeyboardAdapter(new LegacyKeyboard());
        System.out.println("Move " + input.nextDirection());
    }

    public static void main(String[] args) {
        new AdapterExample().demo();
    }
}
