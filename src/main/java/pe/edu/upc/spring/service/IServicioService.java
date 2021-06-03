package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Servicio;

public interface IServicioService {
	public boolean insertar(Servicio servicio);
	public boolean modificar(Servicio servicio);
	public void eliminar(int idPrenda);
	public Optional<Servicio> listarId(int idServicio);
	List<Servicio> listar();
	List<Servicio> buscarNombre(String tipoServicio);

}
