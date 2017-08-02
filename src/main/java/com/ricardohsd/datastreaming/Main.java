package com.ricardohsd.datastreaming;

public class Main {
    public static void main(String[] args) {
        Integer sampleSize = Integer.parseInt(args[0]);

        SamplerProcessor processor = new SamplerProcessor(sampleSize, System.in);

        try {
            System.out.println("Random Sample: " + processor.process());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
