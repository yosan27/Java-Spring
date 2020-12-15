package id.training.latihanSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//	Create Table
@Table(name = "person_entity")
public class PersonEntity {
//	Primary
	@Id
//	Auto Increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Make Column
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name", length = 50 , nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 50 , nullable = false)
	private String lastName;
	
	public Integer getId() {
		return id;
	}
	
//	Setter & Getter
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

	public PersonEntity(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public PersonEntity() {
		super();
	}
}
