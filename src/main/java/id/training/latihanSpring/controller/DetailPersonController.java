package id.training.latihanSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.training.latihanSpring.dto.DetailPersonDto;
import id.training.latihanSpring.entity.DetailPersonEntity;
import id.training.latihanSpring.repository.DetailPersonRepository;

@RestController
@RequestMapping("/detail-person")
public class DetailPersonController {
	@Autowired
	DetailPersonRepository detailPersonRepository;
	
	@GetMapping("/get-detail-all")
	public List<DetailPersonEntity> getDetail(){
		List<DetailPersonEntity> detailPersonEntities = detailPersonRepository.findAll();
		return detailPersonEntities;
	}
	
	@PostMapping("/post-detail-person")
	public ResponseEntity<?> insertDetail(@RequestBody DetailPersonDto dPDto){
		DetailPersonEntity detailPersonEntity = new DetailPersonEntity();
		detailPersonEntity.setDomisili(dPDto.getDomisili());
		detailPersonEntity.setUsia(dPDto.getUsia());
		detailPersonEntity.setTanggalLahir(dPDto.getTanggalLahir());
		detailPersonEntity.setHobi(dPDto.getHobi());
		detailPersonEntity.setJenisKelamin(dPDto.getJenisKelamin());
		detailPersonRepository.save(detailPersonEntity);
		return ResponseEntity.ok(detailPersonEntity);
	}
}
