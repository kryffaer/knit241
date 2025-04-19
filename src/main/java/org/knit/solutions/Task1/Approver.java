package org.knit.solutions.Task1;

public abstract class Approver {
    protected Approver nextApprover; // Следующий обработчик в цепочке

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    // Обработка запроса
    public void processRequest(Problem amount) {
        if (canApprove(amount)) {
            approve(amount);
        } else if (nextApprover != null) {
            nextApprover.processRequest(amount); // Передача запроса дальше
        } else {
            System.out.println("Вопроc '" + amount.getText() + "' отклонен: слишком сложно.");
        }
    }

    protected abstract boolean canApprove(Problem amount); // Проверка лимита
    protected abstract void approve(Problem amount); // Логика одобрения
}
