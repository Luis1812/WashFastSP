package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Reclamo;
import pe.edu.upc.spring.repository.IReclamoRepository;
import pe.edu.upc.spring.service.IReclamoService;

@Service
public class ReclamoServiceImpl implements IReclamoService {

	@Autowired
	private IReclamoRepository rReclamo;
	
	@Override
	@Transactional
	public Boolean insertar(Reclamo reclamo) {
		Reclamo objReclamo= rReclamo.save(reclamo);
		if(objReclamo!=null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Reclamo reclamo) {
		boolean flag = false;
		try {
			rReclamo.save(reclamo);
			flag = true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idReclamo) {
			rReclamo.deleteById(idReclamo);
	}


	@Override
	public Optional<Reclamo> listarId(int idReclamo) {
		return rReclamo.findById(idReclamo);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Reclamo> listar() {
		return rReclamo.findAll();
	}

	@Override
	public Optional<Reclamo> buscarId(int idReclamo) {
		return rReclamo.findById(idReclamo);
	}

//	@Override
//	@Transactional
//	public List<Pet> buscarNombre(String namePet) {
//		return dPet.buscarNombre(namePet);
//	}
//
//	@Override
//	@Transactional
//	public List<Pet> buscarRaza(String nameRace) {
//		return dPet.buscarNombre(nameRace);
//	}
//
//	@Override
//	@Transactional
//	public List<Pet> buscarDueno(String nameDueno) {
//		return dPet.buscarPropietario(nameDueno);
//	}
//	
	
	
}
