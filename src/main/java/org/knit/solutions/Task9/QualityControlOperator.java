package org.knit.solutions.Task9;

import java.util.concurrent.BlockingQueue;

public class QualityControlOperator extends Thread {
    private final BlockingQueue<Detail> queueFromAssembler;

    public QualityControlOperator(BlockingQueue<Detail> queueFromAssembler) {
        this.queueFromAssembler = queueFromAssembler;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Detail detail = queueFromAssembler.take(); // Получить деталь от сборщика
                System.out.println("Оператор контроля: Деталь " + detail.getId() + " проверена и отправлена на склад");
                Thread.sleep(2000); // Проверка качества
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

