package estruturadados;

public class UnderflowException extends Exception{

	public UnderflowException() {
		super("Underflow");
	}
	
	@Override
	public String getMessage() {
		return "Underflow";
	}
}
