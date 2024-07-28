package Buffer;

import java.nio.ByteBuffer;

public class Buffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(7);
        System.out.println("Before filling");
        printBufferState(buffer);
        String str = "Hello";
        byte[] data = str.getBytes();
        buffer.put(data);
        System.out.println("After filling the Buffer");
        printBufferState(buffer);

        buffer.flip();
        System.out.println("After flipping the Buffer");
        printBufferState(buffer);

        int limit = buffer.limit();
        byte[] output = new byte[limit];
        buffer.get(output);

        System.out.println(new String(output));
        System.out.println("After getting the data from the Buffer: ");
        printBufferState(buffer);

        // After flipping the Buffer
        buffer.flip();
        System.out.println("After flipping the Buffer");
        printBufferState(buffer);

        // Mark the current position
        buffer.mark();
        System.out.println("Marked the current position.");

        // Read next two bytes as an example
        byte[] twoBytes = new byte[2];
        buffer.get(twoBytes);
        System.out.println("Read two bytes after marking: " + new String(twoBytes));

        // Reset to the marked position
        buffer.reset();
        System.out.println("After resetting to the marked position");

        // Optionally, read again from the reset position to demonstrate
        byte[] resetBytes = new byte[2];
        buffer.get(resetBytes);
        System.out.println("Read two bytes after resetting: " + new String(resetBytes));

        System.out.println("After getting the data from the Buffer: ");
        printBufferState(buffer);

    }

    private static void printBufferState(ByteBuffer buffer) {
        System.out.println("Position: " + buffer.position() + ", Limit: " + buffer.limit() + ", Capacity: " + buffer.capacity());

    }
}
