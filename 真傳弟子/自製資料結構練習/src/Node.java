public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(){

    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getNode() {
        return data;
    }

    public void setNode(T data) {
        this.data = data;
    }
}
