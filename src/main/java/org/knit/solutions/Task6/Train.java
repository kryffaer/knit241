package org.knit.solutions.Task6;

public class Train extends Thread {
    private final RailwayCrossing railwayCrossing;

    public Train(RailwayCrossing railwayCrossing) {
        this.railwayCrossing = railwayCrossing;
    }

    @Override
    public void run() {
        railwayCrossing.stopCars();
        try {
            Thread.sleep(3000); // Проезда поезда
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        railwayCrossing.notifyCars();
    }
}

