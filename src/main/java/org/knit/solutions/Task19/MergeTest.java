package org.knit.solutions.Task19;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MergeTest {
    private Solution solution = new Solution();

    @Test
    public void testNormalMerge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int[] expected = {1, 2, 2, 3, 5, 6};

        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testEmptySecondArray() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] expected = {1};

        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testEmptyFirstArray() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        int[] expected = {1};

        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums1 = {-1, 0, 0};
        int m = 1;
        int[] nums2 = {-2, 3};
        int n = 2;
        int[] expected = {-2, -1, 3};

        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testDuplicates() {
        int[] nums1 = {1, 2, 0, 0};
        int m = 2;
        int[] nums2 = {2, 3};
        int n = 2;
        int[] expected = {1, 2, 2, 3};

        solution.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    @Test
    public void testLargeArrays() {
        int[] nums1 = new int[200];
        for (int i = 0; i < 100; i++) {
            nums1[i] = i;
        }
        int m = 100;
        int[] nums2 = new int[100];
        for (int i = 0; i < 100; i++) {
            nums2[i] = i + 100;
        }
        int n = 100;

        long startTime = System.currentTimeMillis();
        solution.merge(nums1, m, nums2, n);
        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения: " + (endTime - startTime) + " ms");

        // Проверка результата
        for (int i = 0; i < 200; i++) {
            assert nums1[i] == i;
        }
    }
}

