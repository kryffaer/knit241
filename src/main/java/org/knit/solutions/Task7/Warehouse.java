package org.knit.solutions.Task7;

public class Warehouse {
    private int goods = 0;
    private final Object lock = new Object();

    public void addGood() throws InterruptedException {
        synchronized (lock) {
            while (goods == 5) {
                System.out.println("Склад заполнен. Производитель ждет.");
                lock.wait();
            }
            goods++;
            System.out.println("Производитель добавил товар. На складе " + goods + " товаров.");
            lock.notify();
        }
    }

    public void takeGood() throws InterruptedException {
        synchronized (lock) {
            while (goods == 0) {
                System.out.println("Склад пуст. Потребитель ждет.");
                lock.wait();
            }
            goods--;
            System.out.println("Потребитель забрал товар. На складе " + goods + " товаров.");
            lock.notify();
        }
    }
}
