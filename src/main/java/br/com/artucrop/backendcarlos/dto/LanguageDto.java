package br.com.artucrop.backendcarlos.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.artucrop.backendcarlos.entities.LanguageEntitiy;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LanguageDto {
	
	private Long id;
	
	@NotEmpty
	@Length(min = 1)
	private String name;
	
	public LanguageDto(LanguageEntitiy entitiy) {
		this.id = entitiy.getId();
		this.name = entitiy.getName();
	}
	

}
