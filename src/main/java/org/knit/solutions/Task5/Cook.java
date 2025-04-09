package org.knit.solutions.Task5;

public class Cook extends Thread {
    private final Restaurant restaurant;

    public Cook(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                restaurant.addDish();
                Thread.sleep(1000); // Приготовление блюда
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

