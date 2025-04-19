package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task13.*;

/*
Вы разрабатываете систему управления "умным домом", где пользователь может выполнять различные команды, такие как включение/выключение света, управление телевизором и кондиционером.
Требуется:
Создать интерфейс Command, который определяет метод execute().
Реализовать классы команд:
LightOnCommand – включает свет.
LightOffCommand – выключает свет.
TVOnCommand – включает телевизор.
TVOffCommand – выключает телевизор.
Создать класс RemoteControl, который хранит команду и позволяет её выполнить.
Реализовать механизм отмены последней команды (undo).
Пример работы:
Пользователь нажимает кнопку "Включить свет" – выполняется LightOnCommand.
Затем нажимает "Выключить телевизор" – выполняется TVOffCommand.
Пользователь нажимает "Отменить последнюю команду" – телевизор снова включается.
 */

@TaskDescription(taskNumber = 13, taskDescription = "Паттерн Command (Команда)")
public class Task13_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 13 запущена");
        // Устройства
        Light livingRoomLight = new Light();
        TV samsungTV = new TV();

        // Команды
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command tvOn = new TVOnCommand(samsungTV);
        Command tvOff = new TVOffCommand(samsungTV);

        // Настраиваем пульт
        RemoteControl remote = new RemoteControl();

        // Тестируем команды
        remote.setCommand(lightOn);
        remote.pressButton(); // Включаем свет

        remote.setCommand(tvOff);
        remote.pressButton(); // Выключаем телевизор

        remote.undoLastCommand(); // Отменяем последнюю команду (телевизор включается)
    }
}