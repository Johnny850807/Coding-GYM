import java.util.Comparator;
import java.util.Iterator;

/**符合題目的自製資料結構**/
public class WaterballStack<T> implements Iterable<T>{
	private SortedLinkedList<T> sortedList;
	private Comparator<T> comparator;
	private boolean popHead = true;  // 從 head 開始 pop
	
	public WaterballStack(Comparator<T> comparator){
		this.comparator = comparator;
		this.sortedList = new SortedLinkedList<T>(comparator);
	}
	
	public void push(T t){
		sortedList.add(t);
	}
	
	public T pop(){  //觀看並拿出下一個資料
		if (!hasNext())
			throw new StackEmptyException();
		
		T data;
		if (popHead)
			data = sortedList.popHead().getData();
		else
			data = sortedList.popTail().getData();
		
		popHead = !popHead;
		return data;
	}
	
	public boolean hasNext(){
		return sortedList.hasNext();
	}
	
	public WaterballStack<T> clone(){
		WaterballStack<T> stack = new WaterballStack<T>(comparator);
		stack.sortedList = this.sortedList.clone();
		return stack;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new SortedLinkIterator();
	}
	
	class SortedLinkIterator implements Iterator<T>{
		private WaterballStack<T> cloneStack;
		
		public SortedLinkIterator(){
			cloneStack = WaterballStack.this.clone(); //先複製一份資料結構 用這個資料結構進行 pop 走訪就不會動到原本的
		}
		
		@Override
		public boolean hasNext() {
			return cloneStack.hasNext();
		}

		@Override
		public T next() {
			return cloneStack.pop();
		}
		
	}

}
