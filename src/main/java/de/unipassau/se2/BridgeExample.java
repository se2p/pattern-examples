package de.unipassau.se2;

import de.unipassau.se2.maze.MazeGame;

public class BridgeExample {

    interface Renderer {
        void render(String text);
    }

    class MazeView {
        private final MazeGame game;
        private final Renderer renderer;

        MazeView(MazeGame game, Renderer renderer) {
            this.game = game;
            this.renderer = renderer;
        }

        public void show() {
            renderer.render(game.look());
        }
    }

    class TextRenderer implements Renderer {
        @Override
        public void render(String text) {
            System.out.println(text);
        }
    }

    class CompactRenderer implements Renderer {
        @Override
        public void render(String text) {
            System.out.println(text.replace('\n', ' '));
        }
    }

    public void demo() {
        MazeGame game = MazeGame.demoGame();
        new MazeView(game, new TextRenderer()).show();
        new MazeView(game, new CompactRenderer()).show();
    }

    public static void main(String[] args) {
        new BridgeExample().demo();
    }
}
