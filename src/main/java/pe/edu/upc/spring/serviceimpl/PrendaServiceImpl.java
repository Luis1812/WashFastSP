package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Prenda;
import pe.edu.upc.spring.repository.IPrendaRepository;
import pe.edu.upc.spring.service.IPrendaService;

@Service
public class PrendaServiceImpl implements IPrendaService{
	
	@Autowired
	private IPrendaRepository dPrenda;

	@Override
	@Transactional
	public boolean insetar(Prenda prenda) {
		Prenda objPrenda =dPrenda.save(prenda);
		if(objPrenda == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Prenda prenda) {
		boolean flag = false;
		try {
			dPrenda.save(prenda);
			flag=true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPrenda) {
		dPrenda.deleteById(idPrenda);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Prenda> listarId(int idPrenda) {
		return dPrenda.findById(idPrenda);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Prenda> listar() {
		return dPrenda.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Prenda> buscarNombre(String namePrenda) {
		return dPrenda.buscarNombre(namePrenda);
	}
	

}
