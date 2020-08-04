import java.util.Arrays;

public class CircularBuffer {

    private static final int DEFAULT_BUFFER_SIZE = 10;
    private int readPointer, writePointer = 0;
    private final String[] buffer;

    public CircularBuffer() {
        this(DEFAULT_BUFFER_SIZE);
    }

    public CircularBuffer(int bufferSize) throws IllegalArgumentException {
        if (bufferSize < 1) {
            throw new IllegalArgumentException("Buffer size is less than 1");
        }
        this.buffer = new String[bufferSize];
    }

    public int getSize() {
        return this.writePointer - this.readPointer;
    }

    public boolean isEmpty() {
        return this.writePointer == this.readPointer;
    }

    public boolean isFull() {
        return this.writePointer >= this.buffer.length;
    }

    public void writeData(String data) {
        this.buffer[this.writePointer++ % this.buffer.length] = data;
    }

    public String readData() {
        if (!this.isEmpty()) {
            String nextData = this.buffer[this.readPointer % this.buffer.length];
            this.readPointer++;
            return nextData;
        }
        return null;
    }
}
