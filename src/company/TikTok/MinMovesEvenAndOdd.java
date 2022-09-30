package company.TikTok;

/*
The purpose is to calculate the minimum
steps of make [8, 5, 11, 4, 6]
to [8, 6, 4, 11, 5]
 */
public class MinMovesEvenAndOdd {
    public static void main(String[] args) {
        int[] arr = new int[] {8, 5, 11, 4, 6};
        int[] arr2 = new int[] {1, 3, 5, 6, 8, 10};
        MinMovesEvenAndOdd test = new MinMovesEvenAndOdd();
        System.out.println(test.minMovesEvenAndOdd(arr));
        System.out.println(test.minMovesEvenAndOdd(arr2));
    }

    public int minMovesEvenAndOdd(int[] arr) {
        int step = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] % 2 != 0) {
                while ( left < right && arr[right] % 2 != 0) {
                    //find the first even to swap
                    right--;
                }
                if ( left < right) {
                    step++;
                    right--;
                }
            }
            left++;
        }
        return step;
    }

}
