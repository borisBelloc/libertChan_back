package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Object not found")
public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = -8089144995057256430L;

	public NotFoundException(String message) {
		super(message);
	}

}
