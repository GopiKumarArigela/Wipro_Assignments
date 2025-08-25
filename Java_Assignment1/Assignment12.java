import java.util.*;

public class Assignment12 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Banana", "Apple", "Mango", "Cherry");
        fruits.sort(String::compareTo);
        System.out.println(fruits);
    }
}