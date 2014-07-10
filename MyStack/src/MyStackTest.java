import java.util.Scanner;

import estruturadados.AVEX;
import estruturadados.MyStack;
import estruturadados.OverflowException;
import estruturadados.UnderflowException;

public class MyStackTest {

	public static void main(String[] args) throws OverflowException,
			UnderflowException {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Escolha uma opcao: ");
		System.out.println("1. Avaliar Expressões Matemáticas");
		System.out.println("2. Usar a pilha");
		System.out.println("3. Sair");

		int opcaoInicio = entrada.nextInt();

		if (opcaoInicio == 1) {
			System.out
					.print("Digite a quantidade de 'DÍGITOS' da sua expressao: ");
			Scanner entrada1 = new Scanner(System.in);
			int expressionsize = entrada1.nextInt();

			MyStack<String> infixa = new MyStack<String>(expressionsize); // pilha armazena forma infixa
																
			MyStack<String> posfixa1 = new MyStack<String>(expressionsize); // pilha armazena forma posfixa
																			
			Scanner entrada3 = new Scanner(System.in);
			String[] expressao = new String[expressionsize];// string armazenar
															// valores do
															// usuario

			for (int i = 0; i < expressao.length; i++) {// inserindo valores da
														// expressao na pilha
				System.out.print("[" + i + "]= ");
				infixa.push(entrada3.nextLine());
			}

			AVEX avex = new AVEX();
			posfixa1 = avex.infxPsfx(infixa);// convertendo infixa para posfixa
			System.out.println("\nResultado da expressao: "
					+ avex.AvalPosfixa(posfixa1));// calculando o valor da
													// expressao posfixa

		} else if (opcaoInicio == 2) {

			System.out.println("Deseja usar o tamanho padrão do vetor? ");
			System.out.println("1. Sim");
			System.out.println("2. Não");

			int opcao = entrada.nextInt();
			int opcao2;
			if (opcao == 1) {

				MyStack<Character> stack = new MyStack<Character>();// valor
																	// padrao da
																	// pilha
				char valor;
				do {

					System.out.println("\nEscolha uma opcao: ");
					System.out.println("1. Inserir um elemento na pilha");
					System.out.println("2. Remover um elemento na pilha");
					System.out.println("3. Verificar situação da pilha");
					System.out.println("4. Mostrar o tamanho da pilha");
					System.out
							.println("5. Mostrar o elemento do topo da pilha");
					System.out.println("6. Esvaziar a pilha");
					System.out.println("7. Imprimir a pilha");
					System.out.println("8. Sair");
					opcao2 = entrada.nextInt();

					if (opcao2 == 1) {

						try {
							System.out
									.println("Digite o número a ser 'INSERIDO' na pilha: ");
							valor = entrada.next().charAt(0);// get
																// character/element
																// index 0
																// (char)
							stack.push(valor);

						} catch (OverflowException e) {// exceção
							System.err.println(e.getMessage());

						}

					} else if (opcao2 == 2) {
						try {
							System.out.println("'REMOVENDO' número na pilha: ");

							stack.pop();// método que remove o elemento do topo
										// da
										// pilha
						} catch (UnderflowException e) {// exceção
														//
							System.out.println(e.getMessage());
						}
					} else if (opcao2 == 3) {
						if (stack.isEmpty()) {
							System.out.println("\nA pilha está 'VAZIA'");
						} else if (stack.isFull()) {
							System.out.println("\nA pilha está 'CHEIA'");
						} else {
							System.out
									.println("\nA pilha ainda tem 'ESPAÇO DISPONÍVEL'");
						}
					} else if (opcao2 == 4) {
						System.out.println("O tamanho da pilha é: " + 10);
					} else if (opcao2 == 5) {
						stack.top();

					} else if (opcao2 == 6) {
						stack.clear();
						System.out.println("Pilha esvaziada");
					} else if (opcao2 == 7) {
						System.out.println("==PILHA==");
						stack.print();
					}

				} while (opcao2 != 8);
				System.out.println(" SAINDO....");

			} else {
				char valor2;
				System.out.println("Digite o tamanho do vetor: ");
				int tamanho = entrada.nextInt();
				MyStack stack = new MyStack(tamanho);
				do {

					System.out.println("Escolha uma opcao: ");
					System.out.println("1. Inserir um elemento na pilha");
					System.out.println("2. Remover um elemento na pilha");
					System.out.println("3. Verificar situação da pilha");
					System.out.println("4. Mostrar o tamanho da pilha");
					System.out
							.println("5. Mostrar o elemento do topo da pilha");
					System.out.println("6. Esvaziar a pilha");
					System.out.println("7. Imprimir a pilha");
					System.out.println("8. Sair");
					opcao2 = entrada.nextInt();

					if (opcao2 == 1) {

						try {
							System.out
									.println("Digite o número a ser 'INSERIDO' na pilha: ");
							valor2 = entrada.next().charAt(0);// get
																// character/element
																// index 0
																// (char)
							stack.push(valor2);

						} catch (OverflowException e) {// exceção
							System.err.println(e.getMessage());

						}

					} else if (opcao2 == 2) {
						try {
							System.out.println("'REMOVENDO' número na pilha: ");

							stack.pop();// método que remove o elemento do topo
										// da
										// pilha
						} catch (UnderflowException e) {// exceção
							System.out.println(e.getMessage());
						}
					} else if (opcao2 == 3) {
						if (stack.isEmpty()) {
							System.out.println("\nA pilha está 'VAZIA'");
						} else if (stack.isFull()) {
							System.out.println("\nA pilha está 'CHEIA'");
						} else {
							System.out
									.println("\nA pilha ainda tem 'ESPAÇO DISPONÍVEL'");
						}
					} else if (opcao2 == 4) {
						stack.size();
					} else if (opcao2 == 5) {
						stack.top();

					} else if (opcao2 == 6) {
						stack.clear();
						System.out.println("Pilha esvaziada");
					} else if (opcao2 == 7) {
						System.out.println("==PILHA==");

						stack.print();

					}

				} while (opcao2 != 8);
				System.out.println(" SAINDO....");

			}
		}else{
			System.out.println("Saindo...");
		}
	}
}
