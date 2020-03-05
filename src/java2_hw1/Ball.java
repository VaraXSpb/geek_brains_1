package java2_hw1;

import java.awt.*;

public class Ball extends Sprite {

    private final Color color = new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );
    private float vX = (float) (100f + (Math.random() * 200f)); //Скорости по Осям Х и У. Генерируются рандомно в диапазоне 100 - 300
    private float vY = (float) (100f + (Math.random() * 200f));

    Ball() {
        halfHeight = 20 + (float) (Math.random() * 50f); // Определим рандомно размер шара. 20 - минимальный размер
        halfWidth = halfHeight;
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) { //Метод изменения положения Шара - рассчетный модуль
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < canvas.getLeft()) { //Проверки, вылетел ли шар за пределы фрейма
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) { //Метод для отрисовки
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
