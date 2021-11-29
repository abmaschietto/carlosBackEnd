package br.com.artucrop.backendcarlos.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DevDto {
	
	@NotEmpty
	@Length(min = 3, max = 15)
	private String nome;
	
	@NotEmpty
	private List<LanguageDto> linguagens = new ArrayList<LanguageDto>();

}
