package pe.edu.upc.spring.repository;

//import java.util.Date;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Reclamo;


@Repository
public interface IReclamoRepository extends JpaRepository<Reclamo, Integer> {
	
}
