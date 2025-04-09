package org.knit.solutions.Task16;

import java.util.Objects;

// Реализация Character для использования в качестве ключа в HashMap
public class CharacterImpl implements Character {
    private char code;

    public CharacterImpl(char code) {
        this.code = code;
    }

    @Override
    public void render(int x, int y, String style) {
        // Этот метод не используется для ключа
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterImpl that = (CharacterImpl) o;
        return code == that.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

