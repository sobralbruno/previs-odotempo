package br.usjt.app_previsoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.usjt.app_previsoes.model.Previsao;

import br.usjt.app_previsoes.repository.PrevisoesRepository;

@Controller
public class PrevisoesController {

	@Autowired
	private PrevisoesRepository previsoesRepo;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/Previsoes";
	}

	@GetMapping("/Previsoes")
	public ModelAndView listarPrevisoes() {
		ModelAndView mv = new ModelAndView("Previsoes");
		
		List<Previsao> previsoes = previsoesRepo.findAll();
		mv.addObject("previsoes", previsoes);
		
		mv.addObject(new Previsao());
		
		return mv;
	}
	
	@PostMapping("/Previsoes")
	public String salvarPrevisao(Previsao previsao) {
		previsoesRepo.save(previsao);
		
		return "redirect:/Previsoes";
	}
}
