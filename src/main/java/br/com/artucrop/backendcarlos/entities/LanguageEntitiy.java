package br.com.artucrop.backendcarlos.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.artucrop.backendcarlos.dto.LanguageDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LINGUAGENS")
@Data
@NoArgsConstructor
public class LanguageEntitiy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LANGUAGE_ID")
	private Long id;
	
	@Column(name = "LANGUAGE_NAME")
	private String name;
	
	@ManyToMany(mappedBy = "languages")
	private List<DevEntity> dev;
	
	
	public LanguageEntitiy(LanguageDto dto) {
		this.name = dto.getName();
		if(dto.getId() != null) {
			this.id = dto.getId();
		}
	}
	

}
