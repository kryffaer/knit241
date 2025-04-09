package org.knit.solutions.Task16;

public class Char implements Character {
    private final char code;

    public Char(char code) {
        this.code = code;
    }

    @Override
    public void render(int x, int y, String style) {
        System.out.println("Отображение символа '" + code + "' в позиции (" + x + ", " + y + ") с стилем " + style);
    }
}
