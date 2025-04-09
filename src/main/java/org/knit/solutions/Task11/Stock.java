package org.knit.solutions.Task11;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String companyName;
    public double currentPrice;
    private List<StockObserver> observers;

    public Stock(String companyName, double initialPrice) {
        this.companyName = companyName;
        this.currentPrice = initialPrice;
        this.observers = new ArrayList<>();
    }

    public void subscribe(StockObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("Подписчик добавлен: " + observer.getClass().getSimpleName());
        }
    }

    public void unsubscribe(StockObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
            System.out.println("Подписчик удалён: " + observer.getClass().getSimpleName());
        }
    }

    public void updatePrice(double newPrice) {
        if (newPrice != currentPrice) {
            currentPrice = newPrice;
            notifyObservers();
        }
    }

    private void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(companyName, currentPrice);
        }
    }
}
