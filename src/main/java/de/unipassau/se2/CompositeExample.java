package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class CompositeExample {

    interface MazeElement {
        String render();

        default void add(MazeElement element) {
            throw new UnsupportedOperationException("Only maze sections can contain children");
        }
    }

    class RoomElement implements MazeElement {
        private final String name;

        RoomElement(String name) {
            this.name = name;
        }

        @Override
        public String render() {
            return "- room: " + name + "\n";
        }
    }

    class MazeSection implements MazeElement {
        private final String name;
        private final List<MazeElement> children = new ArrayList<>();

        MazeSection(String name) {
            this.name = name;
        }

        @Override
        public void add(MazeElement element) {
            children.add(element);
        }

        @Override
        public String render() {
            StringBuilder builder = new StringBuilder("+ section: " + name + "\n");
            for (MazeElement child : children) {
                builder.append(child.render());
            }
            return builder.toString();
        }
    }

    public void demo() {
        MazeElement maze = new MazeSection("Dungeon");
        MazeElement westWing = new MazeSection("West wing");
        MazeElement eastWing = new MazeSection("East wing");

        westWing.add(new RoomElement("Hall"));
        westWing.add(new RoomElement("Armory"));
        eastWing.add(new RoomElement("Library"));
        eastWing.add(new RoomElement("Exit"));

        maze.add(westWing);
        maze.add(eastWing);

        System.out.println(maze.render());
    }

    public static void main(String[] args) {
        new CompositeExample().demo();
    }
}
