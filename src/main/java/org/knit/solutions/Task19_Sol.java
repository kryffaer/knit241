package org.knit.solutions;

import org.knit.TaskDescription;

/*
Даны два целочисленных массива nums1 и nums2, отсортированных в неубывающем порядке, а также два целых числа m и n, представляющих количество элементов в nums1 и nums2 соответственно.
Требуется:
Объединить nums1 и nums2 в один массив, отсортированный в неубывающем порядке.
Важные условия:
Итоговый отсортированный массив должен быть сохранён внутри массива nums1 (функция не должна ничего возвращать).
Массив nums1 имеет длину m + n, где:
Первые m элементов — значимые (их нужно объединять с nums2).
Последние n элементов заполнены нулями и должны быть проигнорированы.
Длина nums2 равна n.

Пример 1:
Входные данные:
nums1 = [1, 2, 3, 0, 0, 0], m = 3
nums2 = [2, 5, 6], n = 3
Результат:
[1, 2, 2, 3, 5, 6]
Объяснение:
Объединяемые массивы: [1, 2, 3] и [2, 5, 6].
Результат — [1, 2, 2, 3, 5, 6] (подчёркнутые элементы взяты из nums1).

Пример 2:
Входные данные:
nums1 = [1], m = 1
nums2 = [], n = 0
Результат:
[1]
Объяснение:
Объединяемые массивы: [1] и [].
Результат — [1].

Пример 3:
Входные данные:
nums1 = [0], m = 0
nums2 = [1], n = 1
Результат:
[1]
Объяснение:
Объединяемые массивы: [] и [1].
Поскольку m = 0, в nums1 нет значимых элементов (нули служат только для резерва места).

Ограничения:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[j] <= 10^9

Напишите решение, а затем Напишите JUnit тесты для проверки решения
Тесты должны покрывать
--Обычные случаи (слияние с данными и без).
--Краевые случаи (пустые массивы, все элементы в одном массиве).
--Отрицательные числа и дубликаты.
--Производительность (большие массивы).
 */

@TaskDescription(taskNumber = 19, taskDescription = "Два целочисленных массива nums1 и nums2, отсортированных в неубывающем порядке")
public class Task19_Sol implements Solution{

    public void execute() {
        System.out.println("Задача 19 запущена");
        org.knit.solutions.Task19.Solution solution = new org.knit.solutions.Task19.Solution();

        // Пример 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Обычное слияние:");
        System.out.println("Исходные массивы: nums1 = " + java.util.Arrays.toString(nums1) + ", nums2 = " + java.util.Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        System.out.println("Массив после слияния: " + java.util.Arrays.toString(nums1));

        // Пример 2
        nums1 = new int[] {1};
        m = 1;
        nums2 = new int[] {};
        n = 0;

        System.out.println("\nПустой второй массив:");
        System.out.println("Исходные массивы: nums1 = " + java.util.Arrays.toString(nums1) + ", nums2 = " + java.util.Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        System.out.println("Массив после слияния: " + java.util.Arrays.toString(nums1));

        // Пример 3
        nums1 = new int[] {0};
        m = 0;
        nums2 = new int[] {1};
        n = 1;

        System.out.println("\nПустой первый массив:");
        System.out.println("Исходные массивы: nums1 = " + java.util.Arrays.toString(nums1) + ", nums2 = " + java.util.Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        System.out.println("Массив после слияния: " + java.util.Arrays.toString(nums1));

        // Пример 4
        nums1 = new int[] {-1, 0, 0};
        m = 1;
        nums2 = new int[] {-2, 3};
        n = 2;

        System.out.println("\nОтрицательные числа:");
        System.out.println("Исходные массивы: nums1 = " + java.util.Arrays.toString(nums1) + ", nums2 = " + java.util.Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        System.out.println("Массив после слияния: " + java.util.Arrays.toString(nums1));

        // Пример 5
        nums1 = new int[] {1, 2, 0, 0};
        m = 2;
        nums2 = new int[] {2, 3};
        n = 2;

        System.out.println("\nДубликаты:");
        System.out.println("Исходные массивы: nums1 = " + java.util.Arrays.toString(nums1) + ", nums2 = " + java.util.Arrays.toString(nums2));
        solution.merge(nums1, m, nums2, n);
        System.out.println("Массив после слияния: " + java.util.Arrays.toString(nums1));

        // Пример 6
        nums1 = new int[200];
        for (int i = 0; i < 100; i++) {
            nums1[i] = i;
        }
        m = 100;
        nums2 = new int[100];
        for (int i = 0; i < 100; i++) {
            nums2[i] = i + 100;
        }
        n = 100;

        System.out.println("\nБольшие массивы:");
        System.out.println("Исходные массивы: nums1 = " + java.util.Arrays.toString(nums1) + ", nums2 = " + java.util.Arrays.toString(nums2));
        long startTime = System.currentTimeMillis();
        solution.merge(nums1, m, nums2, n);
        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения: " + (endTime - startTime) + " ms");
        System.out.println("Массив после слияния: " + java.util.Arrays.toString(nums1));
    }
}