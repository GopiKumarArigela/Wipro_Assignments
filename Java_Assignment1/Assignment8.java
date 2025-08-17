import java.util.*;
import java.util.stream.*;

public class Assignment8 {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Kolkata", "Chennai");
        String joined = cities.stream().collect(Collectors.joining(", "));
        System.out.println(joined);
    }
}