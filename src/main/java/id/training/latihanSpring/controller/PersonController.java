package id.training.latihanSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.training.latihanSpring.dto.PersonDto;
import id.training.latihanSpring.entity.PersonEntity;
import id.training.latihanSpring.repository.PersonRepository;

@RestController
@RequestMapping("/person") //localhost:8500/person
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/get-all") //localhost:8500/person//get-all
	public List<PersonEntity> getPerson(){
		List<PersonEntity> personEntities = personRepository.findAll();
//		personEntities = PersonRepository.findByFirstName("namanya");
		return personEntities;
	}
	
	@GetMapping("/respon-entity")
	public ResponseEntity<?> getAll(){
		List<PersonEntity> personEntities = personRepository.findAll();
		return ResponseEntity.ok(personEntities);
	}
	
	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody PersonDto dto){
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
}
