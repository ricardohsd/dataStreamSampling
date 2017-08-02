package com.ricardohsd.datastreaming;

import com.ricardohsd.datastreaming.SampleListPrinter;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SampleListPrinterTest {
    @Test
    public void generateStringWithSampleCharacters() {
        ArrayList<Character> list = new ArrayList<Character>();
        list.add('A');
        list.add('B');
        list.add('C');

        SampleListPrinter printer = new SampleListPrinter(list);

        assertEquals("ABC", printer.print());
    }
}
