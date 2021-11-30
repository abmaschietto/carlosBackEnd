package br.com.artucrop.backendcarlos.dto;

import java.util.ArrayList;
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
	@Length(min = 3, max = 15)
	private String name;
	
	@NotEmpty
	private List<LanguageDto> linguagens = new ArrayList<LanguageDto>();
	
	public DevDto(DevEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.linguagens = entity.getLanguages().stream().map(LanguageDto::new).collect(Collectors.toList());
	}

}
