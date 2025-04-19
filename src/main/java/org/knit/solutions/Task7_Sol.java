package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task7.Consumer;
import org.knit.solutions.Task7.Producer;
import org.knit.solutions.Task7.Warehouse;

/*
Производитель создает товары (максимум 5).
Потребитель забирает товары.
Если товаров нет, потребитель ждет (wait()).
Если товаров максимум, производитель ждет (wait()).
✔ wait() – если товаров нет или склад заполнен.
✔ notify() – пробуждение потока, когда изменяется состояние склада.
 */


@TaskDescription(taskNumber = 7, taskDescription = "Производитель: Потребитель с ограничением")
public class Task7_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 7 запущена");
        Warehouse warehouse = new Warehouse();
        Producer producer = new Producer(warehouse);
        Consumer consumer = new Consumer(warehouse);

        producer.start();
        consumer.start();
    }
}
