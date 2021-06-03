package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Prenda;

public interface IPrendaService {
	public boolean insetar(Prenda prenda);
	public boolean modificar(Prenda prenda);
	public void eliminar(int idPrenda);
	public Optional<Prenda> listarId(int idPrenda);
	List<Prenda> listar();
	List<Prenda> buscarNombre(String namePrenda);

}
