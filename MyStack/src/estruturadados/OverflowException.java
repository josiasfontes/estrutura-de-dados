package estruturadados;

public class OverflowException extends Exception {
	public OverflowException() {	
		super();
	}
	
	@Override
	public String getMessage() {
		return "Nao foi possivel inserir o elemento 'Overflow'";
	}
}
