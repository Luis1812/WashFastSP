package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Administrador;
import pe.edu.upc.spring.repository.IAdministradorRepository;
import pe.edu.upc.spring.service.IAdministradorService;

@Service
public class AdministradorServiceImpl implements IAdministradorService {

	@Autowired
	private IAdministradorRepository aAdministrador;
	
	@Override
	@Transactional
	public Boolean insertar(Administrador administrador) {
		Administrador objAdministrador= aAdministrador.save(administrador);
		if(objAdministrador != null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Administrador administrador) {
		boolean flag = false;
		try {
			aAdministrador.save(administrador);
			flag=true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idAdministrador) {
			aAdministrador.deleteById(idAdministrador);
	}

	@Override
	public Optional<Administrador> listarId(int idAdministrador) {
		return aAdministrador.findById(idAdministrador);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Administrador> listar() {
		return aAdministrador.findAll();
	}
	
	@Override
	public Optional<Administrador> buscarId(int idAdministrador) {
		return aAdministrador.findById(idAdministrador);
	}

}
