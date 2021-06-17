package pe.edu.upc.spring.controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Detalle;
import pe.edu.upc.spring.model.Pedido;
import pe.edu.upc.spring.service.IDetalleService;
import pe.edu.upc.spring.service.IPedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private IPedidoService pService;
	
	@Autowired
	private IDetalleService dService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPedidos(Map<String, Object> model) {
		model.put("listaPedidos", pService.listar());
		return "listPedidos";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroPedido(Model model) {
		model.addAttribute("listaDetalles", dService.listar());
		
		model.addAttribute("deatalle", new Detalle());
		model.addAttribute("pedido", new Pedido());
		return "pedido";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Pedido objPedido, BindingResult binRes, Model model){
		if (binRes.hasErrors())
		{ 
			model.addAttribute("listaDetalle", dService.listar());
			return "pedido";
		}
		else {
			boolean flag = pService.insertar(objPedido);
			if(flag)
				return "redirect:/pedido/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/pedido/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Pedido> objPedido=pService.buscarId(id);
		if(objPedido== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/pedido/listar";
		}else {
			model.addAttribute("listaDetalle",dService.listar());
			if(objPedido.isPresent())
				objPedido.ifPresent(o->model.addAttribute("PEDIDO",o));
			return "pedido";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar (Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaPedido", pService.listar());
			}
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPedido", pService.listar());
		}
		return "listPedidos";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaPedidos",pService.listar());
		return "listPedidos";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Pedido pedido) throws ParseException {
		pService.listarId(pedido.getIdPedido());
		return "listPedidos";
	}
}
