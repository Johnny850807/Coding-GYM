import java.util.Comparator;
import java.util.Random;

/** 會不斷維持排序，並可以選擇pop 頭還是尾 的自製串列  **/
public class SortedLinkedList<T>{
	private Link<T> head; //紀錄串列頭尾
	private Link<T> tail;
	private Comparator<T> comparator;
	
	public SortedLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public SortedLinkedList<T> add(T data){
		Link<T> link = new Link<T>(data);
		
		if (head == null)  //若串列尚未產生，頭尾都是第一個Link
			head = tail = link;
		else  //以下根據三種情況決定該串列要放置在哪
		{
			if (comparator.compare(data, head.getData()) < 0) //比Head還小 => 放置 Head前面
			{
				link.setNext(head);
				head = link;
			}
			else if (comparator.compare(data, tail.getData()) >= 0) //比 tail 還大 或 相同 => 放置 tail 後面
			{
				tail.setNext(link);  //加到尾巴的下一個
				tail = link;  //並更新尾巴
			}
			else  // 位於 head 與 tail 中間  => 一路走訪 直到找到一個比他大的節點 並放在他前面
			{
				Link<T> pointer = null;  //走訪指標
				Link<T> front = null;  //紀錄走訪指標的上一個 
				for (pointer = head ; comparator.compare(data, pointer.getData()) >= 0; pointer = pointer.getNext())
					front = pointer; 
				link.setNext(pointer);  //插入至中間
				front.setNext(link);
			}
			
		}
		
		return this;
	}
	
	public Link<T> popHead(){
		if (head == null)
			return null;
		Link<T> oldHead = head;
		head = head.getNext();
		
		return oldHead;
	}
	
	public Link<T> popTail(){
		Link<T> oldTail = tail;
		
		if (tail == null)
			return null;
		
		if (tail.equals(head))  // 頭就是尾
			head = tail = null;
		else  
		{
			Link<T> pointer = null;  
			for (pointer = head ; !pointer.getNext().equals(tail) ; pointer = pointer.getNext())
				/**一路走訪到尾巴的前一個就離開**/;
			tail = pointer;
		}
		

		return oldTail;
	}
	
	
	public boolean hasNext(){
		return head != null;
	}
	
	public SortedLinkedList<T> clone(){
		SortedLinkedList<T> cloneList = new SortedLinkedList<T>(comparator);
		for (Link<T> pointer = head ; pointer != null ; pointer = pointer.getNext())
			cloneList.add(pointer.getData());
		return cloneList;
	}
	

	// Test
	public static void main(String[] argv){
		SortedLinkedList<Integer> list = new SortedLinkedList<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		});
		Random random = new Random();
		for (int i = 0 ; i < 100 ; i ++) //測試 新增 100個 隨機數字
			list.add(random.nextInt(100));

		for (int i = 0 ; i < 100 ; i ++)
			System.out.print(list.popHead().getData() + " ");
		
		System.out.println();
		
		for (int i = 0 ; i < 100 ; i ++) //測試 新增 100個 隨機數字
			list.add(random.nextInt(100));
		
		for (int i = 0 ; i < 100 ; i ++)
			System.out.print(list.popTail().getData() + " ");
		
		System.out.println();

	}
}
