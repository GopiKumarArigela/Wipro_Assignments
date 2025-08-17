import java.util.*;
import java.util.stream.*;

public class Assignment5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Cathy");
        List<String> filtered = names.stream().filter(n -> n.startsWith("A")).collect(Collectors.toList());
        System.out.println(filtered);
    }
}