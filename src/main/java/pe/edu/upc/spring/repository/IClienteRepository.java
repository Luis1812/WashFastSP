package pe.edu.upc.spring.repository;

//import java.util.Date;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Cliente;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
}
