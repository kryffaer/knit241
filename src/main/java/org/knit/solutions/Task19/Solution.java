package org.knit.solutions.Task19;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // Указатель для nums1
        int p2 = n - 1; // Указатель для nums2
        int tail = m + n - 1; // Указатель для конца nums1

        while ((p1 >= 0) && (p2 >= 0)) {
            // Сравниваем элементы и записываем больший в конец nums1
            if (nums1[p1] > nums2[p2]) {
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p2--];
            }
        }
        // Если остались элементы в nums2, копируем их в начало nums1
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
