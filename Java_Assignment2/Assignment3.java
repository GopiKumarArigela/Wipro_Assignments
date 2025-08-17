import java.util.*;

public class Assignment3 {
    public static void main(String[] args) {
        ArrayDeque<String> searches = new ArrayDeque<>();
        List<String> terms = Arrays.asList("Java", "Python", "C++", "Go", "Rust");
        for (String term : terms) {
            if (searches.size() == 3) searches.removeFirst();
            searches.addLast(term);
        }
        System.out.println(searches);
    }
}