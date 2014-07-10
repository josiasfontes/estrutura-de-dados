package estruturadados;

public class AVEX {

	/**
	 * verifies signal higher priority
	 * @param one = operand1
	 * @param two = operand2
	 * @return operator higher priority
	 */
	public boolean prcd(String one, String two) {
		int onePrcd = 0;
		int twoPrcd = 0;
		if ((one.equals("+")) || (one.equals("-"))) {
			onePrcd = 1;
		}
		if ((two.equals("+")) || (two.equals("-"))) {
			twoPrcd = 1;
		}
		if ((one.equals("*")) || (one.equals("/"))) {
			onePrcd = 2;
		}
		if ((two.equals("*")) || (two.equals("/"))) {
			twoPrcd = 2;
		}
		if (onePrcd >= twoPrcd) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * estimated value of the expression
	 * @param valor2 = operator2
	 * @param valor1 = operator1
	 * @param operador
	 * @return value of the expression
	 */
	public int calcularValores(String valor2, String valor1, String operador) {
		int v1 = Integer.parseInt(valor1);
		int v2 = Integer.parseInt(valor2);

		if (operador.equals("*")) {
			return v1 * v2;
		} else if (operador.equals("+")) {
			return v1 + v2;
		} else if (operador.equals("-")) {
			return v1 - v2;
		} else {
			return v1 / v2;
		}
	}

	/**
	 * verifies element is operator
	 * @param symb = element of the stack to be evaluated
	 * @return returns true if element is operator
	 */
	static boolean isOperator(String symb) {
		
		if ((symb.equals("*")) || (symb.equals("-")) || (symb.equals("/")) || (symb.equals("+")))
			return true;
		else
			return false;
	}

	/**
	 * calculates postfix expression
	 * @param posfixa = postfix expression to be calculated
	 * @return calculated value of the postfix expression
	 * @throws OverflowException exceeds the stack size
	 * @throws UnderflowException when the stack is empty and tries to take an element
	 */
	public int AvalPosfixa(MyStack<String> posfixa) throws OverflowException,
			UnderflowException {
		int tamanho = posfixa.size();
		MyStack<String> valor = new MyStack<String>(posfixa.size());
		MyStack<String> posfixaInversa = new MyStack<String>(posfixa.size());
		
		for (int i = 0; i < tamanho; i++) {
			posfixaInversa.push((String) posfixa.pop());
		}

		while (!posfixaInversa.isEmpty()) {
			String symb = (String) posfixaInversa.top();

			if (!isOperator(symb)) {
				valor.push(symb);
				posfixaInversa.pop();

			} else {
				String valor2 = (String) valor.pop();
				String valor1 = (String) valor.pop();
				String op = (String) posfixaInversa.pop();

				int calculo = calcularValores(valor2, valor1, op);
				valor.push(String.valueOf(calculo));
			}

		}
		
		return Integer.parseInt((String) valor.pop());
	}
/**
 * transforms infix expression into postfix
 * @param LInfixa = expression to be converted into postfix
 * @return	expression postfix
 * @throws OverflowException exceeds the stack size
 * @throws UnderflowException when the stack is empty and tries to take an element
 */
	public MyStack<String> infxPsfx(MyStack<String> LInfixa) throws OverflowException,
			UnderflowException {
		int tamanho2 = LInfixa.size();
		MyStack<String> infixaInversa = new MyStack<String>(LInfixa.size());
		MyStack<String> LPosfixa = new MyStack<String>(LInfixa.size());
		MyStack<String> OP = new MyStack<String>(LInfixa.size() + 1);

		for (int i = 0; i < tamanho2; i++) {
			infixaInversa.push((String) LInfixa.pop());
		}
		
		while (!infixaInversa.isEmpty()) {
			String symb = (String) infixaInversa.top();

			if (!isOperator(symb)) {
				LPosfixa.push(symb);
				infixaInversa.pop();
			} else {
				while (!OP.isEmpty() && prcd((String) OP.top(), symb)) {
					String topsymb = (String) OP.pop();
					LPosfixa.push(topsymb);
				}
				OP.push(symb);
				infixaInversa.pop();
			}
		}
		while (!OP.isEmpty()) {
			String topsymb = (String) OP.pop();
			LPosfixa.push(topsymb);
		}
		System.out.println("\nPOSFIXA");
		LPosfixa.print();
		return LPosfixa;
	}

}

