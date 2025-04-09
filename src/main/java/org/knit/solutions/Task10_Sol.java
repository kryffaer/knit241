package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task10.RaceManager;

import java.util.Scanner;

/*
Группа спортсменов участвует в забеге. Однако перед началом гонки все должны собраться на старте.
Как только все участники будут готовы, забег начнётся одновременно.
Используйте CyclicBarrier, чтобы синхронизировать запуск гонки.
Каждый бегун стартует одновременно, затем бежит разное время (симулируется Thread.sleep), после чего финиширует.
Как только все бегуны завершат дистанцию, программа выводит сообщение о завершении гонки.
Требования к задаче:
1) Создать CyclicBarrier для синхронизации начала забега.
2) Реализовать класс Runner, который:
   - Ожидает старта (barrier.await()).
   - Симулирует бег (Thread.sleep(randomTime)).
   - Выводит сообщение о финише.
3) После финиша всех участников программа должна сообщить, что гонка завершена.
4) Количество бегунов задаётся константой (или параметром).
 */

@TaskDescription(taskNumber = 10, taskDescription = "Гонка бегунов с использованием CyclicBarrier")
public class Task10_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 10 запущена");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество бегунов:");
        int numRunners = scanner.nextInt();
        if (numRunners <= 0) {
            System.out.println("Количество бегунов должно быть больше нуля.");
            return;
        }

        RaceManager manager = new RaceManager(numRunners);
        manager.startRace();
    }
}
