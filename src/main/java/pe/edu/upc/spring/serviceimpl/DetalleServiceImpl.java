package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Detalle;
import pe.edu.upc.spring.service.IDetalleService;
import pe.edu.upc.spring.repository.IDetalleRepository;

@Service
public class DetalleServiceImpl implements IDetalleService{

	@Autowired
	private IDetalleRepository dDetalle;
	
	@Override
	@Transactional
	public Boolean insertar(Detalle detalle) {
		Detalle objDetalle =dDetalle.save(detalle);
		if(objDetalle == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Detalle detalle) {
		boolean flag = false;
		try {
			dDetalle.save(detalle);
			flag=true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDetalle) {
		dDetalle.deleteById(idDetalle);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Detalle> listarId(int idDetalle) {
		return dDetalle.findById(idDetalle);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Detalle> listar() {
		return dDetalle.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Detalle> buscarId(int idDetalle) {
		return dDetalle.findById(idDetalle);
	}

}
