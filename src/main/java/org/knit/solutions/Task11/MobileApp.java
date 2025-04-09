package org.knit.solutions.Task11;

public class MobileApp implements StockObserver {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String companyName, double newPrice) {
        System.out.println("Приложение " + appName + " уведомляет: Цена акций " + companyName + " изменилась на " + newPrice);
    }
}
