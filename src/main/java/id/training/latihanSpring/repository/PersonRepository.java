package id.training.latihanSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.training.latihanSpring.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
	@Query(value = "select * from person_entity where first_name = ?", nativeQuery = true)
		List<PersonEntity> findByFirstName(String firstName);
	
	@Query(value = "select * from person_entity where last_name = ?", nativeQuery = true)
		List<PersonEntity> findByLastName(String lastName);
		
	@Query(value = "select first_name from person_entity where id = ?", nativeQuery = true)
		String findFirstNameById(Integer id);
}
