package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Administrador;

public interface IAdministradorService {
	public Boolean insertar(Administrador administrador);
	public boolean modificar (Administrador administrador);
	public void eliminar (int idLocal);
	public Optional<Administrador> listarId(int idAdministrador);
	public List<Administrador> listar();
	public Optional<Administrador> buscarId(int idAdministador);
}
