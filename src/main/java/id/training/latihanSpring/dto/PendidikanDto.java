package id.training.latihanSpring.dto;

public class PendidikanDto {
	private Integer id;
	private String level;
	private String institusi;
	private Integer tahunMasuk;
	private Integer tahunLulus;
	private Integer personId;
	
	
	public PendidikanDto(Integer id, String level, String institusi, Integer tahunMasuk, Integer tahunLulus,
			Integer personId) {
		super();
		this.id = id;
		this.level = level;
		this.institusi = institusi;
		this.tahunMasuk = tahunMasuk;
		this.tahunLulus = tahunLulus;
		this.personId = personId;
	}


	public PendidikanDto() {
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


	public Integer getPersonId() {
		return personId;
	}


	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
}
