package org.knit.solutions.Task6;

public class Car extends Thread {
    private final RailwayCrossing railwayCrossing;
    private final String name;

    public Car(RailwayCrossing railwayCrossing, String name) {
        this.railwayCrossing = railwayCrossing;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " начинает движение.");
        try {
            railwayCrossing.waitIfTrainIsComing();
            Thread.sleep(1000); // Движение автомобиля
            System.out.println(name + " завершил движение.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

