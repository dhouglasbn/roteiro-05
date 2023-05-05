package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull()) throw new QueueOverflowException();
		if (element == null) return;
		
		try {			
			this.stack1.push(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) throw new QueueUnderflowException();

		// desempilhar a stack1 e empilhar a stack2
		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.top());
				stack1.pop();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		T oldestElement = stack2.top();
		
		// desempilhar a stack2 e empilhar a stack1
		try {
			stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.top());
				stack2.pop();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return oldestElement;
	}

	@Override
	public T head() {
		if (this.isEmpty()) return null;

		// desempilhar a stack1 e empilhar a stack2
		while (!stack1.isEmpty()) {
			try {
				stack2.push(stack1.top());
				stack1.pop();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		T head = stack2.top();
		
		// desempilhar a stack2 e empilhar a stack1
		while (!stack2.isEmpty()) {
			try {
				stack1.push(stack2.top());
				stack2.pop();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return head;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

}
