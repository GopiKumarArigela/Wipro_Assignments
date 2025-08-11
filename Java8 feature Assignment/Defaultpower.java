interface Power {
    void abstractMethod();
    default void defaultMethod() {
        System.out.println("Default method called");
    }
}

public class Defaultpower {
    public static void main(String[] args) {
        Power obj = () -> System.out.println("Abstract method called");
        obj.abstractMethod();
        obj.defaultMethod();
    }
}