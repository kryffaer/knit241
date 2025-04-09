package org.knit.solutions.Task15;

public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer(fileName); // Имитация загрузки с сервера
    }

    private void loadFromServer(String fileName) {
        try {
            System.out.println("Загрузка изображения " + fileName + " с сервера...");
            Thread.sleep(2000); // Имитация задержки загрузки
            System.out.println("Изображение " + fileName + " загружено.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void display() {
        System.out.println("Отображение изображения " + fileName);
    }
}
