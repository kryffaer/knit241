package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task5.Cook;
import org.knit.solutions.Task5.Restaurant;
import org.knit.solutions.Task5.Waiter;

/*
В ресторане работает один повар и один официант.
Повар готовит блюда и ставит их на поднос (максимум 3 блюда).
Официант берет готовые блюда и подает их клиентам.
✔ Повар не может готовить больше 3 блюд (ждет wait()).
✔ Официант ждет, если поднос пуст (wait()).
✔ При каждой передаче блюда используется notify().
 */

@TaskDescription(taskNumber = 5, taskDescription = "Ресторан: Повар и Официант")
public class Task5_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 5 запущена");
        Restaurant restaurant = new Restaurant();
        Cook cook = new Cook(restaurant);
        Waiter waiter = new Waiter(restaurant);

        cook.start();
        waiter.start();
    }
}
