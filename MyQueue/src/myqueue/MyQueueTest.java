package myqueue;

import java.util.Scanner;

public class MyQueueTest {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Deseja usar o tamanho padrao do vetor? ");
        System.out.println("1. Sim");
        System.out.println("2. Nao");

        int opcao = entrada.nextInt();
        int opcao2;
        if (opcao == 1) {

            MyQueue Queue = new MyQueue(2);// valor padrao da fila
            int valor;
            do {

                System.out.println("Escolha uma opcao: ");
                System.out.println("1. Inserir um elemento na fila");
                System.out.println("2. Remover um elemento na fila");
                System.out.println("3. Verificar situaÃƒÂ§ÃƒÂ£o da fila");
                System.out.println("4. Mostrar o tamanho da fila");
                System.out.println("5. Mostrar o elemento do topo da fila");
                System.out.println("6. Esvaziar a fila");
                System.out.println("7. Imprimir a fila");
                System.out.println("8. Sair");
                opcao2 = entrada.nextInt();

                if (opcao2 == 1) {

                    try {
                        System.out.println("Digite o numero a ser 'INSERIDO' na pilha: ");
                        valor = entrada.nextInt();

                        Queue.enqueue(valor);

                    } catch (ArrayIndexOutOfBoundsException e) {//excecao StackOverflow
                        Queue.isFull();
                        System.out.println("\nao foi possivel 'ADICIONAR' o numero na pilha, ERRO: 'QueueOverflow'" + e);
                        System.out.println("");
                    }

                } else if (opcao2 == 2) {

                    try {
                        System.out.println("'REMOVENDO' numero na pilha: ");

                        Queue.dequeue();// mÃƒÂ©todo que remove o elemento do topo da
                        // fila
                    } catch (ArrayIndexOutOfBoundsException e) {// exceÃƒÂ§ÃƒÂ£o
                        // StackUnderflow
                        Queue.isEmpty();
                        System.out
                                .println("\nNaoo foi possivel REMOVER o numero na pilha, ERRO: 'QueueUnderflow'"
                                        + e);
                        System.out.println("");
                    }

                } else if (opcao2 == 3) {
                    if (Queue.isEmpty()) {
                        System.out.println("\nA fila esta 'VAZIA'");
                    } else if (Queue.isFull()) {
                        System.out.println("\nA fila esta 'CHEIA'");
                    } else {
                        System.out.println("\nA fila ainda tem 'ESPACO DISPONIVEL'");
                    }
                } else if (opcao2 == 4) {
                    System.out.println("O tamanho da fila e: " + 10);
                } else if (opcao2 == 5) {
                    Queue.back();
                } else if (opcao2 == 6) {
                    Queue.clear();
                } else if (opcao2 == 7) {
                    System.out.println("==FILA==");

                    Queue.print();
                }

            } while (opcao2 != 8);
            System.out.println(" SAINDO....");

        } else {
            int valor2;
            System.out.println("Digite o tamanho da fila: ");
            int tamanho = entrada.nextInt();
            MyQueue Queue = new MyQueue(tamanho);
            do {

                System.out.println("Escolha uma opcao: ");
                System.out.println("1. Inserir um elemento na fila");
                System.out.println("2. Remover um elemento na fila");
                System.out.println("3. Verificar situaÃƒÂ§ÃƒÂ£o da fila");
                System.out.println("4. Mostrar o tamanho da fila");
                System.out.println("5. Mostrar o elemento do topo da fila");
                System.out.println("6. Esvaziar a fila");
                System.out.println("7. Imprimir a fila");
                System.out.println("8. Sair");
                opcao2 = entrada.nextInt();

                if (opcao2 == 1) {
                    try {
                        System.out.println("Digite o numero a ser 'INSERIDO' na pilha: ");
                        valor2 = entrada.nextInt();

                        Queue.enqueue(valor2);

                    } catch (ArrayIndexOutOfBoundsException e) {//excecao StackOverflow
                        Queue.isFull();
                        System.out.println("\n Nao foi possivel 'ADICIONAR' o numero na pilha, ERRO: 'QueueUnderflow'" + e);
                        System.out.println("");
                    }

                } else if (opcao2 == 2) {
                    try {
                        System.out.println("'REMOVENDO' numero na pilha: ");

                        Queue.dequeue();// mÃƒÂ©todo que remove o elemento do topo da
                        // fila
                    } catch (ArrayIndexOutOfBoundsException e) {// exceÃƒÂ§ÃƒÂ£o
                        // StackUnderflow
                        Queue.isEmpty();
                        System.out
                                .println("\nNÃƒÂ£o foi possÃƒÂ­vel REMOVER o numero na pilha, ERRO: 'QueueUnderflow'"
                                        + e);
                        System.out.println("");
                    }
                } else if (opcao2 == 3) {
                    if (Queue.isEmpty()) {
                        System.out.println("\nA fila esta 'VAZIA'");
                    } else if (Queue.isFull()) {
                        System.out.println("\nA fila esta 'CHEIA'");
                    } else {
                        System.out.println("\nA fila ainda tem 'ESPACO DISPONIVEL'");
                    }
                } else if (opcao2 == 4) {
                    System.out.println("O tamanho  da fila e: " + tamanho);
                    System.out.println("A quantidade de elementos da fila e: " + Queue.size());
                } else if (opcao2 == 5) {
                    Queue.back();
                } else if (opcao2 == 6) {
                    Queue.clear();
                } else if (opcao2 == 7) {
                    System.out.println("==FILA==");

                    Queue.print();
                }

            } while (opcao2 != 8);
            System.out.println(" SAINDO....");

        }
    }
}
