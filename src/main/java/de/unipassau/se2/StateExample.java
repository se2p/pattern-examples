package de.unipassau.se2;

import de.unipassau.se2.maze.Player;

public class StateExample {

    interface DoorState {
        String open(Door door, Player player);

        String enter(Player player);
    }

    class Door {
        private DoorState state = new Closed();

        public void setState(DoorState state) {
            this.state = state;
        }

        public String open(Player player) {
            return state.open(this, player);
        }

        public String enter(Player player) {
            return state.enter(player);
        }
    }

    class Closed implements DoorState {
        @Override
        public String open(Door door, Player player) {
            door.setState(new Open());
            return "The door opens.";
        }

        @Override
        public String enter(Player player) {
            return "The door is closed.";
        }
    }

    class Open implements DoorState {
        @Override
        public String open(Door door, Player player) {
            return "The door is already open.";
        }

        @Override
        public String enter(Player player) {
            return "You walk through the open door.";
        }
    }

    class Locked implements DoorState {
        @Override
        public String open(Door door, Player player) {
            if (!player.hasKey()) {
                return "The door is locked.";
            }

            door.setState(new Open());
            return "You unlock and open the door.";
        }

        @Override
        public String enter(Player player) {
            return "The locked door blocks the way.";
        }
    }

    public void demo() {
        Player player = new Player(null);
        Door door = new Door();
        door.setState(new Locked());

        System.out.println(door.enter(player));
        System.out.println(door.open(player));
        player.pickUpKey();
        System.out.println(door.open(player));
        System.out.println(door.enter(player));
    }

    public static void main(String[] args) {
        new StateExample().demo();
    }
}
