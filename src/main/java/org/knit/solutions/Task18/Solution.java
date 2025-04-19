package org.knit.solutions.Task18;

public class Solution {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length = arr.length - 1;

        // Подсчёт нулей, которые можно дублировать
        for (int i = 0; i <= length - possibleDups; i++) {
            if (arr[i] == 0) {
                // Обработка нуля на границе массива
                if (i == length - possibleDups) {
                    arr[length] = 0;
                    length--;
                    break;
                }
                possibleDups++;
            }
        }

        // Копирование элементов с конца
        int last = length - possibleDups;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}

