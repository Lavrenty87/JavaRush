package com.javarush.task.task35.task3513;

import java.awt.*;

public class Tile {
    int value;//1. Поле value типа int, уровень доступа по умолчанию.
    //2. Конструктор с параметром, инициализирующий поле value.
    public Tile(int value) {
        this.value = value;
    }
    //3. Конструктор без параметров (значение поля value должно быть равно нулю).
    public Tile() {
        this.value = 0;
    }
    //4. Метод isEmpty, возвращающий true в случае, если значение поля value равно 0, иначе - false.
    public boolean isEmpty() {
        return value == 0 ? true : false;
    }
    //5. Метод getFontColor, возвращающий новый цвет(объект типа Color) (0x776e65) в случае, если вес плитки меньше 16, иначе - 0xf9f6f2.
    public Color getFontColor() {
        return value < 16 ? new Color(0x776e65) : new Color(0xf9f6f2);
    }
    //6. Метод getTileColor, возвращающий цвет плитки в зависимости от ее веса в соответствии с нижеприведенными значениями:
    public Color getTileColor() {
        Color color = null;
        switch (value) {
            case 0 : color = new Color(0xcdc1b4);//0: (0xcdc1b4);
                break;
            case 2 : color = new Color(0xeee4da); //2: (0xeee4da);
                break;
            case 4 : color = new Color(0xede0c8); //4: (0xede0c8);
                break;
            case 8 : color = new Color(0xf2b179);//8: (0xf2b179);
                break;
            case 16 : color = new Color(0xf59563);//16: (0xf59563);
                break;
            case 32 : color = new Color(0xf67c5f); //32: (0xf67c5f);
                break;
            case 64 : color = new Color(0xf65e3b);//64: (0xf65e3b);
                break;
            case 128 : color = new Color(0xedcf72);//128: (0xedcf72);
                break;
            case 256 : color = new Color(0xedcc61);//256: (0xedcc61);
                break;
            case 512 : color = new Color(0xedc850);//512: (0xedc850);
                break;
            case 1024 : color = new Color(0xedc53f);//1024: (0xedc53f);
                break;
            case 2048 : color = new Color(0xedc22e);//2048: (0xedc22e);
                break;
        }
        if (color == null) color = new Color(0xff0000);//для любых других значений: (0xff0000).
        return color;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
