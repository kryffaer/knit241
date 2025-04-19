package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task16.Char;
import org.knit.solutions.Task16.CharacterFlyweightFactory;

/*
Реализуйте систему отображения символов текста на экране.
Каждый символ (Character) имеет внутреннее состояние (код символа) и внешнее состояние (координаты x, y и стиль).
Используйте Фабрику приспособленцев, чтобы повторно использовать объекты символов и уменьшить количество объектов, создаваемых в системе.
 */

@TaskDescription(taskNumber = 16, taskDescription = "Паттерн Приспособленец (Flyweight)")
public class Task16_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 16 запущена");
        // Создание символов
        Char a = CharacterFlyweightFactory.getCharacter('A');
        Char b = CharacterFlyweightFactory.getCharacter('B');
        Char aAgain = CharacterFlyweightFactory.getCharacter('A');

        a.render(10, 20, "bold");
        b.render(30, 40, "italic");
        aAgain.render(50, 60, "normal");

        // Проверка, что повторно используется один и тот же объект для одного и того же символа
        System.out.println(a == aAgain);
    }
}