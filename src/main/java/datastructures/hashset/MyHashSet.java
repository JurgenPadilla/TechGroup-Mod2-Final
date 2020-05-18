package datastructures.hashset;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;

public class MyHashSet<T> {
    private static final int LIST_SIZE_LIMIT = 3;
    private static final int INIT_ARRAY_SIZE = 10;
    private double loadFactor;

    private MyCircularDoublyLinkedList<T>[] index;
    private int indexSize;

    private int size;

    public MyHashSet() {
        this.init(INIT_ARRAY_SIZE);
        this.loadFactor = 1;
    }

    public MyHashSet(int initArraySize) {
        this.init(initArraySize);
        this.loadFactor = 1;
    }

    public MyHashSet(int initArraySize, double loadFactor) {
        this.init(initArraySize);
        this.loadFactor = loadFactor;
    }

    private void init(int indexSize) {
        this.indexSize = indexSize;
        this.index = new MyCircularDoublyLinkedList[this.indexSize];
        initArrayLists(this.index);
    }

    private void initArrayLists(MyCircularDoublyLinkedList[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = new MyCircularDoublyLinkedList<>();
        }
    }

    private static int getHashCode(Object value) {
        if (value instanceof String) {
            return value.toString().length();
        }

        return value.hashCode();
    }

    public int getIndexSize() {
        return this.indexSize;
    }

    public MyCircularDoublyLinkedList<T> get(int index) {
        if (this.indexSize <= index) {
            throw new ArrayIndexOutOfBoundsException("Nono");
        }
        return this.index[index];
    }

    public boolean contains(T newValue) {
        int hashKey = getHashCode(newValue) % this.indexSize;

        return contains(this.index, newValue, hashKey);
    }

    private static boolean contains(MyCircularDoublyLinkedList[] array, Object newValue, int hashKey) {
        MyCircularDoublyLinkedList currentList = array[hashKey];

        return currentList.contains(newValue);
    }

    public boolean add(T newValue) {
        int hashKey = getHashCode(newValue) % this.indexSize;

        boolean result = add(this.index, newValue, hashKey);

        if (result) {
            MyCircularDoublyLinkedList currentList = this.index[hashKey];
            this.size++;
            if((double) this.size/this.index.length > loadFactor){

                rearrangeSet();
            }
        }
        return result;
    }

    private static boolean add(MyCircularDoublyLinkedList[] currentArray, Object newValue, int hashKey) {

        if (contains(currentArray, newValue, hashKey)) {
            return false;
        }

        MyCircularDoublyLinkedList currentList = currentArray[hashKey];

        currentList.add(newValue);

        return true;
    }

    private  void rearrangeSet() {
        this.indexSize *= 2;
        MyCircularDoublyLinkedList<T>[] newIndex = new MyCircularDoublyLinkedList[this.indexSize];
        initArrayLists(newIndex);

        for (MyCircularDoublyLinkedList<T> currentList : this.index) {
            for (int i = 0; i < currentList.size(); ++i) {
                T currentItem = currentList.get(i);
                int hashKey = getHashCode(currentItem) % newIndex.length;
                add(newIndex, currentItem, hashKey);
            }
        }
        this.index = newIndex;
    }

    public int size() {
        return this.size;
    }
}
