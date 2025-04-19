package org.knit.solutions.Task16;

import java.util.HashMap;
import java.util.Map;

public class CharacterFlyweightFactory {
    private static final Map<Character, Char> pool = new HashMap<>();

    public static Char getCharacter(char code) {
        Character key = new CharacterImpl(code);
        Char character = pool.get(key);
        if (character == null) {
            character = new Char(code);
            pool.put(key, character);
        }
        return character;
    }
}
