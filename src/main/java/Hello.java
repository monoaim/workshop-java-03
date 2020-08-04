import java.awt.HeadlessException;

public class Hello {

    public String sayHi() {
        return "Hello";
    }

    public String sayHi(String str) {
        return String.format("Hello %s", str.substring(0, 1).toUpperCase() + str.substring(1));
    }
}
