package org.knit.solutions.Task9;

import java.util.concurrent.BlockingQueue;

public class StampingWorker extends Thread {
    private final BlockingQueue<Detail> queueToAssembler;
    private int detailId = 1;

    public StampingWorker(BlockingQueue<Detail> queueToAssembler) {
        this.queueToAssembler = queueToAssembler;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Detail detail = new Detail(detailId++);
                System.out.println("Штамповщик: Заготовка " + detail.getId() + " создана");
                queueToAssembler.put(detail); // Передаём заготовку сборщику
                Thread.sleep(1000); // Работа штамповщика
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

