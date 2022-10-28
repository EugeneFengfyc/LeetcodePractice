package Leetcode.Sorting;

import java.util.Arrays;

public class Merge {

    // 用于辅助合并有序数组
    private static int[] temp;

    public static void sort(int[] nums) {
        temp = new int[nums.length];
        // 排序整个数组（原地修改）
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low == high) return;  // 单个元素不用排序
        int mid = low + (high - low) / 2; //防止溢出
        mergeSort(nums, low, mid); //排序左半边
        mergeSort(nums, mid + 1, high); // 排序右半边
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int i = low, j = mid + 1;
        for (int p = low; p <= high; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            }
            else if (j == high + 1) {
                nums[p] = temp[i++];
            }
            else if (temp[i] > temp[j]) {
                nums[p] = temp[j++];
            }
            else {
                nums[p] = temp[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] entry = new int[]{5, 4, 3, 2, 1};
        sort(entry);
        System.out.println(Arrays.toString(entry));
    }
}
