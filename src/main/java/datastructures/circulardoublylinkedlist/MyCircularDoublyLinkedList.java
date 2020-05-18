package datastructures.circulardoublylinkedlist;

public class MyCircularDoublyLinkedList<T> {
    private MyDLLNode<T> first;
    private MyDLLNode<T> last;
    private Integer size;

    public MyCircularDoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public MyDLLNode<T> add(T element) {
        MyDLLNode<T> newNode = new MyDLLNode<>(element);
        if (this.size == 0) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
            newNode.setPrevious(this.last);
        }
        this.last = newNode;
        this.size++;
        return newNode;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("Index does not exists in the list");
        }
        MyDLLNode<T> cursor = this.first;
        for (int i = 0; i < index; i++) {
            cursor = cursor.getNext();
        }
        return cursor.getValue();
    }

    public boolean contains(T element) {
        MyDLLNode<T> current = first;
        while (current != null) {
            if (current.getValue().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public boolean remove(T element) {
        MyDLLNode<T> current = first;
        boolean isRemoved = false;
        while (current != null) {
            if (current.getValue().equals(element)) {
                if (current == this.first) {
                    this.first = current.getNext();
                } else {
                    current.getPrevious().setNext(current.getNext());
                }
                if (current == this.last) {
                    this.last = current.getPrevious();
                } else {
                    current.getNext().setPrevious(current.getPrevious());
                }
                MyDLLNode<T> removed = current;
                current = current.getNext();
                removed.setNext(null);
                removed.setPrevious(null);
                isRemoved = true;
                this.size--;
            } else {
                current = current.getNext();
            }
        }
        return isRemoved;
    }

    public MyDLLNode<T> getFirst() {
        return this.first;
    }

    public MyDLLNode<T> getLast() {
        return this.last;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        MyDLLNode<T> cursor = this.first;
        while (cursor != null) {
            result.append(cursor.getValue().toString());
            if (cursor != this.last) {
                result.append(", ");
            }
            cursor = cursor.getNext();
        }
        return result.append("]").toString();
    }
}
