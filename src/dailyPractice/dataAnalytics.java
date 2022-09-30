package dailyPractice;

public class dataAnalytics {
    public static void main(String[] args) {
        int[][] nums = {{9, 8}, {6, 8}, {6, 4}, {10, 6}, {3, 1}};
        dataAnalytics test = new dataAnalytics();
        for (int i = 0; i < nums.length; i++) {
            int t = i;
            while (t < nums.length) {
                System.out.println((i+1) +":"+nums[i][0]+ " "+ nums[i][1]+ "  "+ (t+1)+": "+ nums[t][0]+ " "+  nums[t][1]);
                System.out.println(test.distanceCal(nums[i][0], nums[i][1], nums[t][0], nums[t][1]));
                t++;
            }
        }
    }
    public double distanceCal(int x1, int y1, int x2, int y2) {
        double x = x1 - x2;
        double y = y1 - y2;
        return Math.sqrt(x * x + y * y);
    }
}
