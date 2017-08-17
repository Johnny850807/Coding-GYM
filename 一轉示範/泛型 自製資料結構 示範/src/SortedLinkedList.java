import java.util.Comparator;
import java.util.Random;

/** �|���_�����ƧǡA�åi�H���pop �Y�٬O�� ���ۻs��C  **/
public class SortedLinkedList<T>{
	private Link<T> head; //������C�Y��
	private Link<T> tail;
	private Comparator<T> comparator;
	
	public SortedLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public SortedLinkedList<T> add(T data){
		Link<T> link = new Link<T>(data);
		
		if (head == null)  //�Y��C�|�����͡A�Y�����O�Ĥ@��Link
			head = tail = link;
		else  //�H�U�ھڤT�ر��p�M�w�Ӧ�C�n��m�b��
		{
			if (comparator.compare(data, head.getData()) < 0) //��Head�٤p => ��m Head�e��
			{
				link.setNext(head);
				head = link;
			}
			else if (comparator.compare(data, tail.getData()) >= 0) //�� tail �٤j �� �ۦP => ��m tail �᭱
			{
				tail.setNext(link);  //�[����ڪ��U�@��
				tail = link;  //�ç�s����
			}
			else  // ��� head �P tail ����  => �@�����X ������@�Ӥ�L�j���`�I �é�b�L�e��
			{
				Link<T> pointer = null;  //���X����
				Link<T> front = null;  //�������X���Ъ��W�@�� 
				for (pointer = head ; comparator.compare(data, pointer.getData()) >= 0; pointer = pointer.getNext())
					front = pointer; 
				link.setNext(pointer);  //���J�ܤ���
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
		
		if (tail.equals(head))  // �Y�N�O��
			head = tail = null;
		else  
		{
			Link<T> pointer = null;  
			for (pointer = head ; !pointer.getNext().equals(tail) ; pointer = pointer.getNext())
				/**�@�����X����ڪ��e�@�ӴN���}**/;
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
		for (int i = 0 ; i < 100 ; i ++) //���� �s�W 100�� �H���Ʀr
			list.add(random.nextInt(100));

		for (int i = 0 ; i < 100 ; i ++)
			System.out.print(list.popHead().getData() + " ");
		
		System.out.println();
		
		for (int i = 0 ; i < 100 ; i ++) //���� �s�W 100�� �H���Ʀr
			list.add(random.nextInt(100));
		
		for (int i = 0 ; i < 100 ; i ++)
			System.out.print(list.popTail().getData() + " ");
		
		System.out.println();

	}
}
