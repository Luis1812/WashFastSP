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

import pe.edu.upc.spring.model.MetodoPago;
import pe.edu.upc.spring.service.IMetodoPagoService;

	@Controller
	@RequestMapping("/metodopago")
	public class MetodoPagoController {
	
	@Autowired
	private IMetodoPagoService mpService;
	
	@RequestMapping("/bienvenido")
	public String irBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irMetodopago(Map<String, Object> model) {
		model.put("listaMetodopagos", mpService.listar());
		return "listMetodopago";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("metodopago", new MetodoPago());
		return "metodopago";
	}
	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute MetodoPago objMetodopago, BindingResult binRes,Model model) throws ParseException {
		if (binRes.hasErrors()) 
			return "metodopago";
		else {
			boolean flag = mpService.insertar(objMetodopago);
			if(flag)
				return "redirect:/metodopago/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/metodopago/irRegistrar";
			}
		}
		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<MetodoPago> objMetodopago = mpService.listarId(id);
		if(objMetodopago== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/metodopago/listar";
		}else {
			model.addAttribute("metodopago", objMetodopago);
			return "metodopago";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				mpService.eliminar(id);
				model.put("listaMetodopagos", mpService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaMetodopagos", mpService.listar());
		}
		return "listMetodopago";
	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaMetodopagos", mpService.listar());
		return "listMetodopago";
	}
}
