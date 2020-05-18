package datastructures.binarysearchtree;

public class MyBSTNode {
    private MyBSTNode left;
    private MyBSTNode right;
    private int value;

    public MyBSTNode(int value) {
        this.value = value;
    }

    public MyBSTNode getLeft() {
        return left;
    }

    public void setLeft(MyBSTNode left) {
        this.left = left;
    }

    public MyBSTNode getRight() {
        return right;
    }

    public void setRight(MyBSTNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
