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
		return this.array[top];
	}

	@Override
	public boolean isEmpty() {
		if (top == -1) return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (this.array.length - 1 == top) return true;
		return false;
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
		
		T topElement = this.array[top];
		
		this.top--;
		return topElement;
	}

}
