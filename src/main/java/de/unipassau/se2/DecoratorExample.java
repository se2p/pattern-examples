package de.unipassau.se2;

import de.unipassau.se2.maze.Player;

public class DecoratorExample {

    interface EnterableRoom {
        String enter(Player player);
    }

    class PlainRoom implements EnterableRoom {
        private final String name;

        PlainRoom(String name) {
            this.name = name;
        }

        @Override
        public String enter(Player player) {
            return "You enter " + name + ".";
        }
    }

    abstract class RoomDecorator implements EnterableRoom {
        private final EnterableRoom room;

        RoomDecorator(EnterableRoom room) {
            this.room = room;
        }

        @Override
        public String enter(Player player) {
            return room.enter(player);
        }
    }

    class TrapRoom extends RoomDecorator {
        TrapRoom(EnterableRoom room) {
            super(room);
        }

        @Override
        public String enter(Player player) {
            player.damage(2);
            return super.enter(player) + " A trap hits you. Health: " + player.getHealth();
        }
    }

    class TreasureRoom extends RoomDecorator {
        TreasureRoom(EnterableRoom room) {
            super(room);
        }

        @Override
        public String enter(Player player) {
            player.addScore(10);
            return super.enter(player) + " You find treasure. Score: " + player.getScore();
        }
    }

    public void demo() {
        Player player = new Player(null);
        EnterableRoom room = new TreasureRoom(new TrapRoom(new PlainRoom("Vault")));

        System.out.println(room.enter(player));
    }

    public static void main(String[] args) {
        new DecoratorExample().demo();
    }
}
