public class Averageconfusion {
    public static void main(String[] args) {
        int[] nums = {5, 12, 8, 20, 3};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 10) nums[i] *= 2;
        }
        int sum = 0;
        for (int n : nums) sum += n;
        double avg = (double) sum / nums.length;
        System.out.println("average is: "+ avg);
    }
}