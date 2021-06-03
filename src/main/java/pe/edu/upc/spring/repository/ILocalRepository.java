package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Local;

@Repository
public interface ILocalRepository extends JpaRepository<Local, Integer>{

	@Query("from Local l where l.nombreLocal like %:nombreLocal%")
	List<Local>buscarLocal(@Param("nombreLocal") String nombreLocal);
}
