package data_structure;

import exception.StackIsEmptyException;

import java.util.Comparator;
import java.util.Iterator;

public class LinStack<T> implements Iterable<T> {
    private Comparator<T> comparator;
    private Object[] stack;
    private int index;
    private boolean turnToHead = true;
    private int firstIndex;
    private int tailIndex;

    public LinStack(Comparator<T> comparator) {
        this.comparator = comparator;
        this.stack = new Object[100];
        this.index = 0;
        this.firstIndex = 0;
        this.tailIndex = 0;
    }

    public void push(T t) {
        stack[index] = t;
        index++;
        tailIndex++;
        compareStack();
    }

    public T pop() {
        T object;

        if (tailIndex - firstIndex == 0)
            throw new StackIsEmptyException();
        else {
            object = turnToHead ? (T) stack[firstIndex] : (T) stack[--tailIndex];
            firstIndex = turnToHead ? (firstIndex + 1) : firstIndex;
        }

        turnToHead = !turnToHead;

        return object;
    }

    private void compareStack() {
        for (int i = 0; i < tailIndex; i++) {
            for (int j = tailIndex - 1; j >= i; j--) {
                if (comparator.compare((T) stack[i], (T) stack[j]) > 0) {
                    T tmp = (T) stack[i];
                    stack[i] = stack[j];
                    stack[j] = tmp;
                }
            }
        }
    }

    public LinStack<T> copy(){
        LinStack<T> linStack = new LinStack<>(comparator);
        linStack.stack = this.stack;
        linStack.firstIndex = this.firstIndex;
        linStack.tailIndex = this.tailIndex;
        return linStack;
    }

    @Override
    public Iterator<T> iterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements Iterator<T> {
        private LinStack<T> linStack;

        public InnerIterator(){
            this.linStack = LinStack.this.copy();
        }

        @Override
        public boolean hasNext() {
            return linStack.firstIndex < linStack.tailIndex;
        }

        @Override
        public T next() {
            return linStack.pop();
        }
    }

}
