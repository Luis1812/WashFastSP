package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Local;
import pe.edu.upc.spring.repository.ILocalRepository;
import pe.edu.upc.spring.service.ILocalService;

@Service
public class LocalServiceImpl implements ILocalService {

	@Autowired
	private ILocalRepository lLocal;
	
	@Override
	@Transactional
	public Boolean insertar(Local local) {
		Local objLocal= lLocal.save(local);
		if(objLocal != null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Local local) {
		boolean flag = false;
		try {
			lLocal.save(local);
			flag=true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idLocal) {
			lLocal.deleteById(idLocal);
	}

	@Override
	public Optional<Local> listarId(int idLocal) {
		return lLocal.findById(idLocal);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Local> listar() {
		return lLocal.findAll();
	}
	
	@Override
	public Optional<Local> buscarId(int idLocal) {
		return lLocal.findById(idLocal);
	}

}
