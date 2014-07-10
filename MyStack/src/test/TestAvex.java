package test;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturadados.AVEX;
import estruturadados.MyStack;
import estruturadados.OverflowException;
import estruturadados.UnderflowException;
import java.util.Scanner;

public class TestAvex {

	@Test
	public void testAvalPosfixa() throws OverflowException, UnderflowException {
		
		System.out.print("Digite a quantidade de 'DÍGITOS' da sua expressao: ");
		Scanner entrada1 = new Scanner(System.in);
		int expressionsize = entrada1.nextInt();
		
		MyStack<String> infixa = new MyStack<String>(expressionsize); //pilha que armazena a forma infixa da expressao
		MyStack<String> posfixa1 = new MyStack<String>(expressionsize); //pilha que armazena a pilha na forma posfixa
		Scanner entrada = new Scanner(System.in);
		String[] expressao = new String[expressionsize];//string armazenar valores do usuario
		 
		for (int i = 0; i < expressao.length; i++) {//inserindo valores da expressao na pilha
			System.out.print("["+i+"]= ");
			infixa.push(entrada.nextLine());
		}
		
		AVEX avex = new AVEX();
		posfixa1 = avex.infxPsfx(infixa);//convertendo infixa para posfixa
		System.out.println("\nResultado da expressao: "+ avex.AvalPosfixa(posfixa1));//calculando o valor da expressao posfixa
		

		//TESTAR PREVALENCIA DOS SINAIS
		//AVEX avex = new AVEX();
		//System.out.println(avex.prcd("+", "/"));
	}
}
