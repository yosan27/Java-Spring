package id.training.latihanSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.training.latihanSpring.entity.DetailPersonEntity;

@Repository
public interface DetailPersonRepository extends JpaRepository<DetailPersonEntity, Integer>{

}
