package org.knit.solutions;

import org.knit.TaskDescription;
import org.knit.solutions.Task9.Assembler;
import org.knit.solutions.Task9.Detail;
import org.knit.solutions.Task9.QualityControlOperator;
import org.knit.solutions.Task9.StampingWorker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
На заводе работают три типа рабочих, каждый из которых выполняет свою часть работы в конвейерном режиме:
Штамповщик – вырезает заготовку (создает объект детали).
Сборщик – собирает из заготовки готовую деталь.
Оператор контроля качества – проверяет деталь и отправляет на склад.
Каждый рабочий – отдельный поток, и они должны работать последовательно, используя общую очередь для передачи деталей.
Требования к решению:
Использовать потоки (Thread или ExecutorService).
Использовать синхронизацию (wait(), notify(), BlockingQueue).
Реализовать конвейерную передачу данных между потоками.
 */

@TaskDescription(taskNumber = 9, taskDescription = "Конвейер сборки деталей")
public class Task9_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 9 запущена");
        BlockingQueue<Detail> queueToAssembler = new LinkedBlockingQueue<>();
        BlockingQueue<Detail> queueToQualityControl = new LinkedBlockingQueue<>();

        StampingWorker stampingWorker = new StampingWorker(queueToAssembler);
        Assembler assembler = new Assembler(queueToAssembler, queueToQualityControl);
        QualityControlOperator qualityControlOperator = new QualityControlOperator(queueToQualityControl);

        stampingWorker.start();
        assembler.start();
        qualityControlOperator.start();
    }
}