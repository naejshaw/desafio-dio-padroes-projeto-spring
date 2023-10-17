package one.digitalinnovation.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinnovation.gof.model.Autor;

@FeignClient()
public interface GeneroService {
	
	@GetMapping("/{genero}/json/")
	Autor consultarGenero(@PathVariable("genero") String genero);
}
