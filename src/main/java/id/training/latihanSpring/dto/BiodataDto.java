package id.training.latihanSpring.dto;

public class BiodataDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private String domisili;
	private Integer usia;
	private String tanggalLahir;
	private String hobi;
	private String jenisKelamin;
	private Integer personId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDomisili() {
		return domisili;
	}
	public void setDomisili(String domisili) {
		this.domisili = domisili;
	}
	public Integer getUsia() {
		return usia;
	}
	public void setUsia(Integer usia) {
		this.usia = usia;
	}
	public String getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getHobi() {
		return hobi;
	}
	public void setHobi(String hobi) {
		this.hobi = hobi;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
}
