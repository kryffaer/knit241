package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task12.Caretaker;
import org.knit.solutions.Task12.Memento;
import org.knit.solutions.Task12.TextEditor;

/*
Разработайте систему, позволяющую сохранять состояния текста в редакторе и откатывать изменения назад.
Требуется:
Создать класс TextEditor, который содержит текущий текст документа.
Создать класс Memento, который будет хранить снимок состояния текста.
Реализовать Caretaker, который управляет историей изменений (например, стек сохранённых состояний).
Реализовать методы saveState() и undo() для сохранения и отката изменений.
Пример работы:
Пользователь вводит текст "Hello, world!".
Он сохраняет текущее состояние.
Затем добавляет " How are you?".
Нажимает "Отменить" и возвращается к "Hello, world!".
 */

@TaskDescription(taskNumber = 12, taskDescription = "Паттерн Memento (Хранитель)")
public class Task12_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 12 запущена");
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.setText("Hello, world!");
        System.out.println("Текущий текст: " + editor.getText());

        caretaker.saveState(editor.saveState());

        editor.setText(editor.getText() + " How are you?");
        System.out.println("Текущий текст после изменений: " + editor.getText());

        Memento lastState = caretaker.undo();
        if (lastState != null) {
            editor.restoreState(lastState);
            System.out.println("Текст после отмены изменений: " + editor.getText());
        }
    }
}