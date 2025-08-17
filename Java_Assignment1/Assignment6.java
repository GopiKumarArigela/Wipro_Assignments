import java.util.*;

public class Assignment6 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Cathy");
        long count = names.stream().filter(n -> n.length() > 5).count();
        System.out.println(count);
    }
}