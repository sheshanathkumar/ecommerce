package com.sk.ecom.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Shesho
 */

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(SearchProductException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<ExceptionDetail> searchProductException(final SearchProductException ex, final HttpServletRequest request) {
		ExceptionDetail er = new ExceptionDetail(""+HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage(),request.getRequestURI());
		return new ResponseEntity<> ( er , HttpStatus.BAD_REQUEST);
	}
	
	
}
