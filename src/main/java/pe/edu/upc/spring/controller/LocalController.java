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

import pe.edu.upc.spring.model.Local;
import pe.edu.upc.spring.service.ILocalService;


@Controller
@RequestMapping("/local")
public class LocalController {		
	
	@Autowired
	private ILocalService lService;		
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoLocales(Map<String, Object> model) {
		model.put("listaLocales", lService.listar());
		return "listLocals";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroLocales(Model model) {		
		model.addAttribute("local", new Local());
		return "local";
	}	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Local objLocal, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
		{ 					
			return "local";
		}
		else {
			boolean flag = lService.insertar(objLocal);
			if(flag)
				return "redirect:/local/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/local/irRegistrar";
			}
		}		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException
	{
		Optional<Local> objLocal = lService.listarId(id);
		if(objLocal == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/local/listar";
		}
		else {
			model.addAttribute("local", objLocal);
			return "local";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				lService.eliminar(id);
				model.put("listaLocales", lService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaLocales", lService.listar());
		}
		return "listLocals";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaLocales", lService.listar());
		return "listLocals";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Local local) throws ParseException {
		lService.listarId(local.getIdLocal());
		return "listLocals";
	}	
	
}
