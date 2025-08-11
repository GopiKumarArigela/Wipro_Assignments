import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Frequencymapper {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "David", "Bob", "Alice");
        Map<String, Long> freq = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);
    }
}