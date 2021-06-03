package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Pedido;
import pe.edu.upc.spring.repository.IPedidoRepository;
import pe.edu.upc.spring.service.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	private IPedidoRepository dPedido;

	@Override
	@Transactional
	public Boolean insertar(Pedido pedido) {
		Pedido objPedido =dPedido.save(pedido);
		if(objPedido == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Pedido pedido) {
		boolean flag = false;
		try {
			dPedido.save(pedido);
			flag=true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPedido) {
		dPedido.deleteById(idPedido);
	}

	@Override
	public Optional<Pedido> listarId(int idPedido) {
		return dPedido.findById(idPedido);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> listar() {
		return dPedido.findAll();
	}

	@Override
	public Optional<Pedido> buscarId(int idPedido) {
		return dPedido.findById(idPedido);
	}
	

}
