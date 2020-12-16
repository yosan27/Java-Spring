package id.training.latihanSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.training.latihanSpring.dto.PendidikanDto;
import id.training.latihanSpring.entity.PendidikanEntity;
import id.training.latihanSpring.entity.PersonEntity;
import id.training.latihanSpring.repository.PendidikanRepository;
import id.training.latihanSpring.repository.PersonRepository;

@RestController
@RequestMapping("/pendidikan")
public class PendidikanController {
	@Autowired
	PendidikanRepository pendidikanRepository;
	
	@Autowired
	PersonRepository personRepository;
	
//	Read
	@GetMapping("/get-pendidikan-all")
	public ResponseEntity<?> getPendidikan(){
		List<PendidikanEntity> pendidikanEntities = pendidikanRepository.findAll();
		return ResponseEntity.ok(pendidikanEntities);
	}
	
//	Create
	@PostMapping("/post-pendidikan")
	public ResponseEntity<?> insertPendidikan(@RequestBody PendidikanDto dto){
		PendidikanEntity pendidikanEntity = new PendidikanEntity();
		PersonEntity personEntity = personRepository.findById(dto.getPersonId()).get();
		pendidikanEntity.setLevel(dto.getLevel());
		pendidikanEntity.setInstitusi(dto.getInstitusi());
		pendidikanEntity.setTahunMasuk(dto.getTahunMasuk());
		pendidikanEntity.setTahunLulus(dto.getTahunLulus());
		pendidikanEntity.setPersonEntity(personEntity);
		pendidikanRepository.save(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
	}
	
//	Update
	@PutMapping("/put-pendidikan/{id}")
	public ResponseEntity<?> updatePendidikan(@PathVariable Integer id, @RequestBody PendidikanDto dto){
		PendidikanEntity pendidikanEntity = pendidikanRepository.findById(id).get();
		pendidikanEntity.setLevel(dto.getLevel());
		pendidikanEntity.setInstitusi(dto.getInstitusi());
		pendidikanEntity.setTahunMasuk(dto.getTahunMasuk());
		pendidikanEntity.setTahunLulus(dto.getTahunLulus());
		pendidikanRepository.save(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
	}
	
//	Delete
	@DeleteMapping("/delete-pendidikan/{id}")
	public ResponseEntity<?> updatePendidikan(@PathVariable Integer id){
		PendidikanEntity pendidikanEntity = pendidikanRepository.findById(id).get();
		pendidikanRepository.delete(pendidikanEntity);
		return ResponseEntity.ok(pendidikanEntity);
	}
}
