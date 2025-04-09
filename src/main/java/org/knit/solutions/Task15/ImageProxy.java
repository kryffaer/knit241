package org.knit.solutions.Task15;

public class ImageProxy implements Image {
    private String fileName;
    private RealImage realImage;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Ленивая загрузка
        }
        realImage.display();
    }
}
