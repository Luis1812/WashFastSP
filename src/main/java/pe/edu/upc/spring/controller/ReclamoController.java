package pe.edu.upc.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Local;
import pe.edu.upc.spring.model.Cliente;
import pe.edu.upc.spring.model.Reclamo;

import pe.edu.upc.spring.service.ILocalService;
import pe.edu.upc.spring.service.IClienteService;
import pe.edu.upc.spring.service.IReclamoService;

@Controller
@RequestMapping("/reclamo")
public class ReclamoController {
	
	@Autowired
	private ILocalService lService;
	//	
	@Autowired
	private IClienteService cService;
	
	@Autowired
	private IReclamoService rService;
	
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoReclamo(Map<String, Object> model) {
		model.put("listaReclamos", rService.listar());
		return "listReclamos";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroReclamo(Model model) {
		//
		model.addAttribute("listaLocales", lService.listar());
		model.addAttribute("listaClientes", cService.listar());
		//
		model.addAttribute("local", new Local());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("reclamo", new Reclamo());
		
		return "reclamo";

	}
	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Reclamo objReclamo, BindingResult binRes,Model model) throws ParseException {
		if (binRes.hasErrors())
		{ 
			//
			model.addAttribute("listaLocales", lService.listar());
			model.addAttribute("listaClientes", cService.listar());
			//
			return "reclamo";
		}
		else {
			boolean flag = rService.insertar(objReclamo);
			if(flag)
				return "redirect:/reclamo/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/reclamo/irRegistrar";
			}
		}
		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Reclamo> objReclamo=rService.buscarId(id); //
		if(objReclamo== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/reclamo/listar";
		}else {
			//
			model.addAttribute("listaLocales", lService.listar());
			model.addAttribute("listaClientes", cService.listar());
			//
			if(objReclamo.isPresent())
				objReclamo.ifPresent(o->model.addAttribute("reclamo",o));
						
			return "reclamo";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaReclamos", rService.listar());

			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaReclamos", rService.listar());
		}
		return "listReclamos";
	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaReclamos", rService.listar());
		return "listReclamos";
	}
	
	//
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Reclamo reclamo) throws ParseException {
		rService.listarId(reclamo.getIdReclamo());
		return "listReclamos";
	}
//	
//	@RequestMapping("/irBuscar")
//	public String irBuscar(Model model) {
//		model.addAttribute("pet", new Pet());
//		return "buscar";
//	}
//	
//	@RequestMapping("/buscar")
//	public String buscar(Map<String, Object> model, @ModelAttribute Pet pet) throws ParseException {
//		List<Pet> listaMascotas;
//		pet.setNamePet(pet.getNamePet());
//		listaMascotas= pService.buscarNombre(pet.getNamePet());
//		
//		if(listaMascotas.isEmpty()) {
//			model.put("mensaje", "No existen coincidencias");
//		}
//		// else
//			model.put("listaMascotas", listaMascotas);
//		return "buscar";
//	}
	
}
