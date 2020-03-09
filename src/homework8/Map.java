package homework8;

import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    public static final int HUMAN_VS_AI = 0;
    public static final int HUMAN_VS_HUMAN = 1;
    int fieldSizeX;
    int fieldSizeY;
    int cellHeight;
    int cellWidth;
    int cellX;
    int cellY;
    int mod;
    Logic logic;
    private int ctr = 0;
    private GameWindow window;

    boolean isInitialize = false;


    public Map(GameWindow window) {
        this.window=window;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        setBackground(Color.ORANGE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    public void render(Graphics g) {
        if (!isInitialize) {
            return;
        }
        printMap(g);
        logic.update(this, g);
    }

    private void printMap(Graphics g) {

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSizeY;
        cellHeight = panelHeight / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
    }

    public void startNewGame(int mod, int fieldSizeX, int fieldSizeY, int winLength, StartNewGameWindow startWindow) {
        ctr = 0;
        System.out.println(mod + " " + fieldSizeX + " " + fieldSizeY + " " + winLength);
        this.fieldSizeY = fieldSizeY;
        this.fieldSizeX = fieldSizeX;
        this.mod = mod;

        logic = new Logic(window, startWindow);
        logic.initMap(fieldSizeX);
        logic.setDotsToWinValue(winLength);

        isInitialize = true;
        repaint();
    }

    private void update(MouseEvent e) {
        cellX = e.getX() / cellWidth;
        cellY = e.getY() / cellHeight;

        if (!logic.gameFinish && mod == HUMAN_VS_AI) {
            logic.playerTurn(cellX, cellY);
        } else if (!logic.gameFinish && mod == HUMAN_VS_HUMAN) {
            ctr++;
            if (ctr % 2 != 0) {
                logic.playerXTurn(cellX, cellY);
            } else {
                logic.playerOTurn(cellX, cellY);
            }
        }

        repaint();
    }

    protected void drawX(Graphics g, int cellX, int cellY) {
        g.setColor(Color.RED);
        g.drawLine(cellX * cellWidth, cellY * cellHeight, (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);
        g.drawLine(cellX * cellWidth, (cellY + 1) * cellHeight, (cellX + 1) * cellWidth, (cellY) * cellHeight);
    }

    protected void drawO(Graphics g, int cellX, int cellY) {
        g.setColor(Color.BLUE);
        g.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);
    }
}
