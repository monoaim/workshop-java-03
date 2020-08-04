import static org.junit.Assert.*;

import org.junit.Test;

public class HelloTest {
    @Test
    public void SayHiShouldReturnHello() {
        Hello h = new Hello();
        String result = h.sayHi();
        assertEquals("Hello", result);
    }

    @Test
    public void SayHiArayaShouldReturnHelloAraya() {
        Hello h = new Hello();
        String result = h.sayHi("arayaS");
        assertEquals("Hello ArayaS", result);
    }
}
