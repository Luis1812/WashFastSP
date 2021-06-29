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
import pe.edu.upc.spring.model.Prenda;
import pe.edu.upc.spring.model.Servicio;
import pe.edu.upc.spring.service.IDetalleService;
import pe.edu.upc.spring.service.IPrendaService;
import pe.edu.upc.spring.service.IServicioService;

@Controller
@RequestMapping("/detalle")
public class DetalleController {
	
	@Autowired
	private IDetalleService dService;
	
	@Autowired
	private IPrendaService prService;
	
	@Autowired
	private IServicioService sService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDetalle(Map<String, Object> model) {
		model.put("listaDetalles", dService.listar());
		return "listDetalle";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroDetalle(Model model) {
		//
		model.addAttribute("listaPrendas", prService.listar());
		model.addAttribute("listaServicios", sService.listar());
		//
		model.addAttribute("prenda", new Prenda());
		model.addAttribute("servicio", new Servicio());
		model.addAttribute("detalle", new Detalle());
	
		return "detalle";
	}
	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Detalle objDetalle, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
		{ 
			//
			model.addAttribute("listaPrendas", prService.listar());
			model.addAttribute("listaServicios", sService.listar());
			//
			return "detalle";
		}
		else {
			boolean flag = dService.insertar(objDetalle);
			if(flag)
				return "redirect:/detalle/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/detalle/irRegistrar";
			}
		}
		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Detalle> objDetalle=dService.buscarId(id); //
		if(objDetalle== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/detalle/listar";
		}else {
			//
			model.addAttribute("listaPrendas", prService.listar());
			model.addAttribute("listaServicios", sService.listar());
			//
			if(objDetalle.isPresent())
				objDetalle.ifPresent(o->model.addAttribute("detalle",o));
						
			return "detalle";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				dService.eliminar(id);
				model.put("listaDetalles", dService.listar());

			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDetalles", dService.listar());
		}
		return "listDetalle";
	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaDetalles", dService.listar());
		return "listDetalle";
	}
	
	//
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Detalle detalle) throws ParseException {
		dService.listarId(detalle.getIdDetalle());
		return "listDetalle";
	}

}
