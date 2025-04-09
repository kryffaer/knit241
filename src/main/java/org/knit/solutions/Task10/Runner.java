package org.knit.solutions.Task10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private final String name;
    private final CyclicBarrier barrier;

    public Runner(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " готовится к старту");
            barrier.await();
            System.out.println(name + " стартовал");

            int randomTime = ThreadLocalRandom.current().nextInt(500, 3000);
            Thread.sleep(randomTime);

            System.out.println(name + " финишировал за " + randomTime + " мс");
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
            System.err.println("Ошибка во время гонки: " + e.getMessage());
        }
    }
}
