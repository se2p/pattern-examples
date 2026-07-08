package de.unipassau.se2;

import java.util.ArrayList;
import java.util.List;

public class VisitorExample {

    interface MazeElement {
        void accept(MazeVisitor visitor);
    }

    class TreasureRoom implements MazeElement {
        private final String name;
        private final boolean hasTreasure;

        TreasureRoom(String name, boolean hasTreasure) {
            this.name = name;
            this.hasTreasure = hasTreasure;
        }

        @Override
        public void accept(MazeVisitor visitor) {
            visitor.visit(this);
        }
    }

    class Maze implements MazeElement {
        private final List<MazeElement> elements = new ArrayList<>();

        public void add(MazeElement element) {
            elements.add(element);
        }

        @Override
        public void accept(MazeVisitor visitor) {
            visitor.visit(this);
            for (MazeElement element : elements) {
                element.accept(visitor);
            }
        }
    }

    interface MazeVisitor {
        void visit(Maze maze);

        void visit(TreasureRoom room);
    }

    class TreasureCountingVisitor implements MazeVisitor {
        private int treasures;

        @Override
        public void visit(Maze maze) {
            System.out.println("Scanning maze...");
        }

        @Override
        public void visit(TreasureRoom room) {
            if (room.hasTreasure) {
                treasures++;
            }
        }

        public int getTreasures() {
            return treasures;
        }
    }

    public void demo() {
        Maze maze = new Maze();
        maze.add(new TreasureRoom("Hall", false));
        maze.add(new TreasureRoom("Vault", true));
        maze.add(new TreasureRoom("Library", true));

        TreasureCountingVisitor visitor = new TreasureCountingVisitor();
        maze.accept(visitor);

        System.out.println("Treasures: " + visitor.getTreasures());
    }

    public static void main(String[] args) {
        new VisitorExample().demo();
    }
}
