package br.com.artucrop.backendcarlos.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LanguageDto {
	
	@NotEmpty
	@Length(min = 1)
	private String nome;
	

}
