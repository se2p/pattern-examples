package de.unipassau.se2;

import de.unipassau.se2.maze.Direction;
import de.unipassau.se2.maze.MazeGame;
import java.util.ArrayList;
import java.util.List;

public class CommandExample {

    interface Command {
        void execute();
    }

    interface UndoableCommand extends Command {
        void undo();
    }

    class MoveCommand implements Command {
        private final MazeGame game;
        private final Direction direction;

        MoveCommand(MazeGame game, Direction direction) {
            this.game = game;
            this.direction = direction;
        }

        @Override
        public void execute() {
            System.out.println(game.move(direction));
        }
    }

    class UndoableMoveCommand implements UndoableCommand {
        private final MazeGame game;
        private final Direction direction;

        UndoableMoveCommand(MazeGame game, Direction direction) {
            this.game = game;
            this.direction = direction;
        }

        @Override
        public void execute() {
            System.out.println(game.move(direction));
        }

        @Override
        public void undo() {
            System.out.println(game.move(direction.opposite()));
        }
    }

    class Inventory {
        private final List<String> items = new ArrayList<>();

        public void pickUp(String item) {
            items.add(item);
            System.out.println("Picked up: " + item);
        }

        public void drop(String item) {
            items.remove(item);
            System.out.println("Dropped: " + item);
        }
    }

    class PickUpCommand implements UndoableCommand {
        private final Inventory inventory;
        private final String item;

        PickUpCommand(Inventory inventory, String item) {
            this.inventory = inventory;
            this.item = item;
        }

        @Override
        public void execute() {
            inventory.pickUp(item);
        }

        @Override
        public void undo() {
            inventory.drop(item);
        }
    }

    class CommandHistory {
        private final List<Command> commands = new ArrayList<>();
        private final List<UndoableCommand> undoableCommands = new ArrayList<>();

        public void run(Command command) {
            commands.add(command);
            if (command instanceof UndoableCommand) {
                undoableCommands.add((UndoableCommand) command);
            }
            command.execute();
        }

        public void undoLast() {
            if (undoableCommands.isEmpty()) {
                return;
            }

            UndoableCommand command = undoableCommands.remove(undoableCommands.size() - 1);
            command.undo();
        }

        public int size() {
            return commands.size();
        }
    }

    public void demo() {
        MazeGame game = MazeGame.demoGame();
        Inventory inventory = new Inventory();
        CommandHistory history = new CommandHistory();

        history.run(new UndoableMoveCommand(game, Direction.EAST));
        history.run(new PickUpCommand(inventory, "key"));
        history.undoLast();
        history.undoLast();
        history.run(new MoveCommand(game, Direction.EAST));

        System.out.println("Commands executed: " + history.size());
    }

    public static void main(String[] args) {
        new CommandExample().demo();
    }
}
