package org.knit.solutions.Task11;

public class EmailNotifier implements StockObserver {
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String companyName, double newPrice) {
        System.out.println("Отправлено уведомление на " + email + ": Цена акций " + companyName + " изменилась на " + newPrice);
    }
}
