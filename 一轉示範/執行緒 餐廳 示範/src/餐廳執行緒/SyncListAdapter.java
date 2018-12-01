package À\ÆU°õ¦æºü;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncListAdapter<T> implements PriorityQueue<T> {
	private final List<T> syncList = Collections.synchronizedList(new ArrayList<>());
	
	@Override
	public synchronized boolean isEmpty() {
		return syncList.size() == 0;
	}

	@Override
	public synchronized T pop() {
		return syncList.remove(syncList.size() - 1);
	}

	@Override
	public synchronized void push(T t) {
		this.syncList.add(t);
	}
	

}
