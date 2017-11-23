package fiuba.algo3.tp2.utils;

public interface DoublyLinkedCircularListIterator {
	public Object next();
	public Object prev();
	public Object actual();
	public void remove();
	public int size();
}
