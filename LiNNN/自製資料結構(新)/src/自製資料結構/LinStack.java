package 自製資料結構;

import java.util.Comparator;
import java.util.Iterator;
import Exception.StackEmptyException;

public class LinStack<T> implements Iterable<T> {

	private Comparator<T> myComparator;
	private Object[] stack = new Object[1000];
	private int index; // push陣列用
	private int choice; // switch用
	private int amount; // 決定choice用
	private int firstIndex; // pop-頭
	private int lastIndex; // pop-尾

	public LinStack(Comparator<T> comparator) {
		myComparator = comparator;
		index = 0;
		amount = 1;
		firstIndex = 0;
		lastIndex = 0;
	}

	public void push(T t) {
		stack[index] = t;
		index++;
		lastIndex++;
		comparator(); // 排序用
	}

	@SuppressWarnings("unchecked")
	public T pop() throws StackEmptyException {
		T object = null;
		if (lastIndex - firstIndex == 0)
			throw new StackEmptyException();
		if (amount % 2 == 1)
			choice = 1;
		if (amount % 2 == 0)
			choice = 2;

		switch (choice) {
		case 1:
			object = (T) stack[firstIndex];
			firstIndex++;
			amount++;
			break;

		case 2:
			object = (T) stack[--lastIndex];
			amount++;
			break;
		}
		return object;
	}

	@SuppressWarnings("unchecked")
	public void comparator() {
		for (int i = lastIndex - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (myComparator.compare((T) stack[i], (T) stack[j]) == 1) {
					T temp = (T) stack[i];
					stack[i] = (T) stack[j];
					stack[j] = temp;
				}
	}

	public Iterator<T> iterator() {
		return new InnerIterator();
	}

	private class InnerIterator implements Iterator<T> {

		private int choice;
		private int first;
		private int last;
		private int amount;

		public InnerIterator() {
			first = firstIndex;
			last = lastIndex;
			amount = 1;
		}

		@Override
		public boolean hasNext() {
			return first < last;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			T object = null;
			if (amount % 2 == 1)
				choice = 1;
			if (amount % 2 == 0)
				choice = 2;

			switch (choice) {
			case 1:
				object = (T) stack[first];
				first++;
				amount++;
				break;

			case 2:
				object = (T) stack[--last];
				amount++;
				break;
			}
			return object;

		}

	}

}
