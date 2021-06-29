package pe.edu.upc.spring.controller;

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

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Prenda;
import pe.edu.upc.spring.service.IPrendaService;

@Controller
@RequestMapping("/prenda")
public class PrendaController {
	
	@Autowired
	private IPrendaService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPrendas(Map<String,Object> model){
		model.put("listaPrendas", pService.listar());
		return "listPrenda";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("prenda", new Prenda());
		return "prenda";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Prenda objPrenda, BindingResult binRes, Model model)
		throws ParseException
	{
		if(binRes.hasErrors())
			return "race";
		else {
			boolean flag =pService.insetar(objPrenda);
			if(flag)
				return "redirect:/prenda/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/prenda/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
		throws ParseException
	{
		Optional<Prenda> objPrenda = pService.listarId(id);
		if(objPrenda == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/prenda/listar";
		}
		else {
			model.addAttribute("prenda", objPrenda);
			return "prenda";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id != null && id > 0) {
				pService.eliminar(id);
				model.put("listaPrendas", pService.listar());
			}
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPrendas", pService.listar());
		}
		return "listPrenda";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String,Object> model) {
		model.put("listaPrendas", pService.listar());
		return "listPrenda";
	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Prenda prenda) throws ParseException {
		pService.listarId(prenda.getIdPrenda());
		return "listPrenda";
	}	
}
