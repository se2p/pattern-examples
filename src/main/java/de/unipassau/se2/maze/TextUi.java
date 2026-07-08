package de.unipassau.se2.maze;

import java.util.List;
import java.util.Scanner;

public class TextUi {
    private final MazeGame game;

    public TextUi(MazeGame game) {
        this.game = game;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(game.look());

        while (!game.isFinished()) {
            System.out.print("> ");
            System.out.println(handle(scanner.nextLine()));
        }
    }

    public String handle(String input) {
        String command = input.trim().toLowerCase();

        if ("look".equals(command)) {
            return game.look();
        }
        if ("map".equals(command)) {
            return game.map();
        }

        try {
            return game.move(Direction.fromInput(command));
        } catch (IllegalArgumentException exception) {
            return "Try north, east, south, west, look, or map.";
        }
    }

    public static void play(MazeGame game, List<String> commands) {
        TextUi ui = new TextUi(game);
        System.out.println(game.look());
        for (String command : commands) {
            System.out.println("> " + command);
            System.out.println(ui.handle(command));
        }
    }
}
