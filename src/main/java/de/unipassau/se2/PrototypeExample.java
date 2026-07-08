package de.unipassau.se2;

import java.util.HashMap;
import java.util.Map;

public class PrototypeExample {

    abstract class RoomPrototype {
        private final String name;
        private final int damage;

        RoomPrototype(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        protected String getName() {
            return name;
        }

        protected int getDamage() {
            return damage;
        }

        public abstract RoomPrototype copy(String name);

        public abstract String describe();
    }

    class TrapRoom extends RoomPrototype {
        TrapRoom(String name, int damage) {
            super(name, damage);
        }

        @Override
        public RoomPrototype copy(String name) {
            return new TrapRoom(name, getDamage());
        }

        @Override
        public String describe() {
            return getName() + ": trap room, damage " + getDamage();
        }
    }

    class SafeRoom extends RoomPrototype {
        SafeRoom(String name) {
            super(name, 0);
        }

        @Override
        public RoomPrototype copy(String name) {
            return new SafeRoom(name);
        }

        @Override
        public String describe() {
            return getName() + ": safe room";
        }
    }

    class RoomRegistry {
        private final Map<String, RoomPrototype> prototypes = new HashMap<>();

        public void register(String key, RoomPrototype prototype) {
            prototypes.put(key, prototype);
        }

        public RoomPrototype create(String key, String name) {
            return prototypes.get(key).copy(name);
        }
    }

    public void demo() {
        RoomRegistry registry = new RoomRegistry();
        registry.register("trap", new TrapRoom("Trap prototype", 3));
        registry.register("safe", new SafeRoom("Safe prototype"));

        System.out.println(registry.create("trap", "Spike Hall").describe());
        System.out.println(registry.create("safe", "Camp").describe());
    }

    public static void main(String[] args) {
        new PrototypeExample().demo();
    }
}
