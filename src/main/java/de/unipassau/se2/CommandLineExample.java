package de.unipassau.se2;

import de.unipassau.se2.maze.MazeGame;
import de.unipassau.se2.maze.TextUi;
import java.util.Arrays;

public class CommandLineExample {

    public void demo() {
        TextUi.play(MazeGame.demoGame(), Arrays.asList("look", "east", "west", "south", "east"));
    }

    public void interactiveDemo() {
        new TextUi(MazeGame.demoGame()).run();
    }

    public static void main(String[] args) {
        CommandLineExample example = new CommandLineExample();
        if (args.length > 0 && "interactive".equals(args[0])) {
            example.interactiveDemo();
        } else {
            example.demo();
        }
    }
}
