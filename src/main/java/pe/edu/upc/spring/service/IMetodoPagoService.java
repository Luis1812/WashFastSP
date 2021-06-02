package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.MetodoPago;

public interface IMetodoPagoService {
	public boolean insertar(MetodoPago metodopago);
	public boolean modificar (MetodoPago metodopago);
	public void eliminar (int idMetodopago);
	public Optional<MetodoPago> listarId(int idMetodopago);
	List<MetodoPago> listar();


	
	
}
