package br.com.artucrop.backendcarlos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	public LanguageEntitiy(LanguageDto dto) {
		this.setName(dto.getNome());
	}
	

}
