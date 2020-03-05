package java2_hw1;

import java.awt.*;

public abstract class Sprite {
    protected float x; //координаты центра
    protected float y;
    protected float halfWidth; //половина ширины и высоты для удобства рисования (из центра - радиусы)
    protected float halfHeight;

    protected float getLeft() { //Левая часть спрайта
        return x - halfWidth;
    }
    protected void setLeft(float left) {
        x = left + halfWidth;
    }
    protected float getRight() { //Правая часть спрайта
        return x + halfWidth;
    }
    protected void setRight(float right) {
        x = right - halfWidth;
    }
    protected float getTop() { //верх и далее низ спрайта
        return y - halfHeight;
    }
    protected void setTop(float top) {
        y = top + halfHeight;
    }
    protected float getBottom() {
        return y + halfHeight;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }
    protected float getWidth() {
        return 2f * halfWidth;
    }
    protected float getHeight() {
        return 2f * halfHeight;
    }

    public void update(MainCanvas canvas, float deltaTime){} //Указываем, что в методе будет использоваться класс Холст для отрисовки
    public void render(MainCanvas canvas, Graphics g){} // То есть тот, кто вызовет метод, передаст сюда класс Холста и запросит его методы, аналогично с дельтой.
    //g - выступает в роли кисточки для рисования от Холста. Без нее не получится ничего нарисовать.
}
