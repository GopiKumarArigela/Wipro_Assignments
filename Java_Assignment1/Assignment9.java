import java.util.*;

public class Assignment9 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        nums.parallelStream().forEach(n -> System.out.println(n * n));
    }
}