package org.knit.solutions.Task9;

import java.util.concurrent.BlockingQueue;

public class Assembler extends Thread {
    private final BlockingQueue<Detail> queueFromStamper;
    private final BlockingQueue<Detail> queueToQualityControl;

    public Assembler(BlockingQueue<Detail> queueFromStamper, BlockingQueue<Detail> queueToQualityControl) {
        this.queueFromStamper = queueFromStamper;
        this.queueToQualityControl = queueToQualityControl;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Detail detail = queueFromStamper.take(); // Получить заготовку от штамповщика
                System.out.println("Сборщик: Заготовка " + detail.getId() + " обработана");
                queueToQualityControl.put(detail); // Передаём деталь оператору контроля
                Thread.sleep(1500); // Работа сборщика
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

