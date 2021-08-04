package ciello.arsenal.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ciello.arsenal.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException error, HttpServletRequest httpServletRequest) {
		var errorMsg = "Resource not found.";
		var httpStatus = HttpStatus.NOT_FOUND;
		var standError = new StandardError(Instant.now(), httpStatus.value(), errorMsg, error.getMessage(), httpServletRequest.getRequestURI());
		return ResponseEntity.status(httpStatus).body(standError);
	}
}
