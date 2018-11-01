package 泛型資料結構;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class UserDefinedDataStructure<T> implements Iterable<T> {
	
	private int arrayTElementAmount = 0 ;
	private int popIndex = 0 ;
	private boolean hasPopped = false ;
	
	private Object[] arrayT = new Object[5]; 
	private Comparator myComparator ;
	
	public	UserDefinedDataStructure(Comparator c){
		myComparator = c ;
	}
	
	public void push(T t) {

		if	(hasPopped) {
			removeNullElement(arrayT);
			hasPopped = false ;
		}
		// 若滿倉便擴充
		if	( arrayTElementAmount == arrayT.length ) {
			arrayT = Arrays.copyOf(arrayT, arrayT.length * 2);			
		}
		
		arrayT[arrayTElementAmount] = t ;
		arrayTElementAmount++ ;	
		popIndex = 0 ;
		
		ascendingSort();
	}
	/**
	 * 將pop過的陣列重新裝填至新陣列
	 */
	private void removeNullElement(Object[] arrayT) {
			
		arrayTElementAmount--;		

		Object[] replaceArray = new Object[arrayTElementAmount];
		
		for	(int replaceArrayIndex = 0; replaceArrayIndex < replaceArray.length ; replaceArrayIndex++) {

			replaceArray[replaceArrayIndex] = arrayT[replaceArrayIndex + 1];
		}
	
		this.arrayT = replaceArray ;		
	}

	public T pop() throws StackEmptyException {
		
		hasPopped = true ;
		
		if	(popIndex == arrayTElementAmount) {
			throw new StackEmptyException();
		}
		Object popElement = arrayT[popIndex] ;		
		popIndex++ ;
		System.gc();
		return (T)popElement ;
	}
	/**
	 * 升冪排序
	 */
	private void ascendingSort() {
	
		Object replaceArrayT[] = new Object [arrayTElementAmount];
		Object reverseReplaceArrayT[] = new Object [arrayTElementAmount];
		
		for (int i = 0 ; i < arrayTElementAmount ; i++ ) {
			
			int compareResultNumber = 0 ;
			int reverseCompareResultNumber  = (arrayTElementAmount-1) ;
			
			for	(int j = 0 ; j < arrayTElementAmount ; j++ ) {
				// 共大過幾個其他數字
				if 	( myComparator.compare(arrayT[i], arrayT[j]) > 0 ) {
					compareResultNumber++ ;
				}
			}
			//正排序
			replaceArrayT[compareResultNumber] = arrayT[i];
			//逆排序
			reverseReplaceArrayT[reverseCompareResultNumber-compareResultNumber] = arrayT[i];
		}	
		arrayT = iteratorSort(replaceArrayT, reverseReplaceArrayT);
	}
	/**
	 * 正排序放奇數位
	 * 逆排序置偶數位
	 * 交疊排序
	 */
	private Object[] iteratorSort(Object[]replaceArrayT,Object[]reverseReplaceArrayT) {
	
		Object[] visitArray = new Object[arrayTElementAmount] ;
		
		for	(int i = 0; i < visitArray.length; i++) {
		//	正排序放奇位
			if	( i % 2 == 0 ) {
				visitArray[i] = replaceArrayT[(i+1)/2];
			}
		//	逆排序放偶位	
			else if( i % 2 == 1 ){
				visitArray[i] = reverseReplaceArrayT[i/2];
			}
		}	
		return visitArray;
	}

	@Override
	public Iterator<T> iterator() {
		return new InnerIterator();
	}
	public class InnerIterator implements Iterator<T>{
		
		private int index = 0 ;
		
		InnerIterator(){
		}

		@Override
		public boolean hasNext() {
		
		return index < arrayTElementAmount ;
			
		}

		@Override
		public T next() {
			return (T) arrayT[index++];
		}
		
	}
}
