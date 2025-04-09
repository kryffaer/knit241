package org.knit.solutions.Task5;

public class Waiter extends Thread {
    private final Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                restaurant.takeDish();
                Thread.sleep(3000); // Подача блюда
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

