package de.unipassau.se2;

import de.unipassau.se2.maze.Player;

public class ProxyExample {

    interface Door {
        String enter(Player player);
    }

    class RealDoor implements Door {
        @Override
        public String enter(Player player) {
            return "You pass through the door.";
        }
    }

    class LockedDoorProxy implements Door {
        private final Door door;

        LockedDoorProxy(Door door) {
            this.door = door;
        }

        @Override
        public String enter(Player player) {
            if (!player.hasKey()) {
                return "The door is locked.";
            }
            return door.enter(player);
        }
    }

    public void demo() {
        Player player = new Player(null);
        Door door = new LockedDoorProxy(new RealDoor());

        System.out.println(door.enter(player));
        player.pickUpKey();
        System.out.println(door.enter(player));
    }

    public static void main(String[] args) {
        new ProxyExample().demo();
    }
}
