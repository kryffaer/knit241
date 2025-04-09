package org.knit.solutions.Task5;

public class Restaurant {
    private int dishes = 0; // Количество блюд на подносе
    private final Object lock = new Object(); // Объект для синхронизации

    public void addDish() throws InterruptedException {
        synchronized (lock) {
            while (dishes == 3) {
                System.out.println("Поднос полон. Повар ждет.");
                lock.wait();
            }
            dishes++;
            System.out.println("Повар добавил блюдо. На подносе " + dishes + " блюд.");
            lock.notify(); // Уведомить официанта
        }
    }

    public void takeDish() throws InterruptedException {
        synchronized (lock) {
            while (dishes == 0) {
                System.out.println("Поднос пуст. Официант ждет.");
                lock.wait();
            }
            dishes--;
            System.out.println("Официант взял блюдо. На подносе " + dishes + " блюд.");
            lock.notify(); // Уведомить повара
        }
    }
}

