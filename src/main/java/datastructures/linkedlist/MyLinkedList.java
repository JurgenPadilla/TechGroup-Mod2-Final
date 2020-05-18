package datastructures.linkedlist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {
    private MyLLNode<T> first;
    private MyLLNode<T> last;
    private Integer size;

    public MyLinkedList() {
        size = 0;
    }

    public MyLLNode<T> getFirst() {
        return first;
    }

    public void setFirst(MyLLNode<T> first) {
        this.first = first;
    }

    public MyLLNode<T> getLast() {
        return last;
    }

    public void setLast(MyLLNode<T> last) {
        this.last = last;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        MyLLNode<T> current = first;
        while (current != null) {
            if (current.getValue().equals(o)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new MyIterator();
        return iterator;
    }

    private class MyIterator implements Iterator {
        private int position;
        private MyLLNode<T> current;

        public MyIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            if (position >= size) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Object next() {
            MyLLNode<T> next = current;
            this.current = this.current.getNext();
            position++;
            return next.getValue();
        }
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        if (!isEmpty()) {
            MyLLNode<T> current = first;
            for (int i = 0; i < size; i++) {
                objects[i] = current.getValue();
                current = current.getNext();
            }
        }
        return objects;
    }

    @Override
    public boolean add(Object o) {
        MyLLNode<T> newNode = new MyLLNode(o);
        if (isEmpty()) {
            this.first = this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object element) {
        MyLLNode<T> current = this.first;
        MyLLNode<T> previous = this.first;
        boolean isRemoved = false;
        while (current != null) {
            if (current.getValue().equals(element)) {
                if(this.size == 1){
                    first = last = null;
                }
                if(current == this.last){
                    this.last = previous;
                }
                if(current == this.first){
                    this.first = current.getNext();
                    current = previous = this.first;
                }
                previous.setNext(current.getNext());
                current = previous;
                size--;
                isRemoved = true;
            }
            previous = current;
            current = current.getNext();
        }
        return isRemoved;
    }

    @Override
    public boolean addAll(Collection c) {
        if (!c.isEmpty()) {
            Iterator iterator = c.iterator();
            while (iterator.hasNext()) {
                add(iterator.next());
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(int index, Collection c) {

        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (!c.isEmpty()) {
            Iterator iterator = c.iterator();
            while (iterator.hasNext()) {
                add(index++, iterator.next());
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (!isEmpty()) {
            MyLLNode<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getValue();
        }
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        if (!isEmpty()) {
            MyLLNode<T> current = first;
            Object oldElement;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            oldElement = current.getValue();
            current.setValue((T)element);
            return oldElement;
        }
        return null;
    }

    @Override
    public void add(int index, Object element) {
        if (index > this.size || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addAtStart(element);
            return;
        }
        if (index == this.size) {
            addAtTheEnd(element);
            return;
        }
        MyLLNode<T> newNode = new MyLLNode(element);
        MyLLNode<T> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    private void addAtTheEnd(Object element) {
        MyLLNode<T> newNode = new MyLLNode(element);
        this.last.setNext(newNode);
        this.last = newNode;
        size++;
    }

    private void addAtStart(Object element) {
        MyLLNode<T> newNode = new MyLLNode(element);
        newNode.setNext(this.first);
        this.first = newNode;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            return null;
        }
        if (index == 0) {
            return removeFirstElement();
        } else if (index == this.size - 1) {
            return removeLastElement();
        } else {
            MyLLNode<T> current = first;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            T elementRemoved = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
            size--;
            return elementRemoved;
        }
    }

    private T removeLastElement() {
        MyLLNode<T> current = this.first;
        while (current.getNext() != this.last) {
            current = current.getNext();
        }
        T elementRemoved = current.getNext().getValue();
        current.setNext(null);
        this.last = current;
        size--;
        return elementRemoved;
    }

    private T removeFirstElement() {
        T elementRemoved = this.first.getValue();
        this.first = this.first.getNext();
        if (first == null) {
            this.last = null;
        }
        size--;
        return elementRemoved;
    }

    @Override
    public int indexOf(Object o) {
        MyLLNode<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.getValue().equals(o)) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyLLNode<T> current = last;
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (current.getValue().equals(o)) {
                position = i;
            }
            current = current.getNext();
        }
        return position;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        MyLinkedList sublist = new MyLinkedList();
        MyLLNode<T> first = new MyLLNode(get(fromIndex));
        MyLLNode<T> last = new MyLLNode(get(toIndex));
        sublist.setFirst((first));
        sublist.setLast((last));
        return sublist;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (containsAll(c)) {
            Iterator iterator = c.iterator();
            while (iterator.hasNext()) {
                remove(iterator.next());
            }
            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean containsCollection = false;
        if (!c.isEmpty()) {
            Iterator iterator = c.iterator();
            while (iterator.hasNext()) {
                containsCollection = contains(iterator.next());
                if (containsCollection == false) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length == size) {
            a = toArray();
            return a;
        } else if (a.length > size) {
            Object[] myListArray = toArray();
            a = Arrays.copyOf(myListArray, a.length);
            return a;
        } else {
            return toArray();
        }
    }

    @Override
    public String toString(){
        String concatenatedElements = "[";
        MyLLNode<T> current = first;
        while (current != null){
            concatenatedElements += current.getValue().toString();
            if(current != last){
                concatenatedElements +=  ", ";
            }
            current = current.getNext();
        }
        return concatenatedElements + "]";
    }
}
