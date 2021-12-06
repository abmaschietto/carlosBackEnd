package br.com.artucrop.backendcarlos.entities;

import static javax.persistence.GenerationType.AUTO;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "dev_languages", joinColumns =
	@JoinColumn(name = "LANGUAGE_ID"), 
	inverseJoinColumns = @JoinColumn(name = "DEVELOPER_ID"))
	private List<LanguageEntitiy> languages;

	public DevEntity(DevDto dto) {
		this.languages = dto.getLanguages().stream().map(LanguageEntitiy::new).collect(Collectors.toList());
		this.name = dto.getName();
		if (dto.getId() != null) {
			this.id = dto.getId();
		}
	}

	public void updateDevReference(DevDto dto, Long id) {
		this.languages = dto.getLanguages().stream().map(LanguageEntitiy::new).collect(Collectors.toList());
		this.name = dto.getName();
		this.id = id;
	}
}
