package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task15.ImageProxy;

/*
Создайте удаленную библиотеку изображений.
При запросе изображения оно загружается с сервера (имитация через задержку в коде).
Картинка хранится как объект класса RealImage.
Прокси-объект ImageProxy должен лениво загружать изображение и кэшировать его для повторного использования.
 */

@TaskDescription(taskNumber = 15, taskDescription = "Паттерн Прокси (Proxy)")
public class Task15_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 15 запущена");
        ImageProxy image1 = new ImageProxy("image1.jpg");
        ImageProxy image2 = new ImageProxy("image2.jpg");

        image1.display();
        image2.display();
        image1.display(); // Повторное отображение не загружает изображение снова
    }
}