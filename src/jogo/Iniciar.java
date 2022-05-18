package jogo;


import java.util.Scanner;

import exceptions.AtributoInvalidoException;
import tabuleiro.Tabuleiro;
import tabuleiro.Tabuleiro9x9;
import tabuleiro.Tabuleiro12x12;
import tabuleiro.TabuleiroHexadecimal;

public class Iniciar {
	private Tabuleiro tabuleiro;

	Scanner scan = new Scanner(System.in);
	int linha,coluna, ajuda, escolha;
	String numero;

	public Iniciar() {
		escolherTabuleiro();
		iniciarTabuleiro();
		comecarJogo();
	}

	
	private void iniciarTabuleiro() {
		tabuleiro.zerarString(tabuleiro.getTabuleiroGabarito(), "0");
		tabuleiro.zerarString(tabuleiro.getErrosEspaço(), " ");
		tabuleiro.randomTabuleiro(tabuleiro.getTabuleiroGabarito(), tabuleiro.getElementosDisponiveis());
		tabuleiro.copiarTabuleiro(tabuleiro.getTabuleiroGabarito(), tabuleiro.getTabuleiroCompletavel());
		//tabuleiro.mostrarTabuleiro(tabuleiro.getTabuleiroGabarito());
		tabuleiro.ocultandoTabuleiro(tabuleiro.getTabuleiroCompletavel());
		tabuleiro.mostrarTabuleiro(tabuleiro.getTabuleiroCompletavel());
		tabuleiro.zerarString(tabuleiro.getErrosEspaço(), " ");
		
		
	}
	
	private void escolherTabuleiro() {
		System.out.println("qual Sudoku?");
		escolha = scan.nextInt();
		switch(escolha) {
		case 1:
			tabuleiro = new Tabuleiro9x9();
			
			break;

		case 2: 
			tabuleiro = new Tabuleiro12x12();
		
			break;
			
		case 3:
			tabuleiro = new TabuleiroHexadecimal();
			
			break;
		}
	}
	
	
	private void comecarJogo() {
		
		while(!tabuleiro.ehTabuleirosIguais()) {
			
			System.out.println("Digite a linha:");
			linha = scan.nextInt();
			System.out.println("Digite a coluna:");
			coluna = scan.nextInt();

			if(tabuleiro.espaçoValido(linha, coluna)) {
				System.out.println("Vai querer ajuda? (0/1) ");
				ajuda = scan.nextInt();
				if(ajuda == 1) {
					tabuleiro.botaoAjuda(linha, coluna, tabuleiro.getElementosDisponiveis());
				}else{
					System.out.println("Digite um numero:");
					numero = scan.next().substring(0, 1);
					try {
						tabuleiro.jogada(linha, coluna, numero, tabuleiro.getTabuleiroCompletavel(), tabuleiro.getElementosDisponiveis());
					}catch(AtributoInvalidoException e) {
						System.out.println(e.getMessage());
					}

				}
			}else System.out.println("espaço invalido");
		}
		System.out.println("parabens");
	}




}


