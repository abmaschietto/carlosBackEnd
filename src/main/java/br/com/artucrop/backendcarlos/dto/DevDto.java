package br.com.artucrop.backendcarlos.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.artucrop.backendcarlos.entities.DevEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DevDto {
	
	private Long id;
	
	@NotEmpty
	@Length(min = 3, max = 45)
	private String name;
	
	@NotEmpty
	private List<LanguageDto> languages;
	
	public DevDto(DevEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.languages = entity.getLanguages().stream().map(LanguageDto::new).collect(Collectors.toList());
	}

}
