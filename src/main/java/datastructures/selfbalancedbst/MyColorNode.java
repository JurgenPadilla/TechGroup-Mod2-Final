package datastructures.selfbalancedbst;

public class MyColorNode {
    public enum Color{
        RED,
        BLACK
    }
    private int value;
    private Color color;
    private MyColorNode left;
    private MyColorNode right;
    private MyColorNode parent;

    public MyColorNode(int value) {
        this.value = value;
        this.color = Color.RED;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyColorNode getLeft() {
        return left;
    }

    public void setLeft(MyColorNode left) {
        this.left = left;
    }

    public MyColorNode getRight() {
        return right;
    }

    public void setRight(MyColorNode right) {
        this.right = right;
    }

    public MyColorNode getParent() {
        return parent;
    }

    public void setParent(MyColorNode parent) {
        this.parent = parent;
    }
}
