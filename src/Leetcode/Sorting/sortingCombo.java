package Leetcode.Sorting;

public class sortingCombo {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        insertionSort(arr);
        //selectionSort(arr);
        System.out.println(isValid(arr));

    }

    public static boolean isValid(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[i++]) {
                return false;
            }
        }
        return true;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    SelectionSort
     */
    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    public static void bubbleSort(int[] nums) {

    }

    public static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
                else break;
            }
        }
    }

    public static void shellSort(int[] nums) {

    }

    public static void mergeSort(int[] nums) {

    }
}
