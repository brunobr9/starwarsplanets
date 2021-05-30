package com.bruno.starwars.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bruno.starwars.service.exception.ObjectNotFoundException;
import com.bruno.starwars.service.exception.ServiceException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ResourceError> handleObjectNotFoundException(ObjectNotFoundException ex,
			HttpServletRequest request) {
		return handlerError(ex, HttpStatus.NOT_FOUND.value());
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ResourceError> handleObjectNotFoundException(ServiceException ex,
			HttpServletRequest request) {
		return handlerError(ex, HttpStatus.BAD_REQUEST.value());
	}

	private ResponseEntity<ResourceError> handlerError(ServiceException ex, Integer httpStatus) {
		return ResponseEntity.status(httpStatus).body(new ResourceError(httpStatus, ex.getMessage()));
	}

}
