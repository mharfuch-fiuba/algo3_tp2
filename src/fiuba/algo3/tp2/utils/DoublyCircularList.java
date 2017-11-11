package fiuba.algo3.tp2.utils;

import fiuba.algo3.tp2.modelo.IterTablero;

public class DoublyCircularList {
	
	private static class Node {
		
		private Node next;
		private Node prev;
		private Object data;
		
		public Node(Object element) {
			this.next = null;
			this.prev = null;
			this.data = element;
		}
		
	}

	private Node primer_nodo;
	
	public DoublyCircularList(){
		primer_nodo = null;
	}
	
	public void add(Object element) {
		
	}

	public IterTablero iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
