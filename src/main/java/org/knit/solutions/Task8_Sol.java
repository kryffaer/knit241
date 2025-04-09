package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task8.Car;
import org.knit.solutions.Task8.TrafficLight;
import org.knit.solutions.Task8.TrafficLightThread;

/*
На перекрестке светофор управляет движением:
Красный свет – машины стоят (wait()).
Зеленый свет – машины едут (notifyAll()).
Светофор переключается каждые 5 секунд.
✔ Поток "Светофор" изменяет цвет и отправляет notifyAll().
✔ Потоки "Машина" ждут wait(), если красный свет.
 */

@TaskDescription(taskNumber = 8, taskDescription = "Перекресток: светофор и машины")
public class Task8_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 8 запущена");
        TrafficLight trafficLight = new TrafficLight();

        Thread trafficLightThread = new Thread(new TrafficLightThread(trafficLight));
        trafficLightThread.start();

        for (int i = 0; i < 3; i++) {
            Thread carThread = new Thread(new Car(trafficLight, "Машина " + (i + 1)));
            carThread.start();
        }
    }
}