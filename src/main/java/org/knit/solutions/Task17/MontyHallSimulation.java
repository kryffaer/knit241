package org.knit.solutions.Task17;

import java.util.Random;

public class MontyHallSimulation {

    private int numberOfSimulations;
    private Random random;
    private int switchWins = 0;        // Счетчик выигрышей при смене выбора
    private int stayWins = 0;          // Счетчик выигрышей при сохранении выбора

    public MontyHallSimulation(int numberOfSimulations, Random random) {
        this.numberOfSimulations = numberOfSimulations;
        this.random = random;
    }

    public void runSimulation() {
        for (int i = 0; i < numberOfSimulations; i++) {
            MontyHallGame game = new MontyHallGame(random);

            // Проверяем, выиграет ли игрок, если сменит выбор
            if (game.playerWinsIfSwitches()) {
                switchWins++; // Увеличиваем счетчик выигрышей при смене выбора
            }

            // Проверяем, выиграет ли игрок, если останется при своем выборе
            if (game.playerWinsIfStays()) {
                stayWins++; // Увеличиваем счетчик выигрышей при сохранении выбора
            }
        }
    }

    public void printResults() {
        // Вычисляем вероятность выигрыша при смене выбора
        double switchWinProbability = (double) switchWins / numberOfSimulations * 100;
        // Вычисляем вероятность выигрыша при сохранении выбора
        double stayWinProbability = (double) stayWins / numberOfSimulations * 100;

        System.out.println("Вероятность выигрыша при смене выбора: " + switchWinProbability + "%");
        System.out.println("Вероятность выигрыша без смены выбора: " + stayWinProbability + "%");
    }
}

