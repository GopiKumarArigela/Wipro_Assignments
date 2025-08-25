interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class PrintMachine implements Printer {
    public void print() {
        System.out.println("Printing document");
    }
}

class ScanMachine implements Scanner {
    public void scan() {
        System.out.println("Scanning document");
    }
}

public class InterfaceSegrigationPrinciple {
    public static void main(String[] args) {
        Printer p = new PrintMachine();
        Scanner s = new ScanMachine();

        p.print();
        s.scan();
    }
}

