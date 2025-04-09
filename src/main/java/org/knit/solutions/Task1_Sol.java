package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task1.*;

/*
Этот паттерн используется для передачи запроса по цепочке обработчиков, пока один из них не обработает его.
Каждый обработчик в цепочке может либо обработать запрос, либо передать его дальше.
Задача:
Реализуйте систему обработки жалоб клиентов в банке.
Жалоба сначала поступает в колл-центр.
Если проблема сложная, запрос передается менеджеру.
Если даже менеджер не может решить проблему, запрос уходит в юридический отдел.
Каждый уровень обработки либо решает проблему, либо передает ее дальше.
 */

@TaskDescription(taskNumber = 1, taskDescription = "Chain of Responsibility (Цепочка обязанностей)", href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task1_Sol implements Solution {
    @Override
    public void execute() {
        System.out.println("Задача 1 запущена");
        Approver junior = new JuniorManager();
        Approver senior = new SeniorManager();
        Approver legalDepartment = new LegalDepartment();
        Approver director = new Director();

        junior.setNextApprover(senior);
        senior.setNextApprover(legalDepartment);
        legalDepartment.setNextApprover(director);

        Problem problem0 = new Problem("В какое время работает банк?", 33);
        Problem problem1 = new Problem("Предоставляются ли кредитные карты?", 358);
        Problem problem2 = new Problem("Где оставить отзыв о работе банка?", 940);
        Problem problem3 = new Problem("Не могу войти в личный кабинет на сайте.", 1502);
        Problem problem4 = new Problem("Почему моя плейстейшн не летает?", 2000);

        junior.processRequest(problem0);
        junior.processRequest(problem1);
        junior.processRequest(problem2);
        junior.processRequest(problem3);
        junior.processRequest(problem4);
    }
}
