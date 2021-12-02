package br.com.artucrop.backendcarlos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.artucrop.backendcarlos.dto.DevDto;
import br.com.artucrop.backendcarlos.services.DevService;

@RestController
@RequestMapping(value = "/v1/devs")
@CrossOrigin(origins = "*")
public class DevController {
	
	@Autowired
	private DevService devService;
	
	@GetMapping(value = "/allDevs")
	public ResponseEntity<List<DevDto>> getAllDevs(){
		List<DevDto> allDevs = devService.getAllDevs();
		return ResponseEntity.ok(allDevs);
	}
	
	@GetMapping(value = "/devId/{id}")
	public ResponseEntity<DevDto> findDev(@PathVariable Long id){
		DevDto devDto = devService.findOneDev(id);
		return ResponseEntity.ok(devDto);
	}
	
	@PostMapping(value = "/saveDev")
	public ResponseEntity<DevDto> saveDev(@RequestBody @Valid DevDto dev){
		DevDto savedDev = devService.saveDev(dev);
		return ResponseEntity.ok(savedDev);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<DevDto> updateDev(@PathVariable Long id, @RequestBody @Valid DevDto dev){
		DevDto updatedDev = devService.updateDev(id, dev);
		return ResponseEntity.ok(updatedDev);
	}
	
	@DeleteMapping(value = "/deleteDev")
	public ResponseEntity<String> deleteDev(@RequestBody @Valid DevDto dev){
		String deletedDev = devService.deleteDev(dev);
		return ResponseEntity.ok(deletedDev);
	}

}
