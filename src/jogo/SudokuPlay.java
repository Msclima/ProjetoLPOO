package jogo;
import tabuleiro.TabuleiroAbstrato;
import java.util.Scanner;

import exceptions.ElementoInvalidoException;

public class SudokuPlay {

	public static void main(String[] args){
		
		Iniciar9x9 iniciar= new Iniciar9x9();
		IniciarHexa iniciarHexa = new IniciarHexa();
		Iniciar12x12 iniciar12 = new Iniciar12x12();
		
		//iniciar.SudokuPlay();	
		
		//iniciarHexa.SudokuPlay();
		iniciar12.SudokuPlay();
		
		 }
	}

