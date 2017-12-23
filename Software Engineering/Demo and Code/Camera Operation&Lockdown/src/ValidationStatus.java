
public class ValidationStatus {
	
	boolean Validation;
	String Message;
	String Source;
	public ValidationStatus(boolean validation, String message, String source) {
		super();
		Validation = validation;
		Message = message;
		Source = source;
	}
	public boolean isValidation() {
		return Validation;
	}
	public void setValidation(boolean validation) {
		Validation = validation;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	} 
}
