package datastructures.linkedlist;

public class MyLLNode<E> {
    private MyLLNode<E> next;
    private E value;

    public MyLLNode(E value) {
        this.value = value;
        this.next = null;
    }

    public MyLLNode<E> getNext() {
        return next;
    }

    public void setNext(MyLLNode next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
