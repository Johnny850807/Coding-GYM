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
			reload(arrayT);
			hasPopped = false ;
		}
		
		if	( arrayTElementAmount == arrayT.length ) {
			arrayT = Arrays.copyOf(arrayT, arrayT.length * 2);			
		}
		
		arrayT[arrayTElementAmount] = t ;
		arrayTElementAmount++ ;	
		popIndex = 0 ;
		
		normalSort();
	}
	
	private void reload(Object[] arrayT) {
			
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
	
	private void normalSort() {
	
		Object replaceArrayT[] = new Object [arrayTElementAmount];
		Object reverseReplaceArrayT[] = new Object [arrayTElementAmount];
		
		for (int i = 0 ; i < arrayTElementAmount ; i++ ) {
			
			int compareResultNumber = 0 ;
			int reverseCompareResultNumber  = (arrayTElementAmount-1) ;
			
			for	(int j = 0 ; j < arrayTElementAmount ; j++ ) {
				
				if 	( myComparator.compare(arrayT[i], arrayT[j]) > 0 ) {
					compareResultNumber++ ;
				}
			}
			replaceArrayT[compareResultNumber] = arrayT[i];
			reverseReplaceArrayT[reverseCompareResultNumber-compareResultNumber] = arrayT[i];
		}	
		arrayT = visitSort(replaceArrayT, reverseReplaceArrayT);
	}
	
	private Object[] visitSort(Object[]replaceArrayT,Object[]reverseReplaceArrayT) {
	
		Object[] visitArray = new Object[arrayTElementAmount] ;
		
		for	(int i = 0; i < visitArray.length; i++) {
			if	( i % 2 == 0 ) {
				visitArray[i] = replaceArrayT[(i+1)/2];
			}
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
//		normalSort();
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
