package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if (this.isEmpty()) return null;
		return this.array[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return this.array.length - 1 == top;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()) throw new StackOverflowException();
		if (element == null) return;
		
		
		this.array[++this.top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty()) throw new StackUnderflowException();
	
		this.top--;
		return this.array[top + 1];
	}

}
