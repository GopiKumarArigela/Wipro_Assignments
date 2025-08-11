import java.util.*;

public class Simplenamesorter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alex", "Chris", "Bob", "David");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(names);
    }
}