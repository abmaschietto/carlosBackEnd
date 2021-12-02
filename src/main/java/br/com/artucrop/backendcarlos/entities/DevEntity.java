package br.com.artucrop.backendcarlos.entities;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.artucrop.backendcarlos.dto.DevDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEVELOPERS")
@Data
@NoArgsConstructor
public class DevEntity {
	
	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "DEVELOPER_ID")
	private Long id;
	
	@Column(name = "DEVELOPER_NAME")
	private String name;
	
	@ManyToMany(fetch = EAGER)
	@JoinColumn(name = "DEVELOPER_FAV_LANGUAGES")
	private List<LanguageEntitiy> languages;
	
	public DevEntity(DevDto dto) {
		this.languages = dto.getLanguages().stream().map(LanguageEntitiy::new).collect(Collectors.toList());
		this.name = dto.getName();
		if(dto.getId() != null) {
			this.id = dto.getId();
		}
	}
	
	public void updateDev(DevDto dto, Long id) {
		this.languages = dto.getLanguages().stream().map(LanguageEntitiy::new).collect(Collectors.toList());
		this.name = dto.getName();
		this.id = id;
	}
}
