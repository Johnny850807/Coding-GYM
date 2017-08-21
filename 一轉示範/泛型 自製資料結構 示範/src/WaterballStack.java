import java.util.Comparator;
import java.util.Iterator;

/**�ŦX�D�ت��ۻs��Ƶ��c**/
public class WaterballStack<T> implements Iterable<T>{
	private SortedLinkedList<T> sortedList;
	private Comparator<T> comparator;
	private boolean popHead = true;  // �q head �}�l pop
	
	public WaterballStack(Comparator<T> comparator){
		this.comparator = comparator;
		this.sortedList = new SortedLinkedList<T>(comparator);
	}
	
	public void push(T t){
		sortedList.add(t);
	}
	
	public T pop(){  //�[�ݨî��X�U�@�Ӹ��
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
			cloneStack = WaterballStack.this.clone(); //���ƻs�@����Ƶ��c �γo�Ӹ�Ƶ��c�i�� pop ���X�N���|�ʨ�쥻��
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
