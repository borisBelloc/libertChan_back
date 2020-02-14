package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends Exception {
	
	

		private static final long serialVersionUID = -710350638712688312L;

		public AlreadyExistsException(String message) {
			super(message);
		}

}
