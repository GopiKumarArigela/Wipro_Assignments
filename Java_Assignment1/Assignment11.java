import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Assignment11 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alina", "Amanda", "Anna", "Bob", "Anita");
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> endsWitha = s -> s.endsWith("a");
        List<String> result = names.stream().filter(startsWithA.and(endsWitha)).collect(Collectors.toList());
        System.out.println(result);
    }
}