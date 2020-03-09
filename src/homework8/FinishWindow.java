package homework8;

import javax.swing.*;
import java.awt.*;

public class FinishWindow extends JFrame {
    private static int WINDOW_POS_X = 500;
    private static int WINDOW_POS_Y = 350;
    private static int WINDOW_HEIGHT = 455;
    private static int WINDOW_WIDTH = 507;

    public FinishWindow(GameWindow window, StartNewGameWindow startWindow, String msg) {
        //window.setVisible(false);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Finish");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnNewGame = new JButton("New Game");
        JButton btnExit = new JButton("Exit");

        panel.add(btnNewGame);
        panel.add(btnExit);

        Font font=new Font("Serif",Font.BOLD,25);
        JLabel jLabel = new JLabel(msg);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setFont(font);
        jLabel.setForeground(Color.ORANGE);

        add(panel, BorderLayout.SOUTH);
        add(jLabel, BorderLayout.CENTER);

        btnNewGame.addActionListener(e -> {
            startWindow.setVisible(true);
            setVisible(false);
        });
        btnExit.addActionListener(e -> {
            System.exit(0);
        });


        setVisible(true);

    }
}
