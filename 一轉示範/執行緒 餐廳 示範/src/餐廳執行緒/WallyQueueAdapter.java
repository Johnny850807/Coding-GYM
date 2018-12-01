package À\ÆU°õ¦æºü;

import java.util.Comparator;

public class WallyQueueAdapter<T> implements PriorityQueue<T> {
	private final WallyPriorityQueue<T> wallyPriorityQueue;

	public WallyQueueAdapter(Comparator<T> comparator) {
		this.wallyPriorityQueue = new WallyPriorityQueue<>(comparator); 
	}
	
	@Override
	public synchronized boolean isEmpty() {
		return wallyPriorityQueue.isEmpty();
	}

	@Override
	public synchronized T pop() {
		return wallyPriorityQueue.pop();
	}

	@Override
	public synchronized void push(T t) {
		this.wallyPriorityQueue.push(t);
	}
	

}
