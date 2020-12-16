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

import id.training.latihanSpring.dto.BiodataDto;
import id.training.latihanSpring.dto.PersonDto;
import id.training.latihanSpring.entity.DetailPersonEntity;
import id.training.latihanSpring.entity.PersonEntity;
import id.training.latihanSpring.repository.DetailPersonRepository;
import id.training.latihanSpring.repository.PersonRepository;

@RestController
@RequestMapping("/person") //localhost:8500/person
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	DetailPersonRepository detailPersonRepository;
	
//	Read
	@GetMapping("/get-all") //localhost:8500/person//get-all
	public List<PersonEntity> getPerson(){
		List<PersonEntity> personEntities = personRepository.findAll();
		return personEntities;
	}
	
	@GetMapping("/respon-entity")
	public ResponseEntity<?> getAll(){
		List<PersonEntity> personEntities = personRepository.findAll();
		return ResponseEntity.ok(personEntities);
	}
	
	@GetMapping("/get-name-by-id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		PersonDto dto = new PersonDto();
		dto.setFirstName(personRepository.findFirstNameById(id));
		dto.setMessage("Data Berhasil Diambil!");
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/get-name-by-fname/{firstName}")
	public ResponseEntity<?> getByFirstName(@PathVariable String firstName){
		List<PersonEntity> personEntities = personRepository.findByLastName(firstName);
		PersonDto dto = new PersonDto();
		dto.setFirstName(personEntities.get(0).getFirstName());
		return ResponseEntity.ok(dto.getFirstName());
	}
	
	@GetMapping("/get-name-by-lname/{ln}")
	public ResponseEntity<?> getByLastName(@PathVariable String ln){
		List<PersonEntity> personEntities = personRepository.findByLastName(ln);
		return ResponseEntity.ok(personEntities);
	}
	
	
//	Create
	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody BiodataDto dto){
		PersonEntity personEntity = convertToPersonEntity(dto);
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	@PostMapping("/post-register")
	public ResponseEntity<?> insertAll(@RequestBody BiodataDto dto){
		PersonEntity personEntity = convertToPersonEntity(dto);
		DetailPersonEntity detailPersonEntity = convertToDetailEntity(dto);
		detailPersonEntity.setPersonEntity(personEntity);
		personRepository.save(personEntity);
		detailPersonRepository.save(detailPersonEntity);
		return ResponseEntity.ok(detailPersonEntity);
	}
	
	
//	Update
	@PutMapping("/put-person/{id}")
	public ResponseEntity<?> updatePerson(@RequestBody PersonDto dto, @PathVariable Integer id){
		PersonEntity personEntity = personRepository.findById(id).get();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	
//	Delete
	@DeleteMapping("/delete-person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable Integer id){
		PersonEntity personEntity = personRepository.findById(id).get();
		personRepository.delete(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	
//	Method Convert
	public PersonEntity convertToPersonEntity(BiodataDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		return personEntity;
	}
	
	public DetailPersonEntity convertToDetailEntity(BiodataDto dto) {
		DetailPersonEntity detailPersonEntity = new DetailPersonEntity();
		detailPersonEntity.setDomisili(dto.getDomisili());
		detailPersonEntity.setUsia(dto.getUsia());
		detailPersonEntity.setTanggalLahir(dto.getTanggalLahir());
		detailPersonEntity.setHobi(dto.getHobi());
		detailPersonEntity.setJenisKelamin(dto.getJenisKelamin());
		return detailPersonEntity;
	}
	
}
