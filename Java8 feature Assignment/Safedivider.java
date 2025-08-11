import java.util.*;

public class Safedivider {
    public static void main(String[] args) {
        int num1 = 10, num2 = 0;
        Optional<Integer> result = num2 == 0 ? Optional.empty() : Optional.of(num1 / num2);
        System.out.println(result.isPresent() ? result.get() : "Not Allowed");
    }
}