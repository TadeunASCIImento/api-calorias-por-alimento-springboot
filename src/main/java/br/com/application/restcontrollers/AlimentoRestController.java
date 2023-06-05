package br.com.application.restcontrollers;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.application.recursos.Alimento;
import br.com.application.repositories.AlimentoRepository;

@RestController
@RequestMapping("/api")
public class AlimentoRestController {

	@Autowired
	private AlimentoRepository repository;

	@GetMapping(value = "/calorias", produces = MediaType.APPLICATION_JSON)
	public List<Alimento> findAll(@PathParam("descricao") String descricao) {
		List<Alimento> alimentos = repository.findByDescricao(descricao);
		return alimentos;

	}

	@GetMapping(value = "/")
	public ModelAndView documentacao() {
		return new ModelAndView("index");
	}

}
