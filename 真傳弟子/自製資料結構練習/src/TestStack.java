import java.util.Comparator;
import java.util.Iterator;

public class TestStack<T> implements Iterable<T> {

    private boolean pop = true;
    private int size = 0;
    private Node<T> head;
    private Comparator<T> comparator;

    public TestStack(Comparator<T> comparato){
            this.comparator = comparato;
            head = new Node();
    }

    public void push(T input){
        Node<T> p ;
        if(size==0){
            p = head;
            size++;
            p.setNext((new Node(input)));
        }else {
            p = head;
            while(p.getNext()!=null){
                p = p.getNext();
            }
            p.setNext(new Node(input));
            sort();
            size++;
            }

        }

        public T pop()  {
        Node<T> p;
        p = head;
            if(isEmpty())throw new PopException();
            if(pop){
                return getFirst();
            }else {
                return getLast();
            }
        }

        public T getFirst(){
            Node<T> p;
            p = head;

            Node<T>index = p.getNext();
            p.setNext(index.getNext());
            pop = false;
            size--;
            return index.getNode();
        }

        public T getLast(){
            Node<T> p;
            p = head;

            for(int i = 0 ;i<size-1;i++){
                p = p.getNext();
            }

            T number=  p.getNext().getNode();
            p.setNext(null);
            pop=true;
            size--;
            return number;
        }

        public void clear(){
            size =0;
        }

        public Node<T> sort(){
        Node<T> p;
        p = head;
            while(p.getNext()!=null){
                if(comparator.compare(p.getNext().getNode(),p.getNext().getNext().getNode()) > 0){

                    Node<T>index = p.getNext();
                    p.setNext(p.getNext().getNext());
                    p.getNext().setNext(index);
                    p = p.getNext();

                }else break;
        }
            return head;
    }

    public boolean isEmpty(){
        return size==0;
    }



    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private  class Iter implements Iterator<T>{
        Node<T> p;
        public Iter(){
            p = head;
        }
        @Override
        public boolean hasNext() {
            return isEmpty();
        }

        @Override
        public T next() {
                    return pop();
        }
    }
}

