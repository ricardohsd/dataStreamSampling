package com.ricardohsd.datastreaming;

import org.junit.Test;
import java.util.Random;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class SampleListTest {
    @Test
    public void listSizeShouldNotOvercomeCapacity() {
        Random fakeRandom = new FakeRandom();

        int capacity = 2;
        SampleList<Character> list = new SampleList<Character>(capacity, fakeRandom);

        list.add('a');

        assertEquals(1, list.size());

        list.add('b');

        assertEquals(2, list.size());

        list.add('c');

        assertEquals(2, list.size());
    }

    @Test
    public void sampleShouldBeCompletedWhenReachingCapacityAndMaxReplacing() {
        Random fakeRandom = new FakeRandom();

        int capacity = 2;
        SampleList<Character> list = new SampleList<Character>(capacity, fakeRandom);

        list.add('a');

        assertFalse(list.completed());

        for (int i = 0; i < 101; i++) {
          list.add('b');
        }

        assertTrue(list.completed());
    }

    @Test
    public void listShouldBeIterable() {
        Random fakeRandom = new FakeRandom();

        int capacity = 3;
        SampleList<Character> list = new SampleList<Character>(capacity, fakeRandom);

        list.add('a');
        list.add('b');
        list.add('c');

        assertThat(list, hasItem('a'));
        assertThat(list, hasItem('b'));
        assertThat(list, hasItem('c'));
    }

    @Test
    public void itemsShouldBeReplaced() {
        Random fakeRandom = new FakeRandom();

        int capacity = 3;

        SampleList<Character> list = new SampleList<Character>(capacity, fakeRandom);

        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');

        assertThat(list, hasItem('c'));
        assertThat(list, hasItem('d'));
        assertThat(list, hasItem('e'));
        assertThat(list, not(hasItem('a')));
        assertThat(list, not(hasItem('b')));
    }
}
