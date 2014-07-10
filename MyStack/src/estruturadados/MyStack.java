package estruturadados;

/**stack class generic type
 * @author josias

*/
public class MyStack <P>{
	
	private static int stackSize = 10;// standard stack capacity
	private int posicionStack = -1;// top of the stack
	P[] stack;// storage array

	 /**
	  *  stack has two types of constructor where the first receives a size for the stack
	  * @param size
	  */
	public MyStack(int size) {// constructor with the stack size
		stackSize = size;
		stack = (P[])new Object[stackSize];
	}

	/**
	 * whereas the second has a size standard
	 */
	public MyStack() { // builder standard cell // or null
		stack = (P[])new Object[stackSize];
	}
	
	/**
	 * checks if the stack is empty
	 * @return true if empty
	*/
	public boolean isEmpty() { 
		return posicionStack == -1; 
	}
	
	/**
	 * check if the stack is full
	 * returns true is stack is full or false if it is not full
	*/
	public boolean isFull() { // 
		return posicionStack == stack.length - 1;
	}
	
	/**
	 * @return array size
	*/
	public int size() { 
		return (posicionStack+1);
	}
	
	/**
	 * returns the top item of the stack
	*/
	public P top() { 
		if (!isEmpty()) {
			return stack[posicionStack];
		}
		return null;
	}

	/**
	 * inserts the element at the top of the stack
	*/
	public void push(P value) throws OverflowException {
		if (isFull()) {
			throw new OverflowException();
		} else {
			posicionStack += 1;
			stack[posicionStack] = value;

		}

	}

	/**
	 * removes the top element from the stack
	*/
	public Object pop() throws UnderflowException { 
												
		if (!isEmpty()) {
			Object valor = stack[posicionStack];
			stack[posicionStack] = null;
			posicionStack -= 1;
			return valor;
		}else
			throw new UnderflowException();
	}

	/**
	 * empties the stack
	*/
	public void clear() {
		for (int i = 0; i <= posicionStack; i++) {
			stack[i] = null;
		}
		posicionStack = -1;

	}

	/**
	 * print stack
	*/
	public void print() {

		for (int i = 0; i < stack.length; i++) {
			System.out.println("[" + i + "]" + stack[i]);
		}

	}
}
