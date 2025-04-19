package org.knit.solutions.Task17;

import java.util.Random;

public class MontyHallGame {

    private int winningDoor;  // Случайный номер двери, за которой находится приз
    private int playerChoice; // Случайный номер двери, которую выбрал игрок
    private int revealedDoor; // Номер двери, которую открывает ведущий
    private Random random;

    public MontyHallGame(Random random) {
        this.random = random;
        this.winningDoor = random.nextInt(3);
        this.playerChoice = random.nextInt(3);
        this.revealedDoor = findDoorToReveal();
    }

    // Какую дверь открыть ведущему?
    private int findDoorToReveal() {
        int door;
        // Ведущий не может открыть дверь, которую выбрал игрок, или дверь, за которой находится приз
        do {
            door = random.nextInt(3);
        } while (door == playerChoice || door == winningDoor); // Повторяем, если дверь не подходит
        return door;
    }

    // Игрок выиграет, если сменит свой выбор
    public boolean playerWinsIfSwitches() {
        int switchChoice = getSwitchChoice();
        return switchChoice == winningDoor;
    }

    // Игрок выиграет, если останется при своем выборе
    public boolean playerWinsIfStays() {
        return playerChoice == winningDoor;
    }

    // На какую дверь переключится игрок?
    private int getSwitchChoice() {
        int switchChoice;

        if (playerChoice == 0) {
            switchChoice = (revealedDoor == 1) ? 2 : 1;
        } else if (playerChoice == 1) {
            switchChoice = (revealedDoor == 0) ? 2 : 0;
        } else {
            switchChoice = (revealedDoor == 0) ? 1 : 0;
        }
        return switchChoice;
    }
}

