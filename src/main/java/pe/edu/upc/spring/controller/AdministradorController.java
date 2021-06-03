package pe.edu.upc.spring.controller;

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

import pe.edu.upc.spring.model.Administrador;
import pe.edu.upc.spring.service.IAdministradorService;


@Controller
@RequestMapping("/administrador")
public class AdministradorController {		
	
	@Autowired
	private IAdministradorService aService;		
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoAdministradores(Map<String, Object> model) {
		model.put("listaAdministradores", aService.listar());
		return "listAdministrators";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroAdministradores(Model model) {		
		model.addAttribute("administrador", new Administrador());
		return "administrador";
	}	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Administrador objAdministrador, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
		{ 					
			return "administrador";
		}
		else {
			boolean flag = aService.insertar(objAdministrador);
			if(flag)
				return "redirect:/administrador/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/administrador/irRegistrar";
			}
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException
	{
		Optional<Administrador> objAdministrador = aService.listarId(id);
		if(objAdministrador == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/administrador/listar";
		}
		else {
			model.addAttribute("administrador", objAdministrador);
			return "administrador";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				aService.eliminar(id);
				model.put("listaAdministradores", aService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaAdministradores", aService.listar());
		}
		return "listAdministrators";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaAdministradores", aService.listar());
		return "listAdministrators";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Administrador administrador) throws ParseException {
		aService.listarId(administrador.getIdAdministrador());
		return "listAdministrators";
	}	
	
}
