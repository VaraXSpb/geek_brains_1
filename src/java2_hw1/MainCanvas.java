package java2_hw1;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel { // Создаем Холст. На нем можно рисовать, а как - определяют объекты.
    long lastFrameTime;
    private final MainCircles controller; //Этот класс будет рисовать.
    BackGround backGround=new BackGround(this);

    public MainCanvas(MainCircles controller) {
        lastFrameTime = System.nanoTime(); //Получаем время при создании объекта
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();// Получаем время при старте прорисовки
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f; //Получаем разницу, чтобы в дальнейшем вычислить сокрость

        controller.onCanvasRepainted(this, g, deltaTime); //Говорим классу MainCircles нарисовать что-то на Холсте. Передаем его ссылку, кисточку и дельту классу Круги
        backGround.update(backGround.CHANGE_NORMAL);

        try {
            Thread.sleep(16); //Задержка, чтобы не грузить комп и установать 60 fps: 1000/60=16.(6)
        } catch (Exception e) {
            e.printStackTrace();
        }

        lastFrameTime = currentTime; //Запись времени на момент начала прорисовки.
        repaint(); //Принудительно просим Холст обновиться
    }
    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
