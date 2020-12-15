package id.training.latihanSpring.dto;

public class DetailPersonDto {
	private Integer id;
	private String domisili;
	private Integer usia;
	private String tanggalLahir;
	private String hobi;
	private String jenisKelamin;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	
	public DetailPersonDto(Integer id, String domisili, Integer usia, String tanggalLahir, String hobi,
			String jenisKelamin) {
		super();
		this.id = id;
		this.domisili = domisili;
		this.usia = usia;
		this.tanggalLahir = tanggalLahir;
		this.hobi = hobi;
		this.jenisKelamin = jenisKelamin;
	}
	
	
	public DetailPersonDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
