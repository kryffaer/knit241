package org.knit.solutions.Task8;

public class Car implements Runnable {
    private final TrafficLight trafficLight;
    private final String name;

    public Car(TrafficLight trafficLight, String name) {
        this.trafficLight = trafficLight;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Проверяем цвет светофора
                boolean needWait = !trafficLight.isGreenLight();
                if (needWait) {
                    synchronized (System.out) {
                        System.out.println(name + " ждет зеленого света.");
                    }
                    trafficLight.waitForGreen();
                }
                synchronized (System.out) {
                    System.out.println(name + " едет.");
                }
                Thread.sleep(1000); //движение
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

