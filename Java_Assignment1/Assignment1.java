import java.util.*;

public class Assignment1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alex", "Chris", "Bob", "David");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(names);
    }
}