package 自製資料結構;

import java.util.Comparator;
import java.util.Iterator;

public class DataStack<D> implements Iterable<D> {
	
	private Object[] stack = new Object[1000];
	private Comparator<D> comparator;
	private int fristDataSite;
	private int endDataSite;
	private int amount;
	private boolean isTurnToFristDataPopped;

	public DataStack(Comparator<D> comparator) {
		super();
		this.comparator = comparator;
		fristDataSite = 0;
		endDataSite = -1;
		amount = 0;
		isTurnToFristDataPopped = true;
	}

	public void push(D data) {
		stack[++endDataSite] = (D) data;
		amount++;
	}
	
	public D pop() throws StackEmptyException {
		amount--;
		if (amount < 0)
			throw new StackEmptyException();
		if (isTurnToFristDataPopped) {
			isTurnToFristDataPopped = false;
			return (D) stack[fristDataSite++];
		}
		else {
			isTurnToFristDataPopped = true;
			return (D) stack[endDataSite--];
		}
	}
	
	public void sort() {
		for (int i = fristDataSite; i < endDataSite; i++) {
			for (int j = i + 1; j <= endDataSite; j++) {
				if (comparator.compare((D) stack[i], (D) stack[j]) > 0) {
					Object temp = stack[i];
					stack[i] = stack[j];
					stack[j] = (D) temp;
				}
			}
		}
	}

	@Override
	public Iterator<D> iterator() {
		return new InnerIterator();
	}
	
	private class InnerIterator implements Iterator<D> {
        private int index;
        private int front;
    	private int tail;
    	private boolean isTurnToFristData;
    	
        public InnerIterator() {
			super();
			front = fristDataSite;
			tail = endDataSite;
			index = front;
			isTurnToFristData = true;
		}

		public boolean hasNext() {
            return front <= tail;
        }

        public D next() {
        	if (isTurnToFristData) {
        		isTurnToFristData = false;
    			index = front++;
        	}
    		else {
    			isTurnToFristData = true;
    			index = tail--;
    		}
        	return (D) stack[index];
        }
    }
}
