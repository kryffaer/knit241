package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task11.EmailNotifier;
import org.knit.solutions.Task11.MobileApp;
import org.knit.solutions.Task11.Stock;
import org.knit.solutions.Task11.StockObserver;

/*
Вы разрабатываете приложение для биржевой торговли, где пользователи могут подписываться на обновления акций определённых компаний.
Требуется:
Создать класс Stock (акция), который хранит информацию о текущей цене и может уведомлять подписчиков об изменении цены.
Создать интерфейс StockObserver и реализовать его в классах MobileApp и EmailNotifier, которые получают уведомления при изменении цены.
Реализовать механизм подписки и отписки для StockObserver.
Пример работы:
Пользователь подписывается на акции компании "Tesla".
Когда цена акции изменяется, приложение отправляет уведомления подписчикам.
Если пользователь отписался, он больше не получает уведомления.
 */

@TaskDescription(taskNumber = 11, taskDescription = "Паттерн Observer (Наблюдатель)")
public class Task11_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 11 запущена");
        Stock teslaStock = new Stock("Tesla", 1000.0);

        StockObserver mobileApp = new MobileApp("MyStockApp");
        StockObserver emailNotifier = new EmailNotifier("user@example.com");

        teslaStock.subscribe(mobileApp);
        teslaStock.subscribe(emailNotifier);

        System.out.println("Исходная цена: " + teslaStock.currentPrice);

        teslaStock.updatePrice(1050.0);

        teslaStock.unsubscribe(emailNotifier);

        teslaStock.updatePrice(1100.0);
    }
}