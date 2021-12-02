package br.com.artucrop.backendcarlos.dto;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.List;

import org.springframework.http.HttpStatus;


import lombok.Getter;
import lombok.ToString;

@ToString
public class ErrorHandlerDto {
	
	@Getter
	private String errorMessage;
	@Getter
	private HttpStatus statusHttp;
	@Getter
	private String errorUri;
	@Getter
	private List<FormularioHandlerDto> listaErrosFormulario;
	
	//construtor padrão
	public ErrorHandlerDto(String errorMessage, String errorUri) {
		this.errorMessage = errorMessage;
		this.errorUri = errorUri;
		this.statusHttp = BAD_REQUEST;
	}
	
	//construtor para erros de formulário
	public ErrorHandlerDto(String errorMessage, String errorUri, List<FormularioHandlerDto> errosFormulario) {
		this.errorMessage = errorMessage;
		this.errorUri = errorUri;
		this.statusHttp = BAD_REQUEST;
		this.listaErrosFormulario = errosFormulario;
	}
}