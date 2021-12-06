package br.com.artucrop.backendcarlos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artucrop.backendcarlos.dto.DevDto;
import br.com.artucrop.backendcarlos.entities.DevEntity;
import br.com.artucrop.backendcarlos.exceptions.InvalidInformationException;
import br.com.artucrop.backendcarlos.repository.DevRepository;

@Service
public class DevService {
	
	@Autowired
	private DevRepository devRepository;
	
	public List<DevDto> getAllDevs(){
		List<DevEntity> collect = devRepository.findAll();
		return collect.stream().map(DevDto::new).collect(Collectors.toList());
	}
	
	public DevDto saveDev(DevDto dto) {
		DevEntity savedDev = devRepository.save(new DevEntity(dto));
		return new DevDto(savedDev);
	}

	public DevDto findOneDev(Long id) {
		DevEntity devById = devRepository.findById(id).orElseThrow(() ->  new InvalidInformationException("Nenhum dev encontrado com este Id: " + id));
		return new DevDto(devById);
	}
	
	public String deleteDev(DevDto dto) {
		devRepository.delete(new DevEntity(dto));
		return "Dev " + dto.getName() + " deletado com sucesso";
	}

	public String deleteById(long id) {
		DevDto dev = findOneDev(id);
		devRepository.delete(new DevEntity(dev));
		return "Dev " + dev.getName() + " deletado com sucesso";
	}
	
	public DevDto updateDev(Long id, DevDto dto) {
		DevEntity dev = devRepository.findById(id).orElseThrow(() ->  new InvalidInformationException("Nenhum dev encontrado com este Id: " + id));
		dev.updateDevReference(dto, id);
		devRepository.save(dev);
		return new DevDto(dev);
	}


}
