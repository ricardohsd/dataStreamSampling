package com.ricardohsd.datastreaming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.Random;

public class SamplerProcessor {
    public final BufferedReader dataStream;
    public final SampleList<Character> sampleList;
    public final SampleListPrinter samplePrinter;
    public final Random rand = new SecureRandom();

    public SamplerProcessor(Integer sampleSize, InputStream input) {
        this.dataStream = new BufferedReader(new InputStreamReader(input));
        this.sampleList = new SampleList<Character>(sampleSize, this.rand);
        this.samplePrinter = new SampleListPrinter(sampleList);
    }

    public String process() throws Exception {
        try {
            int streamCharInt;

            // Consumes next character from dataStream until sampleList is completed.
            while (!sampleList.completed() && (streamCharInt = dataStream.read()) != -1) {
                // Skip empty characters
                if (streamCharInt == 10) {
                    break;
                }

                sampleList.add((char) streamCharInt);
            }

            dataStream.close();

            return samplePrinter.print();
        } catch (IOException e) {
            throw new Exception("The following issue happened while parsing stream: " + e);
        }
    }
}
