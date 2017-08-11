package com.ricardohsd.datastreaming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SampleList<T> implements Iterable<T> {
    private final int MAX_REPLACE_TIMES = 100;

    private int replaceTimes;
    private final int capacity;
    private final List<T> characterList;
    private final Random rand;

    public SampleList(int capacity, Random rand) {
        this.capacity = capacity;
        this.rand = rand;
        this.replaceTimes = 0;
        this.characterList = new ArrayList<T>();
    }

    /**
     * Appends the value to the characterList while it isn't completed.
     *
     * Once the internal characterList is completed it will start randomly replacing values.
     */
    public void add(T value) {
        if (characterList.size() < capacity) {
            characterList.add(value);
        } else {
            characterList.set(randIndex(), value);
            this.replaceTimes += 1;
        }
    }

    public int size() {
        return characterList.size();
    }

    /**
     * The print is completed once it filled the list and replaced values according to MAX_REPLACE_TIMES amount.
     *
     * @return boolean
     */
    public boolean completed() {
        return characterList.size() == capacity && replaceTimes >= MAX_REPLACE_TIMES;
    }

    public Iterator<T> iterator() {
        return this.characterList.iterator();
    }

    public int randIndex() {
        return rand.nextInt(capacity);
    }
}
