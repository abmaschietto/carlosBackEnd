package br.com.artucrop.backendcarlos.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.artucrop.backendcarlos.dto.DevDto;
import br.com.artucrop.backendcarlos.dto.LanguageDto;
import br.com.artucrop.backendcarlos.entities.DevEntity;
import br.com.artucrop.backendcarlos.entities.LanguageEntitiy;
import br.com.artucrop.backendcarlos.repository.DevRepository;

@ExtendWith(MockitoExtension.class)
class DevServiceTest {

	@InjectMocks
	DevService devService;

	@Mock
	DevRepository devRepository;

	// devs
	DevEntity dev1 = new DevEntity();
	DevEntity dev2 = new DevEntity();
	DevDto devDto = new DevDto();

	// languages
	LanguageEntitiy language1 = new LanguageEntitiy();
	LanguageEntitiy language2 = new LanguageEntitiy();
	LanguageEntitiy language3 = new LanguageEntitiy();

	@BeforeEach
	void setUp() throws Exception {
		// languages

		// language1
		language1.setId(1l);
		language1.setName("Java");

		// language2
		language2.setId(2l);
		language2.setName("Javascript");

		// language3
		language1.setId(3l);
		language1.setName("Python");

		// List of languages

		List<LanguageEntitiy> languagesArtur = Arrays.asList(language1, language3);
		List<LanguageEntitiy> languagesCarlos = Arrays.asList(language2);

		// devs
		
		//setup dev dto
		devDto.setName("Pepe");
		devDto.setLanguages(languagesCarlos.stream().map(LanguageDto::new).collect(Collectors.toList()));

		// setup dev1
		dev1.setId(1l);
		dev1.setName("Artur");
		dev1.setLanguages(languagesArtur);

		// setup dev2
		dev2.setId(2l);
		dev2.setName("Carlos");
		dev2.setLanguages(languagesCarlos);
	}

	@Test
	void testGetAllDevs() {
		when(devRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(dev1, dev2)));
		List<DevDto> allDevs = devService.getAllDevs();
		assertAll("Asserting list of devs return data", 
				() -> assertEquals(2, allDevs.size(), "List size is wrong"),
				() -> assertEquals("Artur", allDevs.get(0).getName(), "Name of the first dev is wrong"));
	}

	@Test
	void testSaveDev() {
		DevEntity devEntity = new DevEntity(devDto);
		when(devRepository.save(devEntity)).thenReturn(devEntity);
		DevDto savedDev = devService.saveDev(devDto);
		assertAll("Asserting saved Dev", 
				() -> assertEquals("Pepe", savedDev.getName(), "Name of the dev is wrong"),
				() -> assertEquals("Javascript", savedDev.getLanguages().get(0).getName(), "Name of the language is wrong"));
	}

	@Test
	void testFindOneDev() {
		when(devRepository.findById(1l)).thenReturn(Optional.of(dev1));
		DevDto findOneDev = devService.findOneDev(1l);
		assertAll("Asserting list of devs return data", 
				() -> assertEquals(2, findOneDev.getLanguages().size(), "List size is wrong"),
				() -> assertEquals("Artur", findOneDev.getName(), "Name of the dev is wrong"));
	}

	@Test
	void testDeleteDev() {
		String deletetDevMessage = devService.deleteDev(devDto);
		assertEquals("Dev " + "Pepe"+ " deletado com sucesso", deletetDevMessage);
		verify(devRepository, atLeast(1)).delete(Mockito.any(DevEntity.class));
	}

}
