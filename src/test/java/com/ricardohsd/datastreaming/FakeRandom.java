package com.ricardohsd.datastreaming;

/**
 * Class used for injecting Random dependency during tests.
 *
 * It starts with an internal count set as 0 and it increments every time next() is called.
 */
class FakeRandom extends java.util.Random {
    private int count;

    public FakeRandom() {
        this.count = 0;
    }

    final protected int next(int _) {
        int currentCount = this.count;

        this.count += 1;

        return currentCount;
    }
}
