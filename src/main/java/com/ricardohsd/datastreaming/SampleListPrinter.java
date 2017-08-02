package com.ricardohsd.datastreaming;

public class SampleListPrinter {
    public final Iterable sampleList;

    public SampleListPrinter(Iterable sampleList) {
        this.sampleList = sampleList;
    }

    public String print() {
        StringBuilder str = new StringBuilder();

        for (Object value : sampleList) {
            str.append(value);
        }

        return str.toString();
    }
}
