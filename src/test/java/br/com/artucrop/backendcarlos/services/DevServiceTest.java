package br.com.artucrop.backendcarlos.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

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
import br.com.artucrop.backendcarlos.entities.DevEntity;
import br.com.artucrop.backendcarlos.entities.LanguageEntitiy;
import br.com.artucrop.backendcarlos.repository.DevRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class DevServiceTest {
	
	@InjectMocks
	DevService devService;
	
	@Mock
	DevRepository devRepository;
	
	//devs
	DevEntity dev1 = new DevEntity();
	DevEntity dev2 = new DevEntity();
	
	//languages
	LanguageEntitiy language1 = new LanguageEntitiy();
	LanguageEntitiy language2 = new LanguageEntitiy();
	LanguageEntitiy language3 = new LanguageEntitiy();
	
	List<DevEntity> devs;
	
	
	@BeforeAll
	void setUpAll() {
		
		//languages
		
		//language1
		language1.setId(1l);
		language1.setName("Java");
		
		//language2
		language2.setId(2l);
		language2.setName("Javascript");
		
		//language3
		language1.setId(3l);
		language1.setName("Python");
		
		//List of languages
		
		List<LanguageEntitiy> languagesArtur = Arrays.asList(language1, language3);
		List<LanguageEntitiy> languagesCarlos = Arrays.asList(language2);
		
		//devs
		
		//setup dev1
		dev1.setId(1l);
		dev1.setName("Artur");
		dev1.setLanguages(languagesArtur);
		
		//setup dev2
		dev1.setId(2l);
		dev1.setName("Carlos");
		dev1.setLanguages(languagesCarlos);
		
		devs = Arrays.asList(dev1, dev2);
		
	}
	

	@BeforeEach
	void setUp() throws Exception {
		Mockito.when(devRepository.findAll()).thenReturn(devs);
	}

	//todo implementar logica
	@Test
	void testGetAllDevs() {
		List<DevDto> allDevs = devService.getAllDevs();
		assertAll("Asserting list of devs return data",
				() -> assertEquals(2, allDevs.size(), "List size is wrong"),
				() -> assertEquals("Artur", allDevs.get(0).getName(), "Name of the first dev is wrong")
		);
			
		
	}

	@Test
	void testSaveDev() {
		fail("Not yet implemented");
	}

	@Test
	void testFindOneDev() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDev() {
		fail("Not yet implemented");
	}

}
