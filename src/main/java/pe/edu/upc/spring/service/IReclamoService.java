package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Reclamo;

public interface IReclamoService {
	public Boolean insertar(Reclamo reclamo);
	public boolean modificar (Reclamo reclamo);
	public void eliminar (int idReclamo);
	public Optional<Reclamo> listarId(int idReclamo);
	public List<Reclamo> listar();
	public Optional<Reclamo> buscarId(int idReclamo);
//	public List<Pet> buscarNombre(String namePet);
//	public List<Pet> buscarRaza(String nameRace);
//	public List<Pet> buscarDueno(String nameDueno);
//	
}
