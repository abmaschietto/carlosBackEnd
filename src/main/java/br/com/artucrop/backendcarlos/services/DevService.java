package br.com.artucrop.backendcarlos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artucrop.backendcarlos.dto.DevDto;
import br.com.artucrop.backendcarlos.repository.DevRepository;

@Service
public class DevService {
	
	@Autowired
	private DevRepository devRepository;
	
	public List<DevDto> getAllDevs(){
		return null;
	}
	
	public DevDto saveDev(DevDto dto) {
		return null;
	}
	
	public DevDto findOneDev(Long id) {
		return null;
	}
	
	public DevDto deleteDev(Long id) {
		return null;
	}

}
