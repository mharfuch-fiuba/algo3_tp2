package fiuba.algo3.tp2.utils;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tp2.utils.DoublyCircularList.DoublyCircularListIterator;

public class DoublyCircularListTest {
	
	@Test
	public void testDoublyCircularListDeUnElementoConUnIteradorUsandoNext() {
		DoublyCircularList list = new DoublyCircularList();
		list.add(1);
		DoublyCircularListIterator iterator = list.iterator();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			resultado.add((Integer) iterator.actual());
			iterator.next();
		}
		Assert.assertArrayEquals(new Object[]{1,1,1,1,1,1,1,1,1,1}, resultado.toArray());
	}
	
	@Test
	public void testDoublyCircularListDeUnElementoConUnIteradorUsandoPrev() {
		DoublyCircularList list = new DoublyCircularList();
		list.add(1);
		DoublyCircularListIterator iterator = list.iterator();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			resultado.add((Integer) iterator.actual());
			iterator.prev();
		}
		Assert.assertArrayEquals(new Object[]{1,1,1,1,1,1,1,1,1,1}, resultado.toArray());
	}
	
	@Test
	public void testDoublyCircularListDeDosElementosConUnIteradorUsandoNext() {
		DoublyCircularList list = new DoublyCircularList();
		list.add(1);
		list.add(2);
		DoublyCircularListIterator iterator = list.iterator();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			resultado.add((Integer) iterator.actual());
			iterator.next();
		}
		Assert.assertArrayEquals(new Object[]{1,2,1,2,1,2,1,2,1,2}, resultado.toArray());
	}
	
	@Test
	public void testDoublyCircularListDeDosElementosConUnIteradorUsandoPrev() {
		DoublyCircularList list = new DoublyCircularList();
		list.add(1);
		list.add(2);
		DoublyCircularListIterator iterator = list.iterator();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			resultado.add((Integer) iterator.actual());
			iterator.prev();
		}
		Assert.assertArrayEquals(new Object[]{1,2,1,2,1,2,1,2,1,2}, resultado.toArray());
	}
	
	@Test
	public void testDoublyCircularListDeTresElementosConUnIteradorUsandoNext() {
		DoublyCircularList list = new DoublyCircularList();
		list.add(1);
		list.add(2);
		list.add(3);
		DoublyCircularListIterator iterator = list.iterator();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			resultado.add((Integer) iterator.actual());
			iterator.next();
		}
		Assert.assertArrayEquals(new Object[]{1,2,3,1,2,3,1,2,3,1}, resultado.toArray());
	}
	
	@Test
	public void testDoublyCircularListDeTresElementosConUnIteradorUsandoPrev() {
		DoublyCircularList list = new DoublyCircularList();
		list.add(1);
		list.add(2);
		list.add(3);
		DoublyCircularListIterator iterator = list.iterator();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			resultado.add((Integer) iterator.actual());
			iterator.prev();
		}
		Assert.assertArrayEquals(new Object[]{1,3,2,1,3,2,1,3,2,1}, resultado.toArray());
	}
	
	@Test
	public void testDoublyCircularListDeCutroElementoConDosIteradoresUsandoNext() {
		DoublyCircularList list = new DoublyCircularList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		DoublyCircularListIterator iterator1 = list.iterator();
		DoublyCircularListIterator iterator2 = list.iterator();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for(int i = 0;i<5;i++) {
			resultado.add((Integer) iterator1.next());//24242
			resultado.add((Integer) iterator2.next());//23412
			resultado.add((Integer) iterator1.next());//31313
		}
		Assert.assertArrayEquals(new Object[]{2,2,3,4,3,1,2,4,3,4,1,1,2,2,3}, resultado.toArray());
	}
	
	@Test
	public void testDoublyCircularListDeCutroElementoConDosIteradoresUsandoPrev() {
		DoublyCircularList list = new DoublyCircularList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		DoublyCircularListIterator iterator1 = list.iterator();
		DoublyCircularListIterator iterator2 = list.iterator();
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for(int i = 0;i<5;i++) {
			resultado.add((Integer) iterator1.prev());//42424
			resultado.add((Integer) iterator2.prev());//43214
			resultado.add((Integer) iterator1.prev());//31313
		}
		Assert.assertArrayEquals(new Object[]{4,4,3,2,3,1,4,2,3,2,1,1,4,4,3}, resultado.toArray());
	}

}
