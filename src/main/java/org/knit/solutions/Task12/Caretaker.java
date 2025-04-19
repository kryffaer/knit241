package org.knit.solutions.Task12;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> savedStates;

    public Caretaker() {
        this.savedStates = new Stack<>();
    }

    public void saveState(Memento memento) {
        savedStates.push(memento);
        System.out.println("Состояние сохранено");
    }

    public Memento undo() {
        if (!savedStates.isEmpty()) {
            Memento lastState = savedStates.pop();
            System.out.println("Отмена изменений...");
            return lastState;
        } else {
            System.out.println("Нет сохранённых состояний");
            return null;
        }
    }
}

