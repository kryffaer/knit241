package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task14.*;

/*
Создайте систему управления файловыми объектами.
Есть три типа файловых объектов: Файлы, Папки, Ссылки (ярлыки).
Требуется реализовать два посетителя:
Сканер вирусов, который проверяет каждый файл на наличие вирусов.
Анализатор размера, который подсчитывает общий размер файлов (ссылки не учитываются).
 */

@TaskDescription(taskNumber = 14, taskDescription = "Паттерн Визитер (Visitor)")
public class Task14_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 14 запущена");
        // Создание файлов и папок
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        Folder folder = new Folder("MyFolder", file1, file2);
        Link link = new Link("link", "target");

        // Создание посетителей
        VirusScanner virusScanner = new VirusScanner();
        SizeAnalyzer sizeAnalyzer = new SizeAnalyzer();

        // Применение посетителей
        System.out.println("Сканер вирусов:");
        folder.accept(virusScanner);
        link.accept(virusScanner);

        System.out.println("\nАнализатор размера:");
        folder.accept(sizeAnalyzer);
        System.out.println("Общий размер файлов: " + sizeAnalyzer.getTotalSize() + " байт");
    }
}