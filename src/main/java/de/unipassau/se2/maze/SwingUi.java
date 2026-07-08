package de.unipassau.se2.maze;

import javax.swing.*;
import java.awt.*;

public class SwingUi {
    private final MazeGame game;
    private final JTextArea log = new JTextArea(12, 32);

    public SwingUi(MazeGame game) {
        this.game = game;
    }

    public static void show(final MazeGame game) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingUi(game).open();
            }
        });
    }

    public void open() {
        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        log.setEditable(false);
        log.setText(game.look());

        frame.add(new JScrollPane(log), BorderLayout.CENTER);
        frame.add(buttons(), BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel buttons() {
        JPanel panel = new JPanel(new GridLayout(2, 3));

        panel.add(new JPanel());
        panel.add(button("North", Direction.NORTH));
        panel.add(new JPanel());
        panel.add(button("West", Direction.WEST));
        panel.add(button("South", Direction.SOUTH));
        panel.add(button("East", Direction.EAST));

        return panel;
    }

    private JButton button(String label, final Direction direction) {
        JButton button = new JButton(label);
        button.addActionListener(event -> {
            log.append("\n\n" + game.move(direction));
            log.append("\n" + game.look());
        });
        return button;
    }
}
