package org.example.processor;

public class Processor {

    public byte[] transform(final int sourceValue) {
        if (sourceValue == 0)
            return "".getBytes();

        return String.valueOf(sourceValue).getBytes();
    }
}
