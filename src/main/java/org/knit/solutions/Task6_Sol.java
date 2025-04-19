package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task6.Car;
import org.knit.solutions.Task6.RailwayCrossing;
import org.knit.solutions.Task6.Train;

/*
Есть автомобили и поезд.
Если поезд приближается, машины останавливаются и ждут.
После того, как поезд проедет, машины продолжают движение.
✔ Поток "Поезд" останавливает автомобили (wait()).
✔ Поток "Поезд" сообщает о завершении (notifyAll()).
✔ Машины ждут, если поезд едет, и продолжают движение после notifyAll().
 */

@TaskDescription(taskNumber = 6, taskDescription = "Железнодорожный переезд")
public class Task6_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 6 запущена");
        RailwayCrossing railwayCrossing = new RailwayCrossing();
        Train train = new Train(railwayCrossing);

        for (int i = 0; i < 3; i++) {
            Car car = new Car(railwayCrossing, "Машина " + (i + 1));
            car.start();
        }
        train.start();
    }
}
