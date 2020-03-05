package java2_hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Sprite[] sprites = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        initApplication();

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    addCircle(sprites);
                } else if (e.getButton() == MouseEvent.BUTTON3 && sprites.length > 0)
                    removeCircle(sprites);
            }
        });

        setVisible(true);
    }

    private void initApplication() { // Создать шары
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) { //Параметры получим из Холста, там этот метод вызыватеся
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    public void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    private void addCircle(Sprite[] sprites) {
        Sprite[] newSprites = new Sprite[sprites.length + 1];
        for (int i = 0; i < sprites.length; i++) {
            newSprites[i] = sprites[i];
        }
        newSprites[newSprites.length - 1] = new Ball();
        this.sprites = newSprites;
    }

    private void removeCircle(Sprite[] sprites) {
        Sprite[] newSprites = new Sprite[sprites.length - 1];
        for (int i = 0; i < sprites.length - 1; i++) {
            newSprites[i] = sprites[i];
        }
        this.sprites = newSprites;
    }
}
