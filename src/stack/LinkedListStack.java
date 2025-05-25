package stack;

public class LinkedListStack<E> implements Stack<E> {

	private class Node<T> {
		T data;
		Node<T> next;

		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return ((next == null) ? "" : next.toString() + "-") + data.toString();
		}
	}

	Node<E> top = null;

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public E top() throws Underflow {
		if (isEmpty()) throw new Underflow();
		return top.data;
	}

	@Override
	public void push(E element) {
		top = new Node<>(element, top);
	}

	@Override
	public E pop() throws Underflow {
		if (isEmpty()) throw new Underflow();
		E data = top.data;
		top = top.next;
		return data;
	}

	@Override
	public String toString() {
		if (top == null)
			return "<empty>";
		return "<stack: " + top.toString() + ">";
	}
}
