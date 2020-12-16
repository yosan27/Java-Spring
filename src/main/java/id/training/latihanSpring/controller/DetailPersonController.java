package id.training.latihanSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.training.latihanSpring.dto.BiodataDto;
import id.training.latihanSpring.entity.DetailPersonEntity;
import id.training.latihanSpring.entity.PersonEntity;
import id.training.latihanSpring.repository.DetailPersonRepository;
import id.training.latihanSpring.repository.PersonRepository;

@RestController
@RequestMapping("/detail-person")
public class DetailPersonController {
	@Autowired
	DetailPersonRepository detailPersonRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/get-detail-all")
	public List<DetailPersonEntity> getDetail(){
		List<DetailPersonEntity> detailPersonEntities = detailPersonRepository.findAll();
		return detailPersonEntities;
	}
	
	@PostMapping("/post-detail")
	public ResponseEntity<?> postDetail(@RequestBody BiodataDto dto){
		DetailPersonEntity detailPersonEntity = convertToDetailEntity(dto);
		detailPersonRepository.save(detailPersonEntity);
		return ResponseEntity.ok(detailPersonEntity);
	}
	
//	Buat detail person berdasarkan id person
	@PostMapping("/post-detail-person")
	public ResponseEntity<?> insertDetail(@RequestBody BiodataDto dto){
		DetailPersonEntity detailPersonEntity = convertToDetailEntity(dto);
		PersonEntity personEntity = personRepository.findById(dto.getPersonId()).get();
		detailPersonEntity.setPersonEntity(personEntity);
		detailPersonRepository.save(detailPersonEntity);
		return ResponseEntity.ok(detailPersonEntity);
	}
	
//	Method
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
