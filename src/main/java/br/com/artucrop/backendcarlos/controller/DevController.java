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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API com crud básico para controle de devs")
@RestController
@RequestMapping(value = "/v1/devs")
@CrossOrigin(origins = "*")
public class DevController {
	
	@Autowired
	private DevService devService;
	
	@ApiOperation(value = "Busca todos os devs")
	@GetMapping(value = "/allDevs")
	public ResponseEntity<List<DevDto>> getAllDevs(){
		List<DevDto> allDevs = devService.getAllDevs();
		return ResponseEntity.ok(allDevs);
	}
	
	@ApiOperation(value = "Busca um dev por id")
	@GetMapping(value = "/devId/{id}")
	public ResponseEntity<DevDto> findDev(@PathVariable Long id){
		DevDto devDto = devService.findOneDev(id);
		return ResponseEntity.ok(devDto);
	}
	
	@ApiOperation("Salva um dev")
	@PostMapping(value = "/saveDev")
	public ResponseEntity<DevDto> saveDev(@RequestBody @Valid DevDto dev){
		DevDto savedDev = devService.saveDev(dev);
		return ResponseEntity.ok(savedDev);
	}
	
	@ApiOperation(value = "Atualiza um dev")
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<DevDto> updateDev(@PathVariable Long id, @RequestBody @Valid DevDto dev){
		DevDto updatedDev = devService.updateDev(id, dev);
		return ResponseEntity.ok(updatedDev);
	}
	
	@ApiOperation(value = "Deleta um dev")
	@DeleteMapping(value = "/deleteDev")
	public ResponseEntity<String> deleteDev(@RequestBody @Valid DevDto dev){
		String deletedDev = devService.deleteDev(dev);
		return ResponseEntity.ok(deletedDev);
	}
	
	@ApiOperation(value = "Deleta um dev pelo id")
	@DeleteMapping(value = "/deleteDev/{id}")
	public ResponseEntity<String> deleteDev(@PathVariable Long id){
		String deletedDev = devService.deleteById(id);
		return ResponseEntity.ok(deletedDev);
	}

}
