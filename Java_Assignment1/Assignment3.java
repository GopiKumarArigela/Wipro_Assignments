interface MessagePrinter {
    void print(String message);
}

public class Assignment3 {
    public static void main(String[] args) {
        printMessage(msg -> System.out.println(msg), "Hello Functional Interface");
    }

    public static void printMessage(MessagePrinter printer, String msg) {
        printer.print(msg);
    }
}