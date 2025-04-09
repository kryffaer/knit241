package org.knit.solutions.Task6;

public class RailwayCrossing {
    private boolean trainIsComing = false; // Приближение поезда
    private final Object lock = new Object();

    public void stopCars() {
        synchronized (lock) {
            trainIsComing = true;
            System.out.println("Поезд приближается. Автомобили останавливаются.");
        }
    }

    public void notifyCars() {
        synchronized (lock) {
            trainIsComing = false;
            System.out.println("Поезд прошел. Автомобили могут продолжать движение.");
            lock.notifyAll();
        }
    }

    public void waitIfTrainIsComing() throws InterruptedException {
        synchronized (lock) {
            while (trainIsComing) {
                System.out.println("Автомобиль ждет, пока поезд не проедет.");
                lock.wait();
            }
            System.out.println("Автомобиль продолжает движение.");
        }
    }
}

