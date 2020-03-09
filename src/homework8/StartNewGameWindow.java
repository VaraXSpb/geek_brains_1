package homework8;

import javax.swing.*;
import java.awt.*;

public class StartNewGameWindow extends JFrame {
    private final GameWindow gameWindow;

    private static int WINDOW_POS_X = 500;
    private static int WINDOW_POS_Y = 350;
    private static int WINDOW_HEIGHT = 455;
    private static int WINDOW_WIDTH = 407;
    private static int MIN_FIELD_SIZE = 3;
    private static int MAX_FIELD_SIZE = 10;
    private static int MIN_WIN_LINE = 3;
    private static int MAX_WIN_LINE = 10;
    private static final String STR_FIELD_SIZE = "Field size: ";
    private static final String STR_WIN_LINE = "Win Line size: ";


    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private ButtonGroup gameMod;

    private JSlider slFieldSize;
    private JSlider slWinLength;


    public StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow=gameWindow;

        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("XO Settings");
        setLayout(new GridLayout(10, 1));
        setResizable(false);

        jrbHumVsAi = new JRadioButton("Human VS AI", true);
        jrbHumVsHum = new JRadioButton("Human VS Human");
        gameMod = new ButtonGroup();

        add(new JLabel("Game Mode"));
        gameMod.add(jrbHumVsAi);
        gameMod.add(jrbHumVsHum);

        add(jrbHumVsAi);
        add(jrbHumVsHum);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MAX_FIELD_SIZE);
        slWinLength = new JSlider(MIN_WIN_LINE, MIN_WIN_LINE, MIN_WIN_LINE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintTicks(true);
        slFieldSize.setPaintLabels(true);
        slWinLength.setMajorTickSpacing(1);
        slWinLength.setPaintTicks(true);
        slWinLength.setPaintLabels(true);
        add(new JLabel("Select Field Size"));
        JLabel jlFieldSize = new JLabel(STR_FIELD_SIZE + " " + MIN_FIELD_SIZE);
        add(jlFieldSize);

        add(slFieldSize);
        add(new JLabel("Select Win Line Length"));
        JLabel jlWinLength = new JLabel(STR_WIN_LINE + " " + MIN_WIN_LINE);
        add(jlWinLength);
        add(slWinLength);

        slFieldSize.addChangeListener(e -> {
            int currentFieldSize = slFieldSize.getValue();
            jlFieldSize.setText(STR_FIELD_SIZE + " " + currentFieldSize);
            slWinLength.setMaximum(currentFieldSize);
        });

            slWinLength.addChangeListener(e -> {
            jlWinLength.setText(STR_WIN_LINE + " " + slWinLength.getValue());
        });

        JButton startGame = new JButton("Start Game");
        add(startGame);
        startGame.addActionListener(e -> {
            int gameMod=1;
            if (jrbHumVsAi.isSelected()){
                gameMod=0;
            }

            int fieldSize=slFieldSize.getValue();
            int winLength=slWinLength.getValue();

            gameWindow.startNewGame(gameMod,fieldSize,fieldSize,winLength,this);
            setVisible(false);
        });

        setVisible(false);

    }

}

