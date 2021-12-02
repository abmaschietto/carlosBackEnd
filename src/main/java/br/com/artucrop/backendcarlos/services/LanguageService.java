package br.com.artucrop.backendcarlos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.artucrop.backendcarlos.entities.DevEntity;
import br.com.artucrop.backendcarlos.entities.LanguageEntitiy;
import br.com.artucrop.backendcarlos.repository.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository languageRepository;
	
	public void linkLanguageToDev(DevEntity dev, List<LanguageEntitiy> list) {
//		list.forEach(language ->{
//			language.setDev(dev);
//			languageRepository.save(language);
//		});
//		System.out.println();
	}
	

}
