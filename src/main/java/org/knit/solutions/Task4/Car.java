package org.knit.solutions.Task4;

public class Car extends Thread {
    private final GasStation gasStation;
    private final String name;

    public Car(GasStation gasStation, String name) {
        this.gasStation = gasStation;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " подъехала к заправке.");
            gasStation.acquirePump(); // Заняли
            Thread.sleep(1500); // Запрвляемся
            gasStation.releasePump(); // Освободили
            System.out.println(name + " заправилась и уехала.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
