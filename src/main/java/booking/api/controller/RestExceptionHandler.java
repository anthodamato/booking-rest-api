package booking.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	@SuppressWarnings("unused")
	private Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<RestResponse> illegalArgument(IllegalArgumentException e) {
		RestResponse restResponse = new RestResponse();
		restResponse.setMessage(e.getMessage());
		restResponse.setStatus(ResponseType.ERROR.getStatus());
		return new ResponseEntity<RestResponse>(restResponse, HttpStatus.OK);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<RestResponse> validationError(MethodArgumentNotValidException e) {
		RestResponse restResponse = new RestResponse();
		restResponse.setMessage(e.getMessage());
		restResponse.setStatus(ResponseType.ERROR.getStatus());
		return new ResponseEntity<RestResponse>(restResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RestResponse> internalError(Exception e) {
		LOG.error("Exception message: {}", e.getMessage());
		RestResponse restResponse = new RestResponse();
		restResponse.setMessage(e.getMessage());
		restResponse.setStatus(ResponseType.ERROR.getStatus());
		return new ResponseEntity<RestResponse>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
