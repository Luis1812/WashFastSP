package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Cliente;

public interface IClienteService {
	public Boolean insertar(Cliente cliente);
	public boolean modificar (Cliente liente);
	public void eliminar (int idCliente);
	public Optional<Cliente> listarId(int idCliente);
	public List<Cliente> listar();
	public Optional<Cliente> buscarId(int idCliente);
//	public List<Pet> buscarNombre(String namePet);
//	public List<Pet> buscarRaza(String nameRace);
//	public List<Pet> buscarDueno(String nameDueno);
//	
}
