package TicTacToe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TicTacToeRow implements Collection<E> {
	
	private ArrayList<Integer> row;
	public TicTacToeRow(int size){
		
		if(size > TicTacToeMaxSize.MaxSize.value()){
			throw new Exception("Size is too big!");
		}
		
		while(i < size){
			row.add(TicTacToeValue.Blank);
			i++;
		}
		
	}

}
	public void forEach(Consumer<? super E> arg0) {
		// TODO Auto-generated method stub
		
	}
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	public Stream<E> parallelStream() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean removeIf(Predicate<? super E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Spliterator<E> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}
	public Stream<E> stream() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
