package Leetcode.OOD;

import java.util.Set;

public class SparseVector {
    public int[] array;
    public Set<Integer> set;


    SparseVector(int[] nums) {
        this.array = nums;
    }

    // Return the dotProduct of two sparse vectors
//    public int dotProduct(SparseVector vec) {
//        int res = 0;
//        for (int i = 0; i < array.length; i++) {
//            res += array[i] * vec.array[i];
//        }
//        return res;
//    }

    public int dotProduct(SparseVector vec2) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res += array[i] * vec2.array[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,0,0,2,3};
        int[] nums2 = new int[]{0,3,0};


        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);


        int res1 = v1.dotProduct(v2);


    }
}
