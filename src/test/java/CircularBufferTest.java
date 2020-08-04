import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircularBufferTest {

    CircularBuffer cb;

    @Before
    public void setUp() {
        this.cb = new CircularBuffer();
    }

    @Test
    public void createNewBufferShouldEmpty() {
        boolean result = cb.isEmpty();
        assertTrue("Buffer not available", result);
    }

    @Test
    public void createNewBufferWithDefaultSizeShould10() {
        for (int i = 0; i < 10; i++) {
            cb.writeData(String.format("A%d", i));
        }
        boolean result = cb.isFull();
        assertTrue("Buffer not full", result);
    }

    @Test
    public void writeABtoBufferShouldReadAB() {
        cb.writeData("A");
        cb.writeData("B");
        assertEquals("A", cb.readData());
        assertEquals("B", cb.readData());
    }

    @Test
    public void writeDataAndReadDataThenBufferShouldEmpty() {
        cb.writeData("B");
        assertEquals("B", cb.readData());
        boolean result = cb.isEmpty();
        assertTrue("Buffer not available", result);
    }

    @Test
    public void writeDataOnFullBufferShouldOverwriteOldestData() {
        for (int i = 0; i < 10; i++) {
            cb.writeData(String.format("A%d", i));
        }
        cb.writeData("B");
        String result = cb.readData();
        assertEquals("B", result);
    }

    @Test
    public void createNewBufferWithSize30Should30() throws IllegalArgumentException {
        cb = new CircularBuffer(30);
        for (int i = 0; i < 30; i++) {
            cb.writeData(String.format("A%d", i));
        }
        int result = cb.getSize();
        assertEquals(30, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNewBufferWithNegativeSizeShouldThrowIllegalArgumentException() {
        cb = new CircularBuffer(-1);
    }

    @Test
    public void emptyBufferShouldReturnNull() {
        String result = cb.readData();
        assertNull(result);
    }
}
