package datastructures.arraylist;


public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private T[] items;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) return;

        T[] old = items;
        items = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = old[i];
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int index) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();

        return items[index];
    }

    public T set(int index, T newVal) {
        if (index < 0 || index >= size()) throw new ArrayIndexOutOfBoundsException();
        T old = items[index];
        items[index] = newVal;
        return old;
    }

    /**
     * add the element to the end of list
     *
     * @param element is the element you want to add
     * @return true if add successfully, otherwise return false
     */
    public boolean add(T element) {
        add(size(), element);
        return true;
    }

    /**
     * add the element to the specific position
     *
     * @param index is the position you want to insert the element
     * @param element     is the element you want to insert
     */
    public void add(int index, T element) {
        if (items.length == size()) ensureCapacity(size() * 2 + 1);
        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = element;
        size++;
    }

    public T remove(int index) {
        T removeItem = items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return removeItem;
    }

    public boolean remove(T element) {
        for (int i = 0; i < size(); ++i) {
            if (items[i] != null && items[i].equals(element)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size(); ++i) {
            if (items[i] != null && items[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder acc = new StringBuilder("[");
        for (int i = 0; i < size(); ++i) {
            if (i != 0) {
                acc.append(", ");
            }
            acc.append(items[i].toString());
        }
        acc.append("]");
        return acc.toString();
    }
}
