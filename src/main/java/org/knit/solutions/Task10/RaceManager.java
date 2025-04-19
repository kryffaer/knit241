package org.knit.solutions.Task10;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaceManager {
    private final int numRunners;

    public RaceManager(int numRunners) {
        this.numRunners = numRunners;
    }

    public void startRace() {
        CyclicBarrier barrier = new CyclicBarrier(numRunners, () -> {
            System.out.println("Все готовы, старт");
        });

        ExecutorService executor = Executors.newFixedThreadPool(numRunners);

        for (int i = 0; i < numRunners; i++) {
            String runnerName = "Бегун " + (i + 1);
            Runner runner = new Runner(runnerName, barrier);
            executor.submit(runner);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            // Ждём завершения всех задач
        }
        System.out.println("Гонка завершена!");
    }
}


