package datastructures.circulardoublylinkedlist;

public class MyDLLNode<E> {

    private MyDLLNode<E> next;
    private MyDLLNode<E> previous;
    private E value;

    public MyDLLNode(E value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public MyDLLNode<E> getNext() {
        return next;
    }
    public MyDLLNode<E> getPrevious() {
        return previous;
    }

    public void setNext(MyDLLNode<E> next) {
        this.next = next;
    }
    public void setPrevious(MyDLLNode<E> previous) {
        this.previous = previous;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
