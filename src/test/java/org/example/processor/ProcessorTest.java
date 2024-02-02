package org.example.processor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProcessorTest {

    private final int sourceValue = 123;
    private final byte[] transformedValue = "123".getBytes();

    private final int sourceZeroValue = 0;
    private final byte[] transformedZeroValue = "".getBytes();

    @Before
    public void beforeStartTestTime() {
        System.out.println(
                "Test has been started at : " +
                        System.currentTimeMillis());
    }

    @After
    public void afterStartTestTime() {
        System.out.println(
                "Test has been finished at : " +
                        System.currentTimeMillis());
    }

    public void testSimpleTransfort() {
        //  Given

        Processor processor = new Processor();

        //  When

        byte[] result = processor.transform(
                (sourceValue));

        //  Then
        assertArrayEquals(transformedValue, result);
    }

    @Test
    public void testSimpleTransfortWithZero() {
        //  Given

        Processor processor = new Processor();

        //  When

        byte[] result = processor.transform(
                sourceZeroValue);

        //  Then
        assertArrayEquals(transformedZeroValue, result);
    }

    @Test
    public void testSimpleTransfortUtf8FromFile() {
        this.testSimpleTransfort();

        //  Given

        Processor processor = new Processor();

        //  When

        byte[] result = processor.transform(sourceValue);

        //  Then

        assertArrayEquals(transformedValue, result);
    }
}
