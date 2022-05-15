package tabuleiro;

public class Tabuleiro9x9 extends Tabuleiro {

	private final String[] elementosDisponiveis = {"1","2","3","4","5","6","7","8","9"};
	
	public Tabuleiro9x9() {
		super(3, 3);
		
	}
		
	public String[] getElementosDisponiveis() {
		return elementosDisponiveis;
	}

	
	
	
	
}
