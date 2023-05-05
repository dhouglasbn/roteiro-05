package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (this.isEmpty()) return null;
		return this.array[0];
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.array.length - 1 == this.tail;
	}
	
	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) throw new QueueOverflowException();
		if (element == null) return;
		
		this.array[++this.tail] = element;
	}
	
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) throw new QueueUnderflowException();
		
		T oldestElement = this.array[0];
		
		this.shiftLeft();;
		this.tail--;
		
		return oldestElement;
	
	}

	private void shiftLeft() {
		for (int i = 0; i < this.tail; i++) {
			this.array[i] = this.array[i + 1];
		}
	}

}