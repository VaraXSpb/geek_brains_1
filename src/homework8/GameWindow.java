package homework8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static int WINDOW_POS_X = 500;
    private static int WINDOW_POS_Y = 300;
    private static int WINDOW_HEIGHT = 555;
    private static int WINDOW_WIDTH = 507;
    StartNewGameWindow window;
    Map field;

    public GameWindow() {
        setTitle("XO Game");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnNewGame = new JButton("New Game");
        JButton btnExit = new JButton("Exit");

        panel.add(btnNewGame);
        panel.add(btnExit);

        window = new StartNewGameWindow(this);
        field = new Map(this);
        add(panel, BorderLayout.SOUTH);
        add(field, BorderLayout.CENTER);

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        btnNewGame.addActionListener(e -> {
            window.setVisible(true);
        });

        setVisible(true);
    }

    public void startNewGame(int mod, int fieldSizeX, int fieldSizeY, int winLength, StartNewGameWindow startWindow) {
        field.startNewGame(mod, fieldSizeX, fieldSizeY, winLength, startWindow);
    }

}
