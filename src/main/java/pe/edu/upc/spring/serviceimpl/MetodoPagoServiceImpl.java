package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.MetodoPago;
import pe.edu.upc.spring.repository.IMetodoPagoRepository;
import pe.edu.upc.spring.service.IMetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements IMetodoPagoService {

	@Autowired
	private IMetodoPagoRepository mpMetodopago;
	
	
	@Override
	@Transactional
	public boolean insertar(MetodoPago metodopago) {
		MetodoPago objMetodopago= mpMetodopago.save(metodopago);
		if(objMetodopago== null)
			return false;
		else
			return true;
		
	}

	@Override
	@Transactional
	public boolean modificar(MetodoPago metodopago) {
		boolean flag =  false;
		try {
			mpMetodopago.save(metodopago);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idMetodopago) {
		mpMetodopago.deleteById(idMetodopago);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MetodoPago> listarId(int idMetodopago) {
		return mpMetodopago.findById(idMetodopago);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MetodoPago> listar() {
		return mpMetodopago.findAll();
	}

}
