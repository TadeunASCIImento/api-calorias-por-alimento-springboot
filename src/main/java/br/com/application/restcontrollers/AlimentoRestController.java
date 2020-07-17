package br.com.application.restcontrollers;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.application.recursos.Alimento;
import br.com.application.repositories.AlimentoRepository;

@RestController
@RequestMapping("/api")
public class AlimentoRestController {

	@Autowired
	private AlimentoRepository repository;

	@RequestMapping(value = "/calorias", method = RequestMethod.GET)
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alimento> findAll(@PathParam("descricao") String descricao) {
		List<Alimento> alimentos = repository.findByDescricao(descricao);
		return alimentos;

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView documentacao() {
		return new ModelAndView("index");
	}

}
