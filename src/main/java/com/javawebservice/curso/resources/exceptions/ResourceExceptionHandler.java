package com.javawebservice.curso.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.javawebservice.curso.services.exceptions.DatabaseException;
import com.javawebservice.curso.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErroModeloDeRespostaPadrao> resourceNotFound(ResourceNotFoundException msg, HttpServletRequest request){
		
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroModeloDeRespostaPadrao erroResposta = new ErroModeloDeRespostaPadrao(Instant.now(), status.value(), erro, msg.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erroResposta);	
	}
	
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<ErroModeloDeRespostaPadrao> database(DatabaseException msg, HttpServletRequest request){
		
		String erro = "Erro na solicitação ao Banco de Dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroModeloDeRespostaPadrao erroResposta = new ErroModeloDeRespostaPadrao(Instant.now(), status.value(), erro, msg.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erroResposta);	
	}
}
