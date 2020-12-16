package id.training.latihanSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pendidikan_entity")
public class PendidikanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "institusi")
	private String institusi;
	
	@Column(name = "tahun_masuk")
	private Integer tahunMasuk;
	
	@Column(name = "tahun_lulus")
	private Integer tahunLulus;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	private PersonEntity personEntity;


	public PendidikanEntity(Integer id, String level, String institusi, Integer tahunMasuk, Integer tahunLulus,
			PersonEntity personEntity) {
		super();
		this.id = id;
		this.level = level;
		this.institusi = institusi;
		this.tahunMasuk = tahunMasuk;
		this.tahunLulus = tahunLulus;
		this.personEntity = personEntity;
	}


	public PendidikanEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getInstitusi() {
		return institusi;
	}


	public void setInstitusi(String institusi) {
		this.institusi = institusi;
	}


	public Integer getTahunMasuk() {
		return tahunMasuk;
	}


	public void setTahunMasuk(Integer tahunMasuk) {
		this.tahunMasuk = tahunMasuk;
	}


	public Integer getTahunLulus() {
		return tahunLulus;
	}


	public void setTahunLulus(Integer tahunLulus) {
		this.tahunLulus = tahunLulus;
	}


	public PersonEntity getPersonEntity() {
		return personEntity;
	}


	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}
}
