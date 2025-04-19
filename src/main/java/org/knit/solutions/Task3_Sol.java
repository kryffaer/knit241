package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task3.TransportFactory;

/*
Паттерн Factory используется для создания объектов без указания конкретного класса. Это полезно, когда необходимо создавать объекты на основе входных параметров и логики выбора.
Задача:
Реализуйте фабрику по созданию различных видов транспортных средств в системе каршеринга.
Создайте интерфейс Transport с методом getSpecifications(), который возвращает характеристики транспортного средства.
Создайте классы BusinessCar, FamilyVan и Motorbike, реализующие Transport.
BusinessCar должен иметь комфортный салон и кожаные сиденья.
FamilyVan должен поддерживать перевозку 6+ пассажиров.
Motorbike предназначен для быстрой доставки.
Создайте класс TransportFactory, который:
Принимает параметр типа поездки ("business", "family", "delivery").
Возвращает соответствующий объект (BusinessCar, FamilyVan, Motorbike).
Добавьте обработку исключений, если передан неизвестный тип транспорта.
Вызов TransportFactory.createTransport("business") должен возвращать объект BusinessCar.
 */

@TaskDescription(taskNumber = 3, taskDescription = "Factory (Фабрика)")
public class Task3_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 3 запущена");
        try {
            System.out.println("Характеристики бизнес-автомобиля: ");
            System.out.println(TransportFactory.createTransport("business").getSpecifications());

            System.out.println("\nХарактеристики семейного минивэна: ");
            System.out.println(TransportFactory.createTransport("family").getSpecifications());

            System.out.println("\nХарактеристики мотоцикла: ");
            System.out.println(TransportFactory.createTransport("delivery").getSpecifications());
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
