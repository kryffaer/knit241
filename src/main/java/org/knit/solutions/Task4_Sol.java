package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task4.Car;
import org.knit.solutions.Task4.GasStation;

/*
На автозаправочной станции только 2 колонки. Если все заняты, машины ждут в очереди.
Когда колонка освобождается, следующий автомобиль из очереди начинает заправку.
✔ Использовать wait() и notify() для ожидания и освобождения заправки.
✔ Поток "Машина" ждет, если все колонки заняты.
✔ Поток "Машина" заправляется, затем освобождает колонку.
 */

@TaskDescription(taskNumber = 4, taskDescription = "Автозаправочная станция")
public class Task4_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 4 запущена");
        GasStation gasStation = new GasStation();

        for (int i = 0; i < 5; i++) {
            Car car = new Car(gasStation, "Машина " + (i + 1));
            car.start();
        }
    }
}