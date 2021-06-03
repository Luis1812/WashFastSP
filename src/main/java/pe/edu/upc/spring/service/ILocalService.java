package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Local;

public interface ILocalService {
	public Boolean insertar(Local local);
	public boolean modificar (Local local);
	public void eliminar (int idLocal);
	public Optional<Local> listarId(int idLocal);
	public List<Local> listar();
	public Optional<Local> buscarId(int idLocal);
}
