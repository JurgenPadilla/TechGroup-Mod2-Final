package datastructures.hashset;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MyHashSetTest {
    @Test
    public void testHashSetCreation() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        assertEquals(5, myHashSet.getIndexSize());
        MyCircularDoublyLinkedList<Integer> test = myHashSet.get(2);
        assertNotNull(myHashSet.get(0));
        assertNotNull(myHashSet.get(1));
        assertNotNull(myHashSet.get(2));
        assertNotNull(myHashSet.get(3));
        assertNotNull(myHashSet.get(4));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testHashSetGetNonExistingIndex() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        assertEquals(5, myHashSet.getIndexSize());
        MyCircularDoublyLinkedList<Integer> test = myHashSet.get(2);
        myHashSet.get(5);
    }

    @Test
    public void testAddHashSetAddSuccess() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        myHashSet.add(10);
        myHashSet.add(5);
        myHashSet.add(4);
        myHashSet.add(2);

        assertEquals(4, myHashSet.size());
    }

    @Test
    public void testContains() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(5);

        myHashSet.add(10);
        myHashSet.add(5);
        myHashSet.add(4);
        myHashSet.add(2);

        assertTrue(myHashSet.contains(10));
        assertTrue(myHashSet.contains(4));
        assertFalse(myHashSet.contains(1));
    }

    @Test
    public void testRearrange() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(3);

        myHashSet.add(9);
        myHashSet.add(3);
        myHashSet.add(12);

        assertEquals(3, myHashSet.get(0).size());
        assertEquals(3, myHashSet.getIndexSize());

        myHashSet.add(15);

        assertEquals(1, myHashSet.get(0).size());
        assertEquals(3, myHashSet.get(3).size());
        assertEquals(6, myHashSet.getIndexSize());

        assertTrue(myHashSet.contains(9));
        assertTrue(myHashSet.contains(15));
        assertFalse(myHashSet.contains(18));
    }
    @Test
    public void testRearrangeWithLoadFactor50() {
        MyHashSet<Integer> myHashSet = new MyHashSet<>(6, 0.50);

        myHashSet.add(6);
        myHashSet.add(12);
        myHashSet.add(18);

        assertEquals(3, myHashSet.get(0).size());
        assertEquals(6, myHashSet.getIndexSize());

        myHashSet.add(21);

        assertEquals(1, myHashSet.get(0).size());
        assertEquals(2, myHashSet.get(6).size());
        assertEquals(1, myHashSet.get(9).size());
        assertEquals(12, myHashSet.getIndexSize());

        assertTrue(myHashSet.contains(6));
        assertTrue(myHashSet.contains(12));
        assertFalse(myHashSet.contains(29));
    }
}
