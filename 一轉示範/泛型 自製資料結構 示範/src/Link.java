
/**¦ê¦C¸`ÂI**/
public class Link<T> {
	private T data;
	private Link<T> next = null;
	
	public Link(T data) {
		this.data = data;
	}
	
	public Link<T> getNext(){
		return next;
	}
	
	public void setNext(Link<T> next){
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
	
	
}
