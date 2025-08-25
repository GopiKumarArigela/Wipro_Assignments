interface Light {
    void turnOn();
}

class LEDLight implements Light {
    public void turnOn() {
        System.out.println("LED Light is ON");
    }
}

class Switch {
    Light light;

    Switch(Light light) {
        this.light = light;
    }

    void operate() {
        light.turnOn();
    }
}

public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Light led = new LEDLight();
        Switch s = new Switch(led);
        s.operate();
    }
}

