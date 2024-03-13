package com.Matheusgabriel1234.workshop.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.Matheusgabriel1234.workshop.services.exception.ObjectNotFoundException;



@ControllerAdvice
public class ResourceExceptionHandle {
	@ExceptionHandler(ObjectNotFoundException.class)
public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest req){
	HttpStatus status = HttpStatus.NOT_FOUND;
	StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Objeto não encontrado",e.getMessage(),req.getRequestURI());
  return ResponseEntity.status(status).body(err);
} 
}

