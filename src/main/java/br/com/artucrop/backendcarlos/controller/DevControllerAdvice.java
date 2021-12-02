package br.com.artucrop.backendcarlos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.artucrop.backendcarlos.dto.ErrorHandlerDto;
import br.com.artucrop.backendcarlos.dto.FormularioHandlerDto;
import br.com.artucrop.backendcarlos.exceptions.InvalidInformationException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class DevControllerAdvice {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(InvalidInformationException.class)
	public ResponseEntity<ErrorHandlerDto> invalidInfo(InvalidInformationException ex, HttpServletRequest request) {
		log.error(ex.getMessage());
		return ResponseEntity.badRequest().body(new ErrorHandlerDto(ex.getMessage(), request.getRequestURI()));
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorHandlerDto> invalidFormHandler(MethodArgumentNotValidException ex, HttpServletRequest request) {
		log.error(ex.getMessage());
		List<FormularioHandlerDto> listErrors = listOfErrorsBuilder(ex);
		return ResponseEntity.badRequest().body(new ErrorHandlerDto("Formulário foi preenchido com os seguintes erros:", request.getRequestURI(), listErrors));
}


	private List<FormularioHandlerDto> listOfErrorsBuilder(MethodArgumentNotValidException ex) {
		List<FormularioHandlerDto> listErrors = new ArrayList<>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		fieldErrors.forEach(error -> {
			String field = error.getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			FormularioHandlerDto formularioErrorHandlerDto = new FormularioHandlerDto(field, message);
			listErrors.add(formularioErrorHandlerDto);
		});
		return listErrors;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorHandlerDto> invalidInfo(Exception ex, HttpServletRequest request) {
		log.error(ex.getMessage());
		return ResponseEntity.badRequest().body(new ErrorHandlerDto(ex.getMessage(), request.getRequestURI()));
	}


}