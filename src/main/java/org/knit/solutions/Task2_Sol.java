package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task2.*;

/*
Декоратор позволяет динамически добавлять новую функциональность объектам без изменения их кода. Это достигается путем обертывания объектов в дополнительные классы.
Основной кофе
Декораторы: сахар, молоко, карамель и т. д.
Задача:
Реализуйте систему онлайн-заказов кофе.
У вас есть базовый класс Coffee, который имеет метод getCost() и getDescription().
Напишите декораторы для добавления различных ингредиентов (молоко, карамель, шоколад).
Каждый декоратор изменяет стоимость и описание кофе.
Расширьте решение, добавив калорийность и разные виды напитков
 */

@TaskDescription(taskNumber = 2, taskDescription = "Decorator (Декоратор)")
public class Task2_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 2 запущена");
        Coffee coffee = new Espresso();
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new SizeDecorator(coffee, "medium");
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Caramel(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");

        coffee = new Chocolate(coffee);
        System.out.println(coffee.getDescription() + " | Цена: $" + coffee.getCost() + " | Калорийность: " + coffee.getCalories() + " ккал");
    }
}